package instagramlike.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import instagramlike.models.Prijateljstvo;
import instagramlike.repositories.PrijateljstvoRepository;

@Service
@Transactional
public class PrijeteljstvoServices {
	
	@Autowired
	PrijateljstvoRepository repo;
	
	public void addPozivnicaZaPanel(Prijateljstvo notif) {
		repo.save(notif);
	}
	
	public void updatePozivnicaZaPanel(Prijateljstvo notif) {
		repo.save(notif);
	}
	
	public Integer deletePozivnicaZaPanelById(Integer ID) {
		return repo.deleteById(ID);
	}
	
	public Integer deletePozivnicaZaPanelByID(Integer ID) {
		return repo.deleteById(ID);
	}
	public Integer deleteByKorisnik1ID(Integer ID) {
		return repo.deleteBykorisnik1ID( ID);
	}
	public Integer deleteByKorisnik2ID(Integer ID) {
		return repo.deleteBykorisnik2ID( ID);
	}
	public List<Prijateljstvo> findAllPrijateljstva() {
		return repo.findAll();
	}
	
	

}
