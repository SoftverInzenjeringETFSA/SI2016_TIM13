package instagramlike.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/*
@Entity
@Table(name="lokacije")
public class Lokacija {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="lokacija_id")
	private Integer id;
	
	@Column(name="naziv")
	private String naziv;
	
	//Constructors
	public Lokacija() {}
	
	public Lokacija(String lokacija) {
		//this.id = id; Automatski postavljen u bazi
		this.naziv = lokacija;
	}
	
	//Getters
	public Integer getId() {
		return this.id;
	}
	
	public String getLokacija() {
		return this.naziv;
	}
	
	//Setters
	/*
	public void setId(Integer id) {
		this.id = id;
	}
	*//*
	public void setLokacija(String lokacija) {
		this.naziv = lokacija;
	}
	
}
*/