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

import instagramlike.models.ZahtjevZaPrijateljstvo;
import instagramlike.services.ZahtjevZaPrijateljstvoService;

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
@RequestMapping(path="/ZahtjevZaPrijateljstvo")
public class ZahtjevZaPrijateljstvoController {

	@Autowired
    private ZahtjevZaPrijateljstvoService pS;
	
	//autowired se bavi povezivanjem prema tipu tako da ce
	//povezati korisnik servis
    @Autowired
    public void setZahtjevZaPrijateljstvoService(ZahtjevZaPrijateljstvoService ls) {
        this.pS = ls;
    }
	
	
    
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity update(@RequestBody ZahtjevZaPrijateljstvo l ) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(pS.updateRequest(l));
        }
        catch (ServiceException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                .body(e.getLocalizedMessage());
        }
    }

    @RequestMapping(path="/get/all", method = RequestMethod.GET)
    public List<ZahtjevZaPrijateljstvo> findAll() {
    	List<ZahtjevZaPrijateljstvo> k;
    	
    	k = (List<ZahtjevZaPrijateljstvo>) pS.findAllRequests();
    	
    	return k;
    }
   
    @RequestMapping(path="/get/sender", method = RequestMethod.GET)
    public List<ZahtjevZaPrijateljstvo> findRequestsByUserID(@RequestParam(name = "id", defaultValue = "1") int id) {
    	
        	return pS.findRequestsBySenderID(id);
    	
    }
    @RequestMapping(path="/get/receiver", method = RequestMethod.GET)
    public List<ZahtjevZaPrijateljstvo> findRequestsByReceiverID(@RequestParam(name = "id", defaultValue = "1") int id) {
    	
        	return pS.findRequestsByReceiverID(id);
    	
    }
    @RequestMapping(path="/get", method = RequestMethod.GET)
    public ZahtjevZaPrijateljstvo findRequestsByID(@RequestParam(name = "id", defaultValue = "1") int id) {
    	
        	return pS.findRequestsByID(id);
    	
    }
    @RequestMapping(path= "/add", method = RequestMethod.PUT)
	public String addRequest(@ModelAttribute("imeForme") ZahtjevZaPrijateljstvo k){
		
		
			pS.addRequest(k);
		
		return "done";
	}
    
    @RequestMapping(path = "/delete", method = RequestMethod.DELETE)
    public String deleteRequestById(@RequestParam(name = "user") Integer user) {
    	
    	pS.deleteRequestById(user);
        return "obavljeno";
    }
    @RequestMapping(path = "/delete/sender", method = RequestMethod.DELETE)
    public String deleteRequestBySenderID(@RequestParam(name = "user") Integer user) {
    	
    	pS.deleteRequestBySenderID(user);
        return "obavljeno";
    }
    @RequestMapping(path = "/delete/receiver", method = RequestMethod.DELETE)
    public String deleteRequestByReceiverID(@RequestParam(name = "user") Integer user) {
    	
    	pS.deleteRequestByReceiverID(user);
        return "obavljeno";
    }
}