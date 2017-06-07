package instagramlike.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import instagramlike.models.Prijateljstvo;
import instagramlike.services.PrijeteljstvoService;

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
@RequestMapping(path="/prijateljstvo")
public class PrijateljstvoController {

	@Autowired
    private PrijeteljstvoService pS;
	
	//autowired se bavi povezivanjem prema tipu tako da ce
	//povezati korisnik servis
    @Autowired
    public void setFotografijaService(PrijeteljstvoService ls) {
        this.pS = ls;
    }
	
	
    
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<Serializable> update(@RequestBody Prijateljstvo l ) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(pS.updatePozivnicaZaPanel(l));
        }
        catch (ServiceException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                .body(e.getLocalizedMessage());
        }
    }

    @RequestMapping(path="/get/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Prijateljstvo> findAll() {
    	List<Prijateljstvo> k;
    	
    	k = (List<Prijateljstvo>) pS.findAllPrijateljstva();
    	
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
	public String addLocation(@ModelAttribute("imeForme") Prijateljstvo k){
		
		
			pS.addPozivnicaZaPanel(k);
		
		return "done";
	}
    
    @RequestMapping(path = "/delete", method = RequestMethod.DELETE)
    public Integer deletePozivnicaZaPanelById(@RequestParam(name = "id") Integer id) {
    	
    	return pS.deletePozivnicaZaPanelById(id);
    }
    @RequestMapping(path = "/delete/user1", method = RequestMethod.DELETE)
    public Integer deletePozivnicaZaPanelByID(@RequestParam(name = "user1") Integer userOneId) {
    	
    	return pS.deleteByKorisnik1ID(userOneId);
    }
    @RequestMapping(path = "/delete/user2", method = RequestMethod.DELETE)
    public Integer deleteByKorisnik1ID(@RequestParam(name = "user2") Integer userTwoId) {
    	
    	return pS.deleteByKorisnik2ID(userTwoId);
    }
}