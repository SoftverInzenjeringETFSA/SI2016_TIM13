package instagramlike.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import instagramlike.models.Fotografija;
import instagramlike.services.FotografijaService;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin
@RequestMapping(path="/fotografija")
public class FotografijaController {

	@Autowired
    private FotografijaService fotografijaService;
	
	//autowired se bavi povezivanjem prema tipu tako da ce
	//povezati korisnik servis
    @Autowired
    public void setFotografijaService(FotografijaService FotografijaService) {
        this.fotografijaService = FotografijaService;
    }
	
	
    
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity update(@RequestBody Fotografija korisnik ) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(fotografijaService.updatePhoto(korisnik));
        }
        catch (ServiceException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                .body(e.getLocalizedMessage());
        }
    }

    @RequestMapping(path="/get/all", method = RequestMethod.GET)
    public List<Fotografija> findAll() {
    	List<Fotografija> k;
    	
    	k = (List<Fotografija>) fotografijaService.findAll();
    	
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
	public String addKorisnici(@ModelAttribute("imeForme") Fotografija k){
		
		if(k.getId() == 0) {
			fotografijaService.addPhoto(k);
		}
		else {
			fotografijaService.updatePhoto(k);
		}
		
		return "done";
	}
    
    @RequestMapping(path = "/delete", method = RequestMethod.DELETE)
    public String deleteKorisnici(@RequestParam(name = "user") Integer user) {
    	
    	fotografijaService.removeById(user);
        return "obavljeno";
    }
    
    
}