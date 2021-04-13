package tn.esprit.spring.controler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Product;
//import tn.esprit.spring.entities.CommentProduct;
//import tn.esprit.spring.entities.CommentProductId;
import tn.esprit.spring.entities.ProductCategory;
import tn.esprit.spring.entities.Publicity;
import tn.esprit.spring.entities.PublicityCategory;
import tn.esprit.spring.repositry.ClientRepository;
import tn.esprit.spring.service.IProductService;
import tn.esprit.spring.service.IPublicityService;




@RestController
@CrossOrigin("*")
@RequestMapping("publicity")
public class PublicityController {
	
	@Autowired
	IPublicityService publicityservice;
	
	@Autowired
	IProductService productservice;
	
	
	@GetMapping("/publicities")
	public Iterable<Publicity> getAll(){
		return this.publicityservice.retrieveAllPublicities();
	}

	
	
	@DeleteMapping("/removepublicity/{id}")
	@ResponseBody
	public void removePublicity(@PathVariable("id") int id) {
		publicityservice.deletePublicity(id);
	}
	
	@GetMapping(value ="/findpublicity/{id}")
	@ResponseBody
	public Publicity retrievePublicity(@PathVariable("id") int id) {
	return  publicityservice.retrievePublicity(id);
	}
	

	@GetMapping("/findpublicitybycategory/{publicitycategory}")
	@ResponseBody
	public List<Publicity> findpublicity(@PathVariable("publicitycategory") PublicityCategory publicitycategory){
		List<Publicity> publicityresponse =  (List<Publicity>) publicityservice.retrieveByPublicityCategory(publicitycategory);
		return publicityresponse;
	}
	
	


// NO OVERLAP ALGORHiTHM
	@PostMapping ("/addpublicity/{idproduct}")
	public String add(@RequestBody Publicity p,@PathVariable("idproduct") int id1){
		Product product = productservice.retrieveProduct(id1);
		p.setProduct(product);
		List<Publicity> publicities = publicityservice.retrieveByPublicityCategory(p.getPublicitycategory());
		boolean overlap =false ;
		String msg = "Date indisponible";


		for (Publicity p1 : publicities){
			if (!((p.getEndDateP().compareTo(p1.getStartDateP()) <=0) |(p.getStartDateP().compareTo(p1.getEndDateP())>=0))) {
				overlap=true;
				break;
			}	
			
		}
		if (overlap==false) {
			this.publicityservice.addPublicity(p);
			msg = "publicity added";}
		return msg;
	}

		
	
	
	
	//current publicities Algorithm 
	@GetMapping("/currentpublicities")
	public ArrayList<Publicity> current(){

		Date Today=new java.util.Date();  
		List<Publicity> publicities = publicityservice.retrieveAllPublicities();
		ArrayList<Publicity> CurrentPublicities = new ArrayList<Publicity>();
		
		for (Publicity p2 : publicities){
			
			if (p2.isCurrent() == true){
				CurrentPublicities.add(p2);
			}
			
		}
		
		return CurrentPublicities;
	}
	


}
