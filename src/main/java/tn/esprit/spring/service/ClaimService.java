package tn.esprit.spring.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Claim;
import tn.esprit.spring.repositry.Claimrepositry;
@Service
@Transactional
public class ClaimService {
	@Autowired
	Claimrepositry cla ;
	
public   HashMap<String, Integer> Claimmax ( ) {
    	int claim_deliveryman =0;
    	int claim_Product =0;
    	int claim_time =0;
    	int claim_other =0 ;
    	int nbr_claim =  0; 
    	for ( Claim c :cla.findAll()) {
    	if (c.getSubject_claim().equals("Deliveryman"))
    		claim_deliveryman=claim_deliveryman+1;
    	   
    	else {
    		if (c.getSubject_claim().equals("Product"))
        		claim_Product=claim_Product+1;
    		else {
    			if (c.getSubject_claim().equals("Time"))
    	    		claim_time=claim_time+1;
    			else 
    	    		claim_other=claim_other+1;
    			
    		}
    	}
    	
    	
    	
    	}
    	
    	
    	 nbr_claim=claim_deliveryman+claim_Product+claim_time+claim_other;
    	 HashMap<String, Integer> statique  = new HashMap<String, Integer>();
    	 statique.put("Deliveryman", claim_deliveryman);
    	 statique.put("Product", claim_Product);
    	 statique.put("Time", claim_time);
    	 statique.put("Other", claim_other);
    	 
    	 
    	 
    	 return statique;
    	
    		
    		 
    	
    		
    		
    	
    		
		
	}
	}

//}
