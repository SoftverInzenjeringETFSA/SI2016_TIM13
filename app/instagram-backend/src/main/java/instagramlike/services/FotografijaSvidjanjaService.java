package instagramlike.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import instagramlike.models.FotografijaSvidjanja;
import instagramlike.repositories.FotografijaSvidjanjaRepository;

@Service
@Transactional
public class FotografijaSvidjanjaService {
	
	@Autowired
	FotografijaSvidjanjaRepository repo;
	
	public void addFotografijaSvidjanja(FotografijaSvidjanja fs) {
		repo.save(fs);
	}
	
	public FotografijaSvidjanja getById(Integer ID) {
		return repo.findByid(ID);
	}
	
	public List<FotografijaSvidjanja> findByKorisnikID(Integer ID) {
		return repo.findByKorisnikID(ID);
	}
	
	public List<FotografijaSvidjanja> findByFotoID(Integer ID) {
		return repo.findByFotoID(ID);
	}
	
	public Integer deleteById(Integer ID) {
		return repo.deleteById(ID);
	}
	
	public Integer deleteByKorisnikID(Integer ID) {
		return repo.deleteByKorisnikID(ID);
	}
	
	public Integer deleteByFotoID(Integer ID) {
		return repo.deleteByFotoID(ID);
	}
	
}
