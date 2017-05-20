package services;


import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import models.Korisnik;
import repositories.KorisnikRepository;

@Service
public class KorisnikService {
    
    @Autowired
    KorisnikRepository repository;
  
    public Iterable<Korisnik> findAllKorisnici() {
        return repository.findAll();
    }
    
    public Korisnik findOne(Integer id) {
    	return repository.findOne(id);
	}

	public Korisnik findByUsername (String username)	{return repository.findByKorisnickoIme(username);}

	public void addKorisnik (Korisnik korisnik) {
		repository.save(korisnik);
	}
	
	public void removeKorisnik (int id) {
		repository.delete(id);
	}
	
	public Boolean updateKorisnik (Korisnik korisnik) {
		repository.save(korisnik);
		return true;
	}
	
	public Boolean registerKorisnik(Korisnik korisnik) {
		
		if(repository.findByKorisnickoIme(korisnik.getKorisnickoIme()) != null) {
            throw new ServiceException("Korisnik sa datim username-om vec postoji!");
        }

        Korisnik kreiranKorisnik = repository.save(korisnik);

        return kreiranKorisnik != null;
	}
}