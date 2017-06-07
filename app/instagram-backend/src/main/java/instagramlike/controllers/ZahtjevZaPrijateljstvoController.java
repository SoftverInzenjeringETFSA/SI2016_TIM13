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
    public ResponseEntity<Serializable> update(@RequestBody ZahtjevZaPrijateljstvo l ) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(pS.updateRequest(l));
        }
        catch (ServiceException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                .body(e.getLocalizedMessage());
        }
    }

    @RequestMapping(path="/get/all", method = RequestMethod.GET)
    @ResponseBody
    public List<ZahtjevZaPrijateljstvo> findAll() {
    	List<ZahtjevZaPrijateljstvo> k;
    	
    	k = (List<ZahtjevZaPrijateljstvo>) pS.findAllRequests();
    	
    	return k;
    }
   
    @RequestMapping(path="/get/sender", method = RequestMethod.GET)
    @ResponseBody
    public List<ZahtjevZaPrijateljstvo> findRequestsByUserID(@RequestParam(name = "id", defaultValue = "1") int id) {
    	
        	return pS.findRequestsBySenderID(id);
    	
    }
    @RequestMapping(path="/get/receiver", method = RequestMethod.GET)
    @ResponseBody
    public List<ZahtjevZaPrijateljstvo> findRequestsByReceiverID(@RequestParam(name = "id", defaultValue = "1") int id) {
    	
        	return pS.findRequestsByReceiverID(id);
    	
    }
    @RequestMapping(path="/get", method = RequestMethod.GET)
    @ResponseBody
    public ZahtjevZaPrijateljstvo findRequestsByID(@RequestParam(name = "id", defaultValue = "1") int id) {
    	
        	return pS.findRequestsByID(id);
    	
    }
    @RequestMapping(path= "/add", method = RequestMethod.PUT)
	public String addRequest(@ModelAttribute("imeForme") ZahtjevZaPrijateljstvo k){
		
		
			pS.addRequest(k);
		
		return "done";
	}
    
    @RequestMapping(path = "/delete", method = RequestMethod.DELETE)
    public Integer deleteRequestById(@RequestParam(name = "user") Integer user) {
    	
    	return pS.deleteRequestById(user);
    }
    @RequestMapping(path = "/delete/sender", method = RequestMethod.DELETE)
    public Integer deleteRequestBySenderID(@RequestParam(name = "user") Integer user) {
    	
    	return pS.deleteRequestBySenderID(user);
    }
    @RequestMapping(path = "/delete/receiver", method = RequestMethod.DELETE)
    public Integer deleteRequestByReceiverID(@RequestParam(name = "user") Integer user) {
    	
    	return pS.deleteRequestByReceiverID(user);
    }
}