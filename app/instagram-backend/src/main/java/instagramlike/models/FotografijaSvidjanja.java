package instagramlike.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="fotografije_svidjanja")
public class FotografijaSvidjanja {

	@Column(name="fotografija_id")
	private Integer fotoID;
	
	@Column(name="korisnik_id")
	private Integer korisnikID;
	
	//Contructors
	public FotografijaSvidjanja() {}
	
	public FotografijaSvidjanja(Integer foto, Integer korisnik) {
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
