package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dto.CongerRequest;
import dto.ProcessInstanceResponse;



@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CongerService {
	
	@Autowired  
	CongeRepository congeRepository ; 
	
    public static final String PROCESS_DEFINITION_KEY = "Processflowconge";

	
	RepositoryService repositoryService;
	RuntimeService runtimeService;
	
    public void deployProcessDefinition() {

        Deployment deployment =
                repositoryService
                        .createDeployment()
                        .addClasspathResource("Processflowconge.bpmn20.xml")
                        .deploy();


    }
    
    public ProcessInstanceResponse demandeConger(TDemande tDemande) {

        Map<String, Object> variables = new HashMap<String, Object>();
		   variables.put("DateDebut",tDemande.getDateDebut());
		   variables.put("DateFin",tDemande.getDateFin());
		   variables.put("Commentaire", tDemande.getCommentaire());

        ProcessInstance processInstance =
                runtimeService.startProcessInstanceByKey(PROCESS_DEFINITION_KEY, variables);
        

        return new ProcessInstanceResponse(processInstance.getId(), processInstance.isEnded());
    }
    
    public void saveDemande(TDemande tDemande) {
    	congeRepository.save(tDemande);
    }
    
}
