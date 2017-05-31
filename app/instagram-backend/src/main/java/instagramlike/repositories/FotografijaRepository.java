package instagramlike.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import instagramlike.models.Fotografija;

@Repository
public interface FotografijaRepository extends CrudRepository<Fotografija, Integer> {
	
	public Fotografija findById(Integer ID);
	public Fotografija findByKorisnikID(Integer ID);//pretraga fotografija prema id-u korisnika
	public List<Fotografija> findAll();
	public Boolean deleteById(Integer ID);
	public Boolean deleteByKorisnikID(Integer ID);

} 