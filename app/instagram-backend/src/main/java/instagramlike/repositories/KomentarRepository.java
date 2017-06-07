package instagramlike.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import instagramlike.models.Komentar;

@Repository
public interface KomentarRepository extends CrudRepository<Komentar, Integer> {
	
	public List<Komentar> findAll();
	public List<Komentar> findAllByKorisnikID(Integer ID);
	public List<Komentar> findAllByfotoID(Integer ID);
	public Komentar findByid(Integer ID);
	public Integer deleteByid(Integer ID);
	public Integer deleteByKorisnikID(Integer ID);
	public Integer deleteByfotoID(Integer ID);
	
}
