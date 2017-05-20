package repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import models.Korisnik;

@Repository
public interface KorisnikRepository extends CrudRepository<Korisnik, Integer> {
	
	public Korisnik findByEmail(String email);
	public Korisnik findByKorisnickoIme(String korisnickoIme);
	public Korisnik findByIdKorisnik(Integer idKorisnik);
	public List<Korisnik> findAll();
}