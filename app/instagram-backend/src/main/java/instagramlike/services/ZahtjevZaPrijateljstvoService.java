package instagramlike.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import instagramlike.models.ZahtjevZaPrijateljstvo;
import instagramlike.repositories.ZahtjevZaPrijateljstvoRepository;

@Service
public class ZahtjevZaPrijateljstvoService {

	@Autowired
	ZahtjevZaPrijateljstvoRepository repo;
	
	
	public List<ZahtjevZaPrijateljstvo> findAllRequests() {
		return repo.findAll();
	}
	
	public List<ZahtjevZaPrijateljstvo> findRequestsBySenderID(Integer ID) {
		return repo.findAllByposiljaocID(ID);
	}
	
	public List<ZahtjevZaPrijateljstvo> findRequestsByReceiverID(Integer ID) {
		return repo.findAllByprimaocID(ID);
	}
	
	public ZahtjevZaPrijateljstvo findRequestsByID(Integer ID) {
		return repo.findByid(ID);
	}
	
	public Boolean deleteRequestById(Integer ID) {
		return repo.deleteByid(ID);
	}
	
	public Boolean deleteRequestBySenderID(Integer ID) {
		return repo.deleteByposiljaocID(ID);
	}
	
	public Boolean deleteRequestByReceiverID(Integer ID) {
		return repo.deleteByprimaocID(ID);
	}
	
	
	
	public void updateRequest(ZahtjevZaPrijateljstvo ab) {
		repo.save(ab);
	}
	
	
	public void addRequest(ZahtjevZaPrijateljstvo ab) {
		repo.save(ab);
	}
	
	
	
}
