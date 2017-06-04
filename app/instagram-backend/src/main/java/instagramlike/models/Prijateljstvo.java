package instagramlike.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="prijateljstva")
public class Prijateljstvo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="prijateljstvo_id")
	private Integer id;

	@Column(name="korisnik1_id")
	private Integer korisnik1ID;
	
	@Column(name="korisnik2_id")
	private Integer korisnik2ID;
	
	//Constructors
	public  Prijateljstvo() {}
	
	public Prijateljstvo(Integer korisnik1, Integer korisnik2) {
		//this.id = id;
		this.korisnik1ID = korisnik1;
		this.korisnik2ID = korisnik2;
	}
	
	//Getters
	public Integer getKorisnik1ID() {
		return this.korisnik1ID;
	}
	
	public Integer getKorisnik2ID() {
		return this.korisnik2ID;
	}
	
	//Setters
	public void setKorisnik1ID(Integer korisnik1) {
		this.korisnik1ID = korisnik1;
	}
	
	public void setKorisnik2ID(Integer korisnik2) {
		this.korisnik2ID = korisnik2;
	}
	
}