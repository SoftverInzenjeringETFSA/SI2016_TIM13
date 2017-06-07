package instagramlike.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import instagramlike.models.Korisnik;

@Repository
public interface KorisnikRepository extends CrudRepository<Korisnik, Integer> {
	
	public Korisnik findByEmail(String email);
	public Korisnik findByKorisnickoIme(String korisnickoIme);
	public Korisnik findByKorisnikId(Integer korisnikId);
	public List<Korisnik> findAll();
	public Integer deleteByKorisnickoIme(String korisnickoIme);

} 