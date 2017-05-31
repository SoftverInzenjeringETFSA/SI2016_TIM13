package instagramlike.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="notifikacije")
public class Notifikacija {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="notifikacija_id")
	private Integer id;
	
	@Column(name="korisnik_id")
	private Integer korisnikID;
	
	@Column(name="tip_notifikacije")
	private String tipNotifikacije;
	
	//Constructors
	public Notifikacija() {}
	
	public Notifikacija(Integer korisnikID, String tipNotifikacije) {
		//this.id = id; //Auto
		this.korisnikID = korisnikID;
		this.tipNotifikacije = tipNotifikacije;
	}
	
	//Getters
	public Integer getId() {
		return this.id;
	}
	
	public Integer getKorisnikID() {
		return this.korisnikID;
	}
	
	public String getTipNotifikacije() {
		return this.tipNotifikacije;
	}
	
	//Setters
	/*
	public void setId(Integer id) {
		this.id = id;
	}
	*/
	public void setKorisnikID(Integer id) {
		this.korisnikID = id;
	}
	
	public void setTipNotifikacije(String tipNotifikacije) {
		this.tipNotifikacije = tipNotifikacije;
	}
	
	//Methods
	@Override
	public String toString() {
		return String.format("{ \"id\": %d, \"korisnik_id\": %d, \"tip_notifikacije\": %s }",
							this.id, this.korisnikID, this.tipNotifikacije);
	}
}