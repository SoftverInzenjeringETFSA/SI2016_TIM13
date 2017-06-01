package instagramlike.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import instagramlike.models.ZahtjevZaPridruzivanje;
import instagramlike.repositories.ZahtjevZaPridruzivanjeRepository;


public class ZahtjevZaPridruzivanjeService {
	
	@Autowired
	ZahtjevZaPridruzivanjeRepository repo;
	
	public List<ZahtjevZaPridruzivanje> findAllRequests() {
		return repo.findAll();
	}
	
	public List<ZahtjevZaPridruzivanje> findRequestsByUserID(Integer ID) {
		return repo.findAllByKorisnikID(ID);
	}
	
	public Boolean deleteRequestById(Integer ID) {
		return repo.deleteByid(ID);
	}
	
	public Boolean deleteRequestByUserID(Integer ID) {
		return repo.deleteByKorisnikID(ID);
	}
	
	public void updateRequest(ZahtjevZaPridruzivanje ab) {
		repo.save(ab);
	}
	
	
	public void addRequest(ZahtjevZaPridruzivanje ab) {
		repo.save(ab);
	}
	
	

}
