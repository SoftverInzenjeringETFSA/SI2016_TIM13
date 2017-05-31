package instagramlike.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fotografije_svidjanja")
public class FotografijaSvidjanja {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="svidjanje_id")
	private Integer id;
	

	@Column(name="fotografija_id")
	private Integer fotoID;
	
	@Column(name="korisnik_id")
	private Integer korisnikID;
	
	//Contructors
	public FotografijaSvidjanja() {}
	
	public FotografijaSvidjanja(Integer foto, Integer korisnik) {
		//this.id = id;
		this.fotoID = foto;
		this.korisnikID = korisnik;
	}
	
	//Getters
	public Integer getFotoID() {
		return this.fotoID;
	}
	
	public Integer getKorisnikID() {
		return this.korisnikID;
	}
	
	//Setters
	public void setFotoID(Integer id) {
		this.fotoID = id;
	}
	
	public void setKorisnikID(Integer id) {
		this.korisnikID = id;
	}

}
