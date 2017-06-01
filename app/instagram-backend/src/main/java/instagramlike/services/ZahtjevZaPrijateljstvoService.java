package instagramlike.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import instagramlike.models.ZahtjevZaPrijateljstvo;
import instagramlike.repositories.ZahtjevZaPrijateljstvoRepository;

public class ZahtjevZaPrijateljstvoService {

	@Autowired
	ZahtjevZaPrijateljstvoRepository repo;
	
	
	public List<ZahtjevZaPrijateljstvo> findAllRequests() {
		return repo.findAll();
	}
	
	public List<ZahtjevZaPrijateljstvo> findRequestsByUserID(Integer ID) {
		return repo.findAllByKorisnikID(ID);
	}
	
	public ZahtjevZaPrijateljstvo findRequestsByID(Integer ID) {
		return repo.findByid(ID);
	}
	
	public Boolean deleteRequestById(Integer ID) {
		return repo.deleteByid(ID);
	}
	
	public Boolean deleteRequestByUserID(Integer ID) {
		return repo.deleteByKorisnikID(ID);
	}
	
	
	
	public void updateRequest(ZahtjevZaPrijateljstvo ab) {
		repo.save(ab);
	}
	
	
	public void addRequest(ZahtjevZaPrijateljstvo ab) {
		repo.save(ab);
	}
	
	
	
}
