package instagramlike.services;

import org.springframework.beans.factory.annotation.Autowired;

import instagramlike.models.Fotografija;
import instagramlike.repositories.FotografijaRepository;

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
