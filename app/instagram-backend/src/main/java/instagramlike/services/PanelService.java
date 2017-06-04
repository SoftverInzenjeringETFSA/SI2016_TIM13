package instagramlike.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import instagramlike.models.Panel;
import instagramlike.repositories.PanelRepository;

@Service
public class PanelService {
	
	@Autowired
	PanelRepository repo;
	
	public void addPanel(Panel notif) {
		repo.save(notif);
	}
	
	public void updatePanel(Panel notif) {
		repo.save(notif);
	}
	
	public Boolean deletePanelById(Integer ID) {
		return repo.deleteById(ID);
	}
	
	public Boolean deletePanelsByUserID(Integer ID) {
		return repo.deleteBykreatorID(ID);
	}
	
	public List<Panel> findAllPanels() {
		return repo.findAll();
	}
	
	public Panel findPanelById(Integer ID) {
		return repo.findById(ID);
	}
	
	public List<Panel> findPanelsByUserID(Integer ID) {
		return repo.findBykreatorID(ID);
	}
	
}
