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

import instagramlike.models.Panel;
import instagramlike.services.PanelService;

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
@RequestMapping(path="/panel")
public class PanelController {

	@Autowired
    private PanelService pS;
	
	//autowired se bavi povezivanjem prema tipu tako da ce
	//povezati korisnik servis
    @Autowired
    public void setFotografijaService(PanelService ls) {
        this.pS = ls;
    }
	
	
    
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity update(@RequestBody Panel l ) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(pS.updatePanel(l));
        }
        catch (ServiceException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                .body(e.getLocalizedMessage());
        }
    }

    @RequestMapping(path="/get/all", method = RequestMethod.GET)
    public List<Panel> findAll() {
    	List<Panel> k;
    	
    	k = (List<Panel>) pS.findAllPanels();
    	
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
	public String addLocation(@ModelAttribute("imeForme") Panel k){
		
		if(k.getId() == 0) {
			pS.addPanel(k);
		}
		else {
			pS.updatePanel( k);
		}
		
		return "done";
	}
    
    @RequestMapping(path = "/delete", method = RequestMethod.DELETE)
    public String deletePanelById(@RequestParam(name = "id") Integer id) {
    	
    	pS.deletePanelById(id);
        return "obavljeno";
    }
    @RequestMapping(path = "/delete/userid", method = RequestMethod.DELETE)
    public String deletePanelsByUserID(@RequestParam(name = "user") Integer user) {
    	
    	pS.deletePanelsByUserID(user);
        return "obavljeno";
    }
    
}