package instagramlike.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import instagramlike.models.Lokacija;

public interface LokacijaRepository extends CrudRepository<Lokacija, Integer> {
	
	public List<Lokacija> findAll();
	public Lokacija findByid(Integer ID);
	public Lokacija findBynaziv(String naziv);
	public Integer deleteByid(Integer ID);
	public Integer deleteBynaziv(String naziv);
	
}
