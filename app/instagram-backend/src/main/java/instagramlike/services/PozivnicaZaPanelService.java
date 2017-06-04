package instagramlike.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import instagramlike.models.PozivnicaZaPanel;
import instagramlike.repositories.PozivnicaZaPanelRepository;

@Service
public class PozivnicaZaPanelService {
	
	@Autowired
	PozivnicaZaPanelRepository repo;
	
	public void addPozivnicaZaPanel(PozivnicaZaPanel notif) {
		repo.save(notif);
	}
	
	public void updatePozivnicaZaPanel(PozivnicaZaPanel notif) {
		repo.save(notif);
	}
	
	public Boolean deletePozivnicaZaPanelById(Integer ID) {
		return repo.deleteById(ID);
	}
	
	public Boolean deletePozivnicaZaPanelByID(Integer ID) {
		return repo.deleteById(ID);
	}
	public Boolean deletePozivnicaZaPanelByPosiljaocID(Integer ID) {
		return repo.deleteByposiljaocID(ID);
	}
	
	public List<PozivnicaZaPanel> findAllPozivnicaZaPanels() {
		return repo.findAll();
	}
	
	public PozivnicaZaPanel findPozivnicaZaPanelById(Integer ID) {
		return repo.findById(ID);
	}
	public List<PozivnicaZaPanel> findPozivnicaZaPanelByPosiljaocId(Integer ID) {
		return repo.findByposiljaocID(ID);
	}
	

}
