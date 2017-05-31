package instagramlike.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import instagramlike.models.FotografijaSvidjanja;

@Repository
public interface FotografijaSvidjanjaRepository extends CrudRepository<FotografijaSvidjanja, Integer> {
	
	public FotografijaSvidjanja findByid(Integer ID);
	public List<FotografijaSvidjanja> findByKorisnikID(Integer ID);
	public List<FotografijaSvidjanja> findByFotoID(Integer ID);
	public Boolean deleteById(Integer ID);
	public Boolean deleteByKorisnikID(Integer ID);
	public Boolean deleteByFotoID(Integer ID);
	
}
