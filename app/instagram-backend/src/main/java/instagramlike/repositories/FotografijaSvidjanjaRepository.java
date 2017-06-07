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
	public Integer deleteById(Integer ID);
	public Integer deleteByKorisnikID(Integer ID);
	public Integer deleteByFotoID(Integer ID);
	
}
