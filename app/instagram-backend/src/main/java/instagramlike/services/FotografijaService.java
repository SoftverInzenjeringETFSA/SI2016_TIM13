package instagramlike.services;

import static org.mockito.Matchers.intThat;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import instagramlike.models.Fotografija;
import instagramlike.repositories.FotografijaRepository;

@Service
@Transactional
public class FotografijaService {
	
	@Autowired
	FotografijaRepository fotoRepository;
	
	public void addPhoto(Fotografija photo) {
		fotoRepository.save(photo);
	}
	
	public Integer removeByKorisnikID(Integer ID) {
		return fotoRepository.deleteByKorisnikID(ID);
	}
	
	public Boolean updatePhoto(Fotografija photo) {
		fotoRepository.save(photo);
		return true;
	}
	
	public Iterable<Fotografija> findAll() {
		return fotoRepository.findAll();
	}
	
	public Fotografija findyByKorisnikID(Integer ID) {
		return fotoRepository.findByKorisnikID(ID);
	}
	
	public Fotografija findPhotoById(Integer ID) {
		return fotoRepository.findById(ID);
	}
	
	public Integer removeById(Integer ID) {
		return fotoRepository.deleteById(ID);
	}
	
}
