package tn.esprit.spring.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Delivery;
import tn.esprit.spring.repositry.Deliveryrepositry;
import tn.esprit.spring.service.Affectationtransport;
import tn.esprit.spring.service.Fraislivraison;
import tn.esprit.spring.service.Maxdelivery;




@RestController
@CrossOrigin("*")
public class DeliveryControlleur {
	@Autowired 
	Fraislivraison fraislivraison ;
	@Autowired 
	private Deliveryrepositry delivery ;
	@Autowired
	Maxdelivery max ;
	@Autowired
	Affectationtransport aff ;

	@GetMapping ("/frais/{id_deliv}")
public int getfrais (@PathVariable("id_deliv") Long id_deliv) {
	
	return fraislivraison.livraisonfrais(id_deliv)  ;
}
	@PostMapping("/addliv")
	public void add(@RequestBody Delivery   dv)
	{
		this.delivery.save(dv);
		
	}
	
	@GetMapping("/getliv")
	
	public List<Delivery> getAll(){
		return this.delivery.findAll();
	}
	
    @GetMapping ("/max/{weight}/{weightmin}")
    public List<Delivery> affi(@PathVariable("weight") float weight, @PathVariable("weightmin") float weightmin ){
    	return max.afficheamax(weight,weightmin );
    	
    }
    @GetMapping("/delivery/{id_deliv}")
    public String aff(@PathVariable("id_deliv") long id_deliv) {
    	return aff.affectautomobile(id_deliv);
    
    }
    }
   
		
    

