package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Claim;
import tn.esprit.spring.model.Nbclaimaff;
import tn.esprit.spring.repositry.Claimrepositry;


@Service
public class Bestone {
	@Autowired
	Claimrepositry crep;
	//@Autowired
	//Deliverymanrepositry dev ;
	List<Claim> Lrec = new ArrayList<>();
	//List<Deliveryman> Ldeliv = new ArrayList<>();
	List<Nbclaimaff> Lnb = new ArrayList<>();
	List<Long> Lid = new ArrayList<>();
	List<Long> Lexist = new ArrayList<>();
	
	
	/*public HashMap<Integer , Integer>  bestdelivery ( ) {
		
        int []aa = new int [100] ; 
		List <Long > listDeliv=new ArrayList<Long>();
		 HashMap<Integer, Integer> bestdeli  = new HashMap<Integer, Integer>();
		for(Long i = 0;i<crep.count();i++) {
		  Claim claim=crep.findAll().get(i);
		   listDeliv.add(i,claim.getIdProblem());
		   
		   for (Deliveryman d : dev.findAll()) {
			   return nbreRep(d.getDelivery_id(),listDeliv )
		   }
		   
		   
		 /* for (int j=0; j<listDeliv.size();j++) {
			  for(int k=1;k<listDeliv.size();j++) {
				  if(i!=k) {
				  if(listDeliv.get(j)==listDeliv.get(k))
					
					aa[j]++;
				  
				 
				  bestdeli.put(j,aa[j]);
			  }}
			  
		  }
		  
	}
return bestdeli;
}*/
	public int nbreRep (long i,List <Long> l) {
		int nb =  0 ;
		for(long j : l) {
			if(i==j) {
				nb++;}
			
			}
		return nb;
	} 
	public boolean isexist(long i , List<Long> l) {
		boolean test = false;
		for(long j : l) {
			if(j==i) {
				test = true;
			}
			
		}
		return test;
	}
public List<Nbclaimaff> bestone () {
	Lrec= crep.findAll();
	List<Nbclaimaff> Lnb = new ArrayList<>();
	List<Long> Lid = new ArrayList<>();
	List<Long> Lexist = new ArrayList<>();
	Nbclaimaff nb = new Nbclaimaff();
	for(Claim c : Lrec) {
		if(c.getSubject_claim().equals("Deliveryman")) {
			Lid.add(c.getIdProblem());
			//nb.setId_deli(c.getIdProblem());
			//nb = new Nbclaimaff();
			System.out.println(c.getSubject_claim());
			System.out.println(Lid);
		}}
    for(long j : Lid) {
    	
    	if(!isexist( j ,  Lexist)) {
    		nb.setId_deli(j);
    		nb.setNbclaims(nbreRep ( j, Lid));
    		System.out.println(nb.getId_deli());
    		
    		Lnb.add(nb);
    		nb = new Nbclaimaff();
    		Lexist.add(j);
    		
    	}
    	
    	
		 
		 }
		
	
	


	
			 
		 

	return Lnb;}


	
}
	

