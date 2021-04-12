package tn.esprit.spring.controler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.entities.Donation;
import tn.esprit.spring.entities.Donations;
import tn.esprit.spring.entities.Product;
import tn.esprit.spring.repositry.Donationsrepositry;
import tn.esprit.spring.service.DonationService;

@RestController
@RequestMapping("donation")
public class Donationcontroller {
	@Autowired
	private DonationService service;
	
	@Autowired 
	
	Donationsrepositry donrep;
	
	@PostMapping("/adddonation")
	public String adddonation(@RequestBody Donation donation) {
		
	       int number_of_donations_wanted=donation.getState();
		
		List<Product>  p = new ArrayList<>();
		List<String >   ct = new ArrayList();
		
		
		List<Donations>  df = donrep.findAll();
		
		for( Donations d1 :  donrep.findAll())
		{	String m = d1.getProducts().getProductCategory().getCategoryName();
			ct.add(m);
			
			  /*for(Product pl : d1.getProducts()) {
				   String m  = pl.getProductCategory().getCategoryName();
				   ct.add(m);
			  }*/
		       
		}
		
		
		String[] Categories = {"Lait", "eau", "pates"};
		int[] quantities_per_pack = {1, 1, 1};

		Dictionary big_family_donation_dict = new Hashtable();
		for(int i = 0; i < Categories.length; i++){
		    big_family_donation_dict.put( Categories[i],quantities_per_pack[i]
		                    );
		  }
		

		  ArrayList<Integer>  faisability= new ArrayList<Integer>();
		    int variable=0;
		for(int i = 0; i < Categories.length; i++){

		    int quantity=0;
		    for (/*Product d*/ String d : ct){

		//d.getProductCategory().getCategoryName().equals(categories(i))
		if (d.equals(Categories[i])){

		quantity=quantity+1;
		}
		}
		variable=quantity/quantities_per_pack[i];

		    int variable1 = (int) variable;
		faisability.add(variable);
		  System.out.println(faisability);
		}

		boolean k;
		int c=-1;
		do {c++;

		    k=false;
		    int ok= faisability.get(c);
		    if (ok >= number_of_donations_wanted)
		    {
		        k=true;  
		    }

		System.out.println(c);
		}while((k==true) & (c<Categories.length-1));


		if (c== Categories.length-1){

		    //add donation
		 //   msg= "Donation added";
	 service.save(donation);
	 return "ok";

		}
		else {
		
		    return  "not  ok";
		}
		    
		
		


}
	@GetMapping("/donation/{id}")
	public Donation findById(@PathVariable int id) {
		return service.getDonationById(id);
	}
	
	@PutMapping("/update")
	public Donation updateDonation(@RequestBody Donation donation) {
		return service.updateDonation(donation);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteDonation(@PathVariable int id) {
		return service.deleteDonation(id);
	}
	
}
