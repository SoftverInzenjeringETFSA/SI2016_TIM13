package instagramlike.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import instagramlike.models.Korisnik;
import instagramlike.services.KorisnikService;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(path="/korisnik")
public class KorisnikController {

	@Autowired
    private KorisnikService korisnikService;
	
	//autowired se bavi povezivanjem prema tipu tako da ce
	//povezati korisnik servis
    @Autowired
    public void setKorisnikService(KorisnikService korisnikServis) {
        this.korisnikService = korisnikServis;
    }
	
	
    @RequestMapping(value = "/register", method = RequestMethod.PUT)
    public String register(@RequestBody Korisnik korisnik)
    {   
    	//provjeriti sta koja fja vraca i uraditi
    		korisnikService.registerKorisnik(korisnik);
            return korisnik.toString(); 
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity update(@RequestBody Korisnik korisnik ) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                                .body(korisnikService.updateKorisnik(korisnik));
        }
        catch (ServiceException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                .body(e.getLocalizedMessage());
        }
    }

    @RequestMapping(path="/get/all", method = RequestMethod.GET)
    public List<Korisnik> findAll() {
    	List<Korisnik> k;
    	
    	k = (List<Korisnik>) korisnikService.findAllKorisnici();
    	
    	return k;
    }
    /* za šta služi skontati pa otkomentarisati ako treba 
    @RequestMapping(path="/get", method = RequestMethod.GET)
    public List<Korisnik> viewKorisnici(@RequestParam(name = "id", defaultValue = "1") int id) {
    	List<Korisnik> k = new ArrayList<Korisnik>();
    	
        	k.add(korisnikService.findOne(id));
    	
    	return k;
    }
    */
    @RequestMapping(path= "/add", method = RequestMethod.PUT)
	public String addKorisnici(@ModelAttribute("imeForme") Korisnik k){
		
		if(k.getkorisnik_id() == 0) {
			korisnikService.registerKorisnik(k);
		}
		else {
			korisnikService.updateKorisnik(k);
		}
		
		return "done";
	}
    
    @RequestMapping(path = "/delete", method = RequestMethod.DELETE)
    public String deleteKorisnici(@RequestParam(name = "user") String user) {
    	
    	korisnikService.removeKorisnik(user);
        return "obavljeno";
    }
    
    @RequestMapping(path = "/getid", method = RequestMethod.GET) 
    public Integer getKorisnikID(@RequestParam(name = "user") String user) {
    	Korisnik korisnik = this.korisnikService.findByUsername(user);
    	
    	if (korisnik == null)
    		return 0; //vrati nulu ako korisnik ne postoji
    	
    	return korisnik.getkorisnik_id();
    }
    
}