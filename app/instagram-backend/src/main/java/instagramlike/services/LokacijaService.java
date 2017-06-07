package instagramlike.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import instagramlike.models.Lokacija;
import instagramlike.repositories.LokacijaRepository;

@Service
@Transactional
public class LokacijaService {

	@Autowired
	LokacijaRepository repo;
	
	public void addLocation(Lokacija location) {
		repo.save(location);
	}
	
	public Boolean updateLocation(Lokacija location, Lokacija newLocation) {
		repo.save(location);
		return true;
	}
	
	public Integer deleteLocationById(Integer ID) {
		return repo.deleteByid(ID);
	}
	
	public Integer deleteLocationByName(String name) {
		return repo.deleteBynaziv(name);
	}
	
	public List<Lokacija> getAllLocations() {
		return repo.findAll();
	}
	
	public Lokacija getLocationById(Integer ID) {
		return repo.findByid(ID);
	}
	
	public Lokacija getLocationByName(String name) {
		return repo.findBynaziv(name);
	}
	
}
