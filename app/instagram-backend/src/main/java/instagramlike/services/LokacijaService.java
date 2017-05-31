package instagramlike.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import instagramlike.models.Lokacija;
import instagramlike.repositories.LokacijaRepository;

public class LokacijaService {

	@Autowired
	LokacijaRepository repo;
	
	public void addLocation(Lokacija location) {
		repo.save(location);
	}
	
	public void updateLocation(Lokacija location, Lokacija newLocation) {
		repo.save(location);
	}
	
	public Boolean deleteLocationById(Integer ID) {
		return repo.deleteByid(ID);
	}
	
	public Boolean deleteLocationByName(String name) {
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
