package instagramlike.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import instagramlike.models.Prijateljstvo;
//import instagramlike.models.PozivnicaZaPanel;

@Repository
public interface PrijateljstvoRepository extends CrudRepository<Prijateljstvo, Integer> {
	
	public List<Prijateljstvo> findAll();
	public Prijateljstvo findByid(Integer ID);

	public List<Prijateljstvo> findBykorisnik1ID(Integer ID);
	public List<Prijateljstvo> findBykorisnik2ID(Integer ID);
	public Boolean deleteById(Integer ID);
	public Boolean deleteBykorisnik1ID(Integer ID);
	public Boolean deleteBykorisnik2ID(Integer ID);

}
