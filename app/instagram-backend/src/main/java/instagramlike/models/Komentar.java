package instagramlike.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="komentari")
public class Komentar {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="komentar_id")
	private Integer id;
	
	@Column(name="fotografija_id")
	private Integer fotoID;
	
	@Column(name="korisnik_id")
	private Integer korisnikID;
	
	@Column(name="sadrzaj")
	private String sadrzaj;
	
	//Constructors
	public Komentar() {}
	
	public Komentar(Integer fotoID, Integer korisnikID, String sadrzaj) {
		//this.id = id; //automatski se generise u bazi
		this.fotoID = fotoID;
		this.korisnikID = korisnikID;
		this.sadrzaj = sadrzaj;
	}
	
	//Getters
	public Integer getId() {
		return this.id;
	}
	
	public Integer getFotoID() {
		return this.fotoID;
	}
	
	public Integer getKorisnikID() {
		return this.korisnikID;
	}
	
	public String getSadrzaj() {
		return this.sadrzaj;
	}
	
	//Setters
	public void setId(int id) {
		this.id = id;
	}
	
	public void setFotoID(int id) {
		this.fotoID = id;
	}
	
	public void setKorisnikID(int id) {
		this.korisnikID = id;
	}
	
	//Methods
	@Override
	public String toString() {
		return String.format("{ \"id\": %d, \"fotografija_id\": %d, \"korisnik_id\": %d, \"sadrzaj\": %s }",
							this.id, this.fotoID, this.korisnikID, this.sadrzaj);
	}
	
}
