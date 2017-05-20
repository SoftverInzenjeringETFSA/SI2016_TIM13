package models;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="korisnik")
public class Korisnik implements Serializable {
	private static final long serialVersionUID = 1L;
	  
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idKorisnik; 
    
    private String korisnickoIme;
    private String email;
    private String kratakOpis;
    private String korisnickaSifraHash;
   
    public Korisnik() {
    	
    }
    
    public Integer getIdKorisnik() {
		return this.idKorisnik;
	}
	public void setIdKorisnik(Integer id) {
		this.idKorisnik = id;
	}
	public String getKorisnickaSifraHash() {
		return korisnickaSifraHash;
	}
	public void setKorisnickaSifraHash(String password) {
		this.korisnickaSifraHash = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getKorisnickoIme() {
		return this.korisnickoIme;
	}
	public void setKorisnickoIme(String ki) {
		this.korisnickoIme = ki;
	}
	public String getKratakOpis() {
		return kratakOpis;
	}

	public void setKratakOpis(String kratakOpis) {
		this.kratakOpis = kratakOpis;
	}

	
	@Override
    public String toString() {
        return String.format("Korisnik[id=%d, password='%s', email='%s']", idKorisnik, korisnickaSifraHash, email);
    }
}