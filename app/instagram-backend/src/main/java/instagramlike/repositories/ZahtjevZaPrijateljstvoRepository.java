package instagramlike.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import instagramlike.models.ZahtjevZaPrijateljstvo;
@Repository
public interface ZahtjevZaPrijateljstvoRepository  extends CrudRepository<ZahtjevZaPrijateljstvo, Integer> {
	public List<ZahtjevZaPrijateljstvo> findAll();
	public List<ZahtjevZaPrijateljstvo> findAllByKorisnikID(Integer ID);
	public ZahtjevZaPrijateljstvo findByid(Integer ID);
	public Boolean deleteByKorisnikID(Integer ID);
	public Boolean deleteByid(Integer ID);
}
