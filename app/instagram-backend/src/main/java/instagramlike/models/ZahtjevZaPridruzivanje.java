package instagramlike.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/*
@Entity
@Table(name="zahtjevi_za_pridruzivanje")
public class ZahtjevZaPridruzivanje {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="zahtjev_id")
	private Integer id;
	
	@Column(name="korisnik_id")
	private Integer korisnikID;
	
	@Column(name="panel_id")
	private Integer panelID;
	
	//Constructors
	public ZahtjevZaPridruzivanje() {}
	
	public ZahtjevZaPridruzivanje(Integer korisnikID, Integer panelID) {
		//this.id = id; AUTO
		this.korisnikID = korisnikID;
		this.panelID = panelID;
	}
	
	//Getters
	public Integer getId() {
		return this.id;
	}
	
	public Integer getKorisnikID() {
		return this.korisnikID;
	}
	
	public Integer getPanelID() {
		return this.panelID;
	}
	
	//Setters
	/*
	 public void setId(Integer id) {
	 	this.id = id;
	 }
	 *//*
	public void setKorisnikID(Integer id) {
		this.korisnikID = id;
	}
	
	public void setPanelID(Integer id) {
		this.panelID = id;
	}
	
}
*/