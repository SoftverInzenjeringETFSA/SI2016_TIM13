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

import instagramlike.models.ZahtjevZaPridruzivanje;
import instagramlike.services.ZahtjevZaPridruzivanjeService;

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
@RequestMapping(path="/ZahtjevZaPridruzivanje")
public class ZahtjevZaPridruzivanjeController {

	@Autowired
    private ZahtjevZaPridruzivanjeService pS;
	
	//autowired se bavi povezivanjem prema tipu tako da ce
	//povezati korisnik servis
    @Autowired
    public void setZahtjevZaPridruzivanjeService(ZahtjevZaPridruzivanjeService ls) {
        this.pS = ls;
    }
	
	
    
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<Serializable> update(@RequestBody ZahtjevZaPridruzivanje l ) {
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
    public List<ZahtjevZaPridruzivanje> findAll() {
    	List<ZahtjevZaPridruzivanje> k;
    	
    	k = (List<ZahtjevZaPridruzivanje>) pS.findAllRequests();
    	
    	return k;
    }
   
    @RequestMapping(path="/get", method = RequestMethod.GET)
    @ResponseBody
    public List<ZahtjevZaPridruzivanje> findRequestsByUserID(@RequestParam(name = "id", defaultValue = "1") int id) {
    	
        	return pS.findRequestsByUserID(id);
    	
    }
   
    @RequestMapping(path= "/add", method = RequestMethod.PUT)
	public String addRequest(@ModelAttribute("imeForme") ZahtjevZaPridruzivanje k){
		
		
			pS.addRequest(k);
		
		return "done";
	}
    
    @RequestMapping(path = "/delete", method = RequestMethod.DELETE)
    public Integer deleteRequestById(@RequestParam(name = "id") Integer id) {
    	
    	return pS.deleteRequestById(id);
    }
    @RequestMapping(path = "/delete/userid", method = RequestMethod.DELETE)
    public Integer deleteRequestByUserID(@RequestParam(name = "user") Integer user) {
    	
    	return pS.deleteRequestByUserID(user);
    }
   
}