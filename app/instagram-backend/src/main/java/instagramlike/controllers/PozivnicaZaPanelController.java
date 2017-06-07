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

import instagramlike.models.PozivnicaZaPanel;
import instagramlike.services.PozivnicaZaPanelService;

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
@RequestMapping(path="/pozivnicazapanel")
public class PozivnicaZaPanelController {

	@Autowired
    private PozivnicaZaPanelService pS;
	
	//autowired se bavi povezivanjem prema tipu tako da ce
	//povezati korisnik servis
    @Autowired
    public void setPozivnicaZaPanelService(PozivnicaZaPanelService ls) {
        this.pS = ls;
    }
	
	
    
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<Serializable> update(@RequestBody PozivnicaZaPanel l ) {
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
    public List<PozivnicaZaPanel> findAll() {
    	List<PozivnicaZaPanel> k;
    	
    	k = (List<PozivnicaZaPanel>) pS.findAllPozivnicaZaPanels();
    	
    	return k;
    }

    @RequestMapping(path= "/add", method = RequestMethod.PUT)
	public String addLocation(@ModelAttribute("imeForme") PozivnicaZaPanel k){
		
		
			pS.addPozivnicaZaPanel(k);
		
		return "done";
	}
    
    @RequestMapping(path = "/delete", method = RequestMethod.DELETE)
    public Integer deletePozivnicaZaPanelById(@RequestParam(name = "user") Integer user) {
    	
    	return pS.deletePozivnicaZaPanelById(user);
    }
    @RequestMapping(path = "/delete/receiverid", method = RequestMethod.DELETE)
    public Integer deletePozivnicaZaPanelByID(@RequestParam(name = "receiver") Integer receiver) {
    	
    	return pS.deletePozivnicaZaPanelByPrimaocID(receiver);
    }
    @RequestMapping(path = "/delete/senderid", method = RequestMethod.DELETE)
    public Integer deletePozivnicaZaPanelByPosiljaocId(@RequestParam(name = "sender") Integer sender) {
    	
    	return pS.deletePozivnicaZaPanelByPosiljaocID(sender);
    }
}