package instagramlike.services;


import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import instagramlike.models.HashMD5;
import instagramlike.models.Korisnik;
import instagramlike.repositories.KorisnikRepository;

@Service
public class KorisnikService {
    
    @Autowired
    KorisnikRepository repository;
  
    public Iterable<Korisnik> findAllKorisnici() {
        return repository.findAll();
    }
    
	public Korisnik findByUsername (String username) {
		return repository.findByKorisnickoIme(username);
	}

	public void addKorisnik (Korisnik korisnik) {
		repository.save(korisnik);
	}
	
	public Boolean updateKorisnik (Korisnik korisnik) {
		repository.save(korisnik);
		return true;
	}

	public Boolean updateKorisnik(String userName, String newUserName, String newEmail, String newPassword) {
		//slati prazan string ukoliko nešto ne želimo mijenjati
		Korisnik korisnik = this.repository.findByKorisnickoIme(userName);
		
		if (korisnik == null)
			//ne postoji u bazi
			return false;
		
		if (newUserName != "")
			korisnik.setKorisnickoIme(newUserName);
		if (newEmail != "")
			korisnik.setEmail(newEmail);
		if (newPassword != "")
			korisnik.setKorisnickaSifraHash(HashMD5.getMD5(newPassword));
		
		this.repository.save(korisnik);
		return true;
	}
	
	public boolean registerKorisnik(Korisnik korisnik) {
		
		if(repository.findByKorisnickoIme(korisnik.getKorisnickoIme()) != null) {
            //throw new ServiceException("Korisnik sa datim username-om vec postoji!");
			return false; //da se ne moramo baviti hendlanjem izuzetaka
        }
        Korisnik kreiranKorisnik = repository.save(korisnik);
        //Napomena: ne hesira 2x jer se hesiranje radi ovdje pri spremanju korisnika u bazu
        kreiranKorisnik.setKorisnickaSifraHash(HashMD5.getMD5(korisnik.getKorisnickaSifraHash()));
        //return kreiranKorisnik != null;
        return true;
	}
	
	public Boolean removeKorisnik(String userName) {
		return this.repository.deleteByKorisnickoIme(userName);
	}
}