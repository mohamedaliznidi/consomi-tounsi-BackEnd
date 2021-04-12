package  tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Delivery;
import tn.esprit.spring.repositry.Deliveryrepositry;



@Service
@Transactional
public class Fraislivraison implements Frais {
	
	@Autowired
    Deliveryrepositry delirep ;
    
	public int livraisonfrais(Long deliv_id) {
		// TODO Auto-generated method stub
		float dl ,da ; 
		
		 int frais=8;
		 Delivery deli = (Delivery) delirep.findById(deliv_id).get() ; 
		 dl=deli.getLongitude()-36;
		 da=deli.getLaltitude()-10;
		
		 if (deli.getWeight()>50) {
			 frais = frais+4 ;
		 }
		 
		 if((deli.getWidth()>1500)||(deli.getLenght()>1500))
			 frais=frais+4;
		
		 if((dl>1)&&(da>1))
				frais=frais+4; 

			 
		 /*Latitude : 36.8189700
		 Longitude : 10.1657900
		 Latitude : 37°
		 Longitude : 9°52′26″
		 */
		 
		 
		 
		 
 
		
	
          
          
         return frais; }
	}
         


