package instagramlike.models;


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
@Table(name="korisnici")
public class Korisnik implements Serializable {
	private static final long serialVersionUID = 1L;
	  
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="korisnik_id")
    private Integer korisnikId; 
    @Column(name="korisnicko_ime")
    private String korisnickoIme;
    private String email;
    @Column(name="kratak_opis")
    private String kratakOpis;
    @Column(name="korisnicka_sifra_hash")
    private String korisnickaSifra;
   
    public Korisnik() {
    	
    }
    public Korisnik(String ime, String email, String opis, String sifra) {
    	
    	this.korisnickoIme = ime;
    	this.email = email;
    	this.kratakOpis = opis;
    	this.korisnickaSifra = sifra;
    }
    
    
    public Integer getkorisnik_id() {
		return this.korisnikId;
	}
	public void setkorisnik_id(Integer id) {
		this.korisnikId = id;
	}
	public String getKorisnickaSifraHash() {
		return korisnickaSifra;
	}
	public void setKorisnickaSifraHash(String password) {
		this.korisnickaSifra = password;
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
        return String.format("Korisnik[id=%d, password='%s', email='%s']", korisnikId, korisnickaSifra, email);
    }
}