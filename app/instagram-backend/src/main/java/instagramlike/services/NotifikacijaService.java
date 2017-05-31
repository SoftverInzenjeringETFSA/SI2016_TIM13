package instagramlike.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import instagramlike.models.Notifikacija;
import instagramlike.repositories.NotifikacijaRepository;

public class NotifikacijaService {
	
	@Autowired
	NotifikacijaRepository repo;
	
	public void addNotification(Notifikacija notif) {
		repo.save(notif);
	}
	
	public void updateNotification(Notifikacija notif) {
		repo.save(notif);
	}
	
	public Boolean deleteNotificationById(Integer ID) {
		return repo.deleteById(ID);
	}
	
	public Boolean deleteNotificationsByUserID(Integer ID) {
		return repo.deleteByKorisnikID(ID);
	}
	
	public List<Notifikacija> findAllNotifications() {
		return repo.findAll();
	}
	
	public Notifikacija findNotificationById(Integer ID) {
		return repo.findById(ID);
	}
	
	public List<Notifikacija> findNotificationsByUserID(Integer ID) {
		return repo.findByKorisnikID(ID);
	}
	
}
