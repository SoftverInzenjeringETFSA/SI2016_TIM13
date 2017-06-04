package instagramlike.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import instagramlike.models.Komentar;
import instagramlike.repositories.KomentarRepository;

@Service
public class KomentarService {

	@Autowired
	KomentarRepository repo;
	
	public void addComment(Komentar comment) {
		repo.save(comment);
	}
	
	public void updateComment(Komentar comment) {
		repo.save(comment);
	}
	
	public Boolean deleteCommentById(Integer ID) {
		return repo.deleteByid(ID);
	}
	
	public Boolean deleteCommentByUserID(Integer ID) {
		return repo.deleteByKorisnikID(ID);
	}
	
	public Boolean deleteCommentByPhotoID(Integer ID) {
		return repo.deleteByfotoID(ID);
	}
	
	public List<Komentar> findAllComments() {
		return repo.findAll();
	}
	
	public List<Komentar> findCommentsByUserID(Integer ID) {
		return repo.findAllByKorisnikID(ID);
	}
	
	public List<Komentar> findCommentsByPhotoID(Integer ID) {
		return repo.findAllByfotoID(ID);
	}
	
	public Komentar findCommentByID(Integer ID) {
		return repo.findByid(ID);
	}
	
}
