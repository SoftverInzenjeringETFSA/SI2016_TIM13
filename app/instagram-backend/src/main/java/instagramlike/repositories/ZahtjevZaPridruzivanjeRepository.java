package instagramlike.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import instagramlike.models.ZahtjevZaPridruzivanje;

@Repository
public interface  ZahtjevZaPridruzivanjeRepository extends CrudRepository<ZahtjevZaPridruzivanje, Integer>  {
	public List<ZahtjevZaPridruzivanje> findAll();
	public List<ZahtjevZaPridruzivanje> findAllBykorisnikID(Integer ID);
	public Boolean deleteByid(Integer ID);
	public Boolean deleteBykorisnikID(Integer ID);
	
}
