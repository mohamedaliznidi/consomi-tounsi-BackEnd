package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Delivery;
import tn.esprit.spring.repositry.Deliveryrepositry;


@Service
public class Affectationtransport {

	@Autowired 
	Deliveryrepositry delive; 
	public String affectautomobile (Long id_delivery ) {
		String automobile="" ; 
		for(Delivery de : delive.findAll())
		{if ((de.getLenght()<100)&&(de.getWidth()<100))
				automobile = "moteur"; 
		else if ((de.getLenght()<1000)&&(de.getWidth()<1000))
			automobile = "car"; 
		
		else
			automobile = "car"; 
			
	}
		return automobile;}
}
