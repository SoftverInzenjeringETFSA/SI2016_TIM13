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

import instagramlike.models.Notifikacija;
import instagramlike.services.NotifikacijaService;

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
@RequestMapping(path="/notifikacija")
public class NotifikacijaController {

	@Autowired
    private NotifikacijaService kS;
	
	//autowired se bavi povezivanjem prema tipu tako da ce
	//povezati korisnik servis
    @Autowired
    public void setFotografijaService(NotifikacijaService ls) {
        this.kS = ls;
    }
	
	
    
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity update(@RequestBody Notifikacija l ) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(kS.updateNotification(l));
        }
        catch (ServiceException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                .body(e.getLocalizedMessage());
        }
    }

    @RequestMapping(path="/get/all", method = RequestMethod.GET)
    public List<Notifikacija> findAll() {
    	List<Notifikacija> k;
    	
    	k = (List<Notifikacija>) kS.findAllNotifications();
    	
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
	public String addNotification(@ModelAttribute("imeForme") Notifikacija k){
		
		if(k.getId() == 0) {
			kS.addNotification(k);
		}
		else {
			kS.updateNotification( k);
		}
		
		return "done";
	}
    
    @RequestMapping(path = "/delete", method = RequestMethod.DELETE)
    public String deleteNotificationById(@RequestParam(name = "id") Integer id) {
    	
    	kS.deleteNotificationById(id);
        return "obavljeno";
    }
    @RequestMapping(path = "/delete/userid", method = RequestMethod.DELETE)
    public String deleteNotificationsByUserID(@RequestParam(name = "user") Integer user) {
    	
    	kS.deleteNotificationsByUserID(user);
        return "obavljeno";
    }
}