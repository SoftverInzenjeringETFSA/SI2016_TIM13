package instagramlike.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import instagramlike.models.ZahtjevZaPridruzivanje;
import instagramlike.repositories.ZahtjevZaPridruzivanjeRepository;

@Service
public class ZahtjevZaPridruzivanjeService {
	
	@Autowired
	ZahtjevZaPridruzivanjeRepository repo;
	
	public List<ZahtjevZaPridruzivanje> findAllRequests() {
		return repo.findAll();
	}
	
	public List<ZahtjevZaPridruzivanje> findRequestsByUserID(Integer ID) {
		return repo.findAllBykorisnikID(ID);
	}
	
	public Boolean deleteRequestById(Integer ID) {
		return repo.deleteByid(ID);
	}
	
	public Boolean deleteRequestByUserID(Integer ID) {
		return repo.deleteBykorisnikID(ID);
	}
	
	public Boolean updateRequest(ZahtjevZaPridruzivanje ab) {
		repo.save(ab);
		return true;
		
	}
	
	
	public void addRequest(ZahtjevZaPridruzivanje ab) {
		repo.save(ab);
	}
	
	

}
