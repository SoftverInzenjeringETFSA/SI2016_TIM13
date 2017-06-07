package instagramlike.models;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
   
    public Korisnik() {}
    
    public Korisnik(String korisnickoIme, String email, String kratakOpis, String korisnickaSifra) {
    	this.korisnickoIme = korisnickoIme;
    	this.email = email;
    	this.kratakOpis = kratakOpis;
    	this.korisnickaSifra = korisnickaSifra;
    }
    
    
    public Integer getKorisnikId() {
		return this.korisnikId;
	}
    
	public void setKorisnikId(Integer id) {
		this.korisnikId = id;
	}
	
	public String getKorisnickaSifra() {
		return korisnickaSifra;
	}
	
	public void setKorisnickaSifra(String password) {
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
        return String.format("{ \"korisnik_id\": %d, \"korisnicko_ime\": \"%s\", \"email\": \"%s\","
        					+ " \"korisnicka_sifra_hash\": \"%s\", \"kratak_opis\": \"%s\" }", 
        					this.korisnikId, this.korisnickoIme, this.email, this.korisnickaSifra, this.kratakOpis);
    }
}