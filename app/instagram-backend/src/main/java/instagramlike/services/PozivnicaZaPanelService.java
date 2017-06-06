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
	
	public Boolean updatePozivnicaZaPanel(PozivnicaZaPanel notif) {
		repo.save(notif);
		return true;
	}
	
	public Boolean deletePozivnicaZaPanelById(Integer ID) {
		return repo.deleteById(ID);
	}
	
	public Boolean deletePozivnicaZaPanelByPosiljaocID(Integer ID) {
		return repo.deleteByposiljaocID(ID);
	}
	
	public Boolean deletePozivnicaZaPanelByPrimaocID(Integer ID) {
		return repo.deleteByprimaocID(ID);
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
	
	public List<PozivnicaZaPanel> findPozivnicaZaPanelByPrimaocId(Integer ID) {
		return repo.findByposiljaocID(ID);
	}
	

}
