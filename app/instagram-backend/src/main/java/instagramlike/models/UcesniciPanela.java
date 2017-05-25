package instagramlike.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ucesnici_panela")
public class UcesniciPanela {
	
	@Column(name="korisnik_id")
	private Integer korisnikID;
	
	@Column(name="panel_id")
	private Integer panelID;
	
	//Constructors
	public UcesniciPanela() {}
	
	public UcesniciPanela(Integer korisnikID, Integer panelID) {
		this.korisnikID = korisnikID;
		this.panelID = panelID;
	}
	
	//Getters
	public Integer getKorisnikID() {
		return this.korisnikID;
	}
	
	public Integer getPanelID() {
		return this.panelID;
	}
	
	//Setters
	public void setKorisnikID(Integer id) {
		this.korisnikID = id;
	}
	
	public void setPanelID(Integer id) {
		this.panelID = id;
	}
	
}
