package instagramlike.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import instagramlike.models.Notifikacija;

@Repository
public interface NotifikacijaRepository extends CrudRepository<Notifikacija, Integer> {
	
	public List<Notifikacija> findAll();
	public Notifikacija findById(Integer ID);
	public List<Notifikacija> findByKorisnikID(Integer ID);
	public Integer deleteById(Integer ID);
	public Integer deleteByKorisnikID(Integer ID);

}
