package instagramlike.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/*
@Entity
@Table(name="zahtjevi_za_prijateljstv")
public class ZahtjevZaPrijateljstvo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="zahtjev_id")
	private Integer id;
	
	@Column(name="korisnik_poslao_id")
	private Integer posiljaocID;
	
	@Column(name="korisnik_prima_id")
	private Integer primaocID;
	
	@Column(name="status")
	private Boolean status;
	
	@Column(name="opis")
	private String opis;
	
	//Constructors
	public ZahtjevZaPrijateljstvo() {}
	
	public ZahtjevZaPrijateljstvo(Integer posiljaocID, Integer primaocID, Boolean status, String opis) {
		//this.id = id Automatski se postavlja u bazi
		this.posiljaocID = posiljaocID;
		this.primaocID = primaocID;
		this.status = status;
		this.opis = opis;
	}
	
	//Getters
	public Integer getId() {
		return this.id;
	}
	
	public Integer getPosiljaocID() {
		return this.posiljaocID;
	}
	
	public Integer getPrimaocID() {
		return this.primaocID;
	}
	
	public Boolean getStatus() {
		return this.status;
	}
	
	public String getOpis() {
		return this.opis;
	}
	
	//Setters
	/*
	public void setId(Integer id) {
		this.id = id;
	}
	*//*
	public void setPosiljaocID(Integer id) {
		this.posiljaocID = id;
	}
	
	public void setPrimaocID(Integer id) {
		this.primaocID = id;
	}
	
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	//Methods
	@Override
	public String toString() {
		return String.format("{ \"id\": %d, \"korisnik_posalo_id\": %d, \"korisnik_prima_id\": %d, \"status\": %b, "
				+ "\"opis\": %s }", this.id, this.posiljaocID, this.primaocID, this.status, this.opis);
	}
	
}
*/