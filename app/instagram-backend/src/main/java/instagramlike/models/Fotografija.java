package instagramlike.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mysql.jdbc.Blob;

@Entity
@Table(name="fotografije")
public class Fotografija {
		
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="fotografija_id")
	private Integer id;
	
	@Column(name="korisnik_id")
	private Integer korisnikID;
	
	@Column(name="lokacija_id")
	private Integer lokacijaID;
	
	@Column(name="broj_svidjanja")
	private Integer brojSvidjanja;
	
	@Column(name="fotografija")
	private Blob fotografija;
	
	//Constructors
	public Fotografija() {}
	
	public Fotografija(Integer id, Integer korisnikID, Integer lokacijaID, Integer brojSvidjanja) {
		this.id = id;
		this.korisnikID = korisnikID;
		this.lokacijaID = lokacijaID;
		this.brojSvidjanja = brojSvidjanja;
	}
	
	public Fotografija(Integer korisnikID, Integer lokacijaID, Integer brojSvidjanja, Blob fotografija) {
		//this.id = id; //automatski se generise u bazi
		this.korisnikID = korisnikID;
		this.lokacijaID = lokacijaID;
		this.brojSvidjanja = brojSvidjanja;
		this.fotografija = fotografija;
	}
	
	//Getters
	public Integer getId() {
		return this.id;
	}
	
	public Integer getKorisnikID() {
		return this.korisnikID;
	}
	
	public Integer getLokacijaID() {
		return this.lokacijaID;
	}
	
	public Integer getBrojSvidjanja() {
		return this.brojSvidjanja;
	}
	
	public Blob getFotogradija() {
		return this.fotografija;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setKorisnikID(Integer id) {
		this.korisnikID = id;
	}
	
	public void setLokacijaID(Integer id) {
		this.lokacijaID = id;
	}
	
	public void setBrojSvidjanja(Integer brojSvidjanja) {
		this.brojSvidjanja = brojSvidjanja;
	}
	
	public void setFotografija(Blob fotografija) {
		this.fotografija = fotografija;
	}

	//Metodhs
	@Override
	public String toString() {
		return String.format("{ \"id\": %d, \"korisnik_id\": %d, \"lokacija_id\": %d, \"broj_svidjanja\": %d }",
							this.id, this.korisnikID, this.lokacijaID, this.brojSvidjanja);
	}
	
}
