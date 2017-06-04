package instagramlike.services;

import static org.mockito.Matchers.intThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import instagramlike.models.Fotografija;
import instagramlike.repositories.FotografijaRepository;

@Service
public class FotografijaService {
	
	@Autowired
	FotografijaRepository fotoRepository;
	
	public void addPhoto(Fotografija photo) {
		fotoRepository.save(photo);
	}
	
	public Boolean removeByKorisnikID(Integer ID) {
		return fotoRepository.deleteByKorisnikID(ID);
	}
	
	public void updatePhoto(Fotografija photo) {
		fotoRepository.save(photo);
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
	
	public Boolean removeById(Integer ID) {
		return fotoRepository.deleteById(ID);
	}
	
}
