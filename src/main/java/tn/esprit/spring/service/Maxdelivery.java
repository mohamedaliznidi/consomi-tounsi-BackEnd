package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Delivery;
import tn.esprit.spring.repositry.Deliveryrepositry;


@Service 
public class Maxdelivery {
	@Autowired
	Deliveryrepositry dre ;
	public List <Delivery>afficheamax (float max, float min   ){
		List <Delivery> listDeliv=new ArrayList<Delivery>();
		for ( Delivery d : dre.findAll()) {
			if ((d.getWeight()<max)&&(d.getWeight()>min))
				listDeliv.add(d);
			
				
		}
		return listDeliv;
		
		
		
	}

}
