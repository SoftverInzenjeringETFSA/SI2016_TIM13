package instagramlike.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import instagramlike.models.Prijateljstvo;
import instagramlike.repositories.PrijateljstvoRepository;

public class PrijeteljstvoServices {
	
	@Autowired
	PrijateljstvoRepository repo;
	
	public void addPozivnicaZaPanel(Prijateljstvo notif) {
		repo.save(notif);
	}
	
	public void updatePozivnicaZaPanel(Prijateljstvo notif) {
		repo.save(notif);
	}
	
	public Boolean deletePozivnicaZaPanelById(Integer ID) {
		return repo.deleteById(ID);
	}
	
	public Boolean deletePozivnicaZaPanelByID(Integer ID) {
		return repo.deleteById(ID);
	}
	public Boolean deleteByKorisnik1ID(Integer ID) {
		return repo.deleteBykorisnik1ID( ID);
	}
	public Boolean deleteByKorisnik2ID(Integer ID) {
		return repo.deleteBykorisnik2ID( ID);
	}
	public List<Prijateljstvo> findAllPrijateljstva() {
		return repo.findAll();
	}
	
	

}
