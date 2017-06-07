package instagramlike.controllers;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import instagramlike.models.Lokacija;
import instagramlike.services.LokacijaService;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin
@RequestMapping(path="/lokacija")
public class LokacijaController {

	@Autowired
    private LokacijaService lokacijaService;
	
	//autowired se bavi povezivanjem prema tipu tako da ce
	//povezati korisnik servis
    @Autowired
    public void setFotografijaService(LokacijaService ls) {
        this.lokacijaService = ls;
    }
	
	
    
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<Serializable> update(@RequestBody Lokacija l ) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(lokacijaService.updateLocation(l,l));
        }
        catch (ServiceException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                .body(e.getLocalizedMessage());
        }
    }

    @RequestMapping(path="/get/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Lokacija> findAll() {
    	List<Lokacija> k;
    	
    	k = (List<Lokacija>) lokacijaService.getAllLocations();
    	
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
	public String addLocation(@ModelAttribute("imeForme") Lokacija k){
		
		if(k.getId() == 0) {
			lokacijaService.addLocation(k);
		}
		else {
			lokacijaService.updateLocation(k, k);
		}
		
		return "done";
	}
    
    @RequestMapping(path = "/delete", method = RequestMethod.DELETE)
    public Integer deleteLocation(@RequestParam(name = "user") Integer id) {
    	
    	return lokacijaService.deleteLocationById(id);
    }
    @RequestMapping(path = "/delete/name", method = RequestMethod.DELETE)
    public Integer deleteLocationByName(@RequestParam(name = "name") String name) {
    	
    	return lokacijaService.deleteLocationByName(name);
    }
    
}