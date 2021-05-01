package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.CongerRequest;
import dto.ProcessInstanceResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class CongerController {
	
	@Autowired
	CongerService congerService;

    @PostMapping("/deploy")
    public void deployWorkflow() {
    	congerService.deployProcessDefinition();
    }
    
    @PostMapping("/conger/demande")
    public ProcessInstanceResponse demandeConger(@RequestBody TDemande tDemande) {

        
    	//congerService.saveDemande(tDemande);
    	 return congerService.demandeConger(tDemande);
    }
    
}
