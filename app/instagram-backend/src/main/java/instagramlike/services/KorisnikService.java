package instagramlike.services;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import instagramlike.models.HashMD5;
import instagramlike.models.Korisnik;
import instagramlike.repositories.KorisnikRepository;

@Service
@Transactional
public class KorisnikService {
    
    @Autowired
    KorisnikRepository repository;
  
    public Iterable<Korisnik> findAllKorisnici() {
        return repository.findAll();
    }
    
	public Korisnik findByUsername (String username) {
		return repository.findByKorisnickoIme(username);
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
			korisnik.setKorisnickaSifra(HashMD5.getMD5(newPassword));
		
		this.repository.save(korisnik);
		return true;
	}
	
	public Korisnik findByKorisnikId(Integer id) {
		return repository.findByKorisnikId(id);
	}
	
	public boolean registerKorisnik(Korisnik korisnik) {
		
		if(repository.findByKorisnickoIme(korisnik.getKorisnickoIme()) != null) {
            //throw new ServiceException("Korisnik sa datim username-om vec postoji!");
			return false; //da se ne moramo baviti hendlanjem izuzetaka
        }
		
        //Napomena: ne hesira 2x jer se hesiranje radi ovdje pri spremanju korisnika u bazu
		if(korisnik.getKorisnickaSifra() != null)
			//da se može pozvati getMD5
			korisnik.setKorisnickaSifra(HashMD5.getMD5(korisnik.getKorisnickaSifra()));
        return repository.save(korisnik) != null;
	}
	
	public Korisnik updateKorisnik(Korisnik korisnik) {
		Korisnik k = repository.findByKorisnickoIme(korisnik.getKorisnickoIme());
		//save metoda se koristi za update i delete i odlučuje se prema id-u
		//ako je id isti kao neki postojeći onda se koristi za update automatski
		//spring to gleda pomoću @Id anotacije
		//stoga, kako se ovdje id ne šalje u requestbody-ju, ovo je mali hack kako bi metoda radila kako treba
		
		//VALIDACIJU RADITI U FRONTU
		korisnik.setKorisnikId(k.getKorisnikId());
		korisnik.setKorisnickaSifra(HashMD5.getMD5(korisnik.getKorisnickaSifra()));
		return this.repository.save(korisnik);
	}
	
	public Integer removeKorisnik(String userName) {
		Integer result = this.repository.deleteByKorisnickoIme(userName);
		return result;
	}
}