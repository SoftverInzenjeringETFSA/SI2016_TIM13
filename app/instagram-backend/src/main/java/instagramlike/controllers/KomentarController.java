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

import instagramlike.models.Komentar;
import instagramlike.services.KomentarService;

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
@RequestMapping(path="/komentar")
public class KomentarController {

	@Autowired
    private KomentarService kS;
	
	//autowired se bavi povezivanjem prema tipu tako da ce
	//povezati korisnik servis
    @Autowired
    public void setFotografijaService(KomentarService ls) {
        this.kS = ls;
    }
	
	
    
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<Serializable> update(@RequestBody Komentar l ) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(kS.updateComment(l));
        }
        catch (ServiceException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                .body(e.getLocalizedMessage());
        }
    }

    @RequestMapping(path="/get/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Komentar> findAll() {
    	List<Komentar> k;
    	
    	k = (List<Komentar>) kS.findAllComments();
    	
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
	public String addKomentar(@ModelAttribute("imeForme") Komentar k){
		
		if(k.getId() == 0) {
			kS.addComment(k);
		}
		else {
			kS.updateComment( k);
		}
		
		return "done";
	}
    
    @RequestMapping(path = "/delete", method = RequestMethod.DELETE)
    public Integer deleteComment(@RequestParam(name = "id") Integer id) {
    	
    	return kS.deleteCommentById(id);
    }
    @RequestMapping(path = "/delete/userid", method = RequestMethod.DELETE)
    public Integer deleteCommentByUserID(@RequestParam(name = "user") Integer user) {
    	
    	return kS.deleteCommentByUserID(user);
    }
    @RequestMapping(path = "/delete/photoid", method = RequestMethod.DELETE)
    public Integer deleteCommentByPhotoId(@RequestParam(name = "photoid") Integer photoid) {
    	
    	return kS.deleteCommentByPhotoID(photoid);
    }
    
}