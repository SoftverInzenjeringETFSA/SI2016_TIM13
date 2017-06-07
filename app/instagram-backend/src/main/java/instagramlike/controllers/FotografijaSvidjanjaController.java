package instagramlike.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import instagramlike.models.FotografijaSvidjanja;
import instagramlike.services.FotografijaSvidjanjaService;

@RestController
@CrossOrigin
@RequestMapping(path="/fotografijaSvidjanja")
public class FotografijaSvidjanjaController {

	@Autowired
    private FotografijaSvidjanjaService fotografijaService;
	
	//autowired se bavi povezivanjem prema tipu tako da ce
	//povezati korisnik servis
    @Autowired
    public void setFotografijaService(FotografijaSvidjanjaService FotografijaService) {
        this.fotografijaService = FotografijaService;
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
	public String addSvidjanja(@ModelAttribute("imeForme") FotografijaSvidjanja k){
		
		
			fotografijaService.addFotografijaSvidjanja(k);
		
		return "done";
	}
    
    @RequestMapping(path = "/delete", method = RequestMethod.DELETE)
    public Integer deleteById(@RequestParam(name = "user") Integer user) {
    	
    	return fotografijaService.deleteById(user);
    }
    @RequestMapping(path = "/delete/fotoid", method = RequestMethod.DELETE)
    public Integer deleteByFotoId(@RequestParam(name = "user") Integer user) {
    	
    	return fotografijaService.deleteByKorisnikID(user);
    }
    @RequestMapping(path = "/delete/korisnikid", method = RequestMethod.DELETE)
    public Integer deleteByKorisnikId(@RequestParam(name = "user") Integer user) {
    	
    	return fotografijaService.deleteByKorisnikID(user);
    }
    
    
}