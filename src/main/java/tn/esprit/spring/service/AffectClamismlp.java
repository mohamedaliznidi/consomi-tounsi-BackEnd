/*package tn.esprit.spring.service;;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import tn.esprit.com.entity.Claim;
import tn.esprit.com.entity.Deliveryman;
import tn.esprit.com.repositry.Claimrepositry;
import tn.esprit.com.repositry.Deliverymanrepositry;


import tn.esprit.com.repositry.Claimrepositry;
import tn.esprit.com.repositry.Deliverymanrepositry;


@Service
public class AffectClamismlp implements AffectationClaims {
	

	@Autowired
	 Claimrepositry claimrepo ; 
	@Autowired
	Deliverymanrepositry delivrepo ;
	@Override
	public HashMap<Integer, Integer> bestone() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*public HashMap<Integer , Integer> bestone ( ){
		for ( Claim c :claimrepo.findAll()) {
	    	if (c.getSubject_claim().equals("Deliveryman")) {
	    		c.getIdProblem()
	    	}
	    		
	    	   
		
	}
	
	
	
	/*public Deliveryman Affectationclaims ( @RequestBody Deliveryman dev ) {
	
		
	 
		
		for (Claim cl : claimrepo.findAll()) {
			long idc=cl.getIdProblem();
		if (cl.getSubject_claim().equals("Deliveryman")) {
			
			
				for(Deliveryman dev1 : delivrepo.findAll()) {
			  dev1:delivrepo.findById(idc).get();
			dev1.setClaim_client(dev.getClaim_client()+1);
			
			delivrepo.save(dev1);}
			}
			
			
			
			
			
			
			
	
			
			
		 
		
		 }
	
		return dev;}
	}
	*/
	
	