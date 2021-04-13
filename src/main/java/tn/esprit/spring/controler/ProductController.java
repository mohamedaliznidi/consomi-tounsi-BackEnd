package tn.esprit.spring.controler;
import tn.esprit.spring.entities.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import tn.esprit.spring.repositry.ProductCategoryRepository;
import tn.esprit.spring.repositry.ProductRepository;
import tn.esprit.spring.service.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.fasterxml.jackson.databind.ObjectMapper; 
import com.fasterxml.jackson.databind.ObjectWriter; 


@RestController
@CrossOrigin("*")
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	
	
	private IProductService productserviceimpl;
	
	@Autowired
	private ProductRepository pr;
	
	@Autowired
	
	private ProductCategoryRepository pcr;
	
	@PostMapping ("/addproduct/{category_id}")
	public void add(@RequestBody Product p, @PathVariable("category_id") int id){
		
		if (p.getNature().toString().equals("Alimentaire"/**.toLowerCase()*/)){
			
			
			Product p1 = new Product(p.getName(),p.getCode(),p.getPrice(),p.getImage(),p.getQuantity(),p.getExpDate(),p.getGeneralrate(),
					p.getNature(),p.getEnergie(),p.getMatiere_grasse(),p.getAcide_gras_sature(),p.getSucres(),p.getFibres()
					,p.getProteines(),p.getSel(),p.getFruits(),p.getMatiere());
			ProductCategory cat = pcr.findById(id).get();
			p1.setProductCategory(cat);
			String category_name =cat.getCategoryName();
			p1.setCategoryname(category_name);
			p1.setInitial_price(p1.getPrice());
			this.productserviceimpl.addProduct(p1);
				}
		else {
			Product p1 = new Product (p.getName(),p.getCode(),p.getPrice(),p.getImage(),p.getQuantity(),p.getExpDate(),p.getGeneralrate(),p.getNature(),p.getMatiere()); // ajouter tous leess prop sans les energies
			ProductCategory cat = pcr.findById(id).get();
			p1.setProductCategory(cat);
			String category_name =cat.getCategoryName();
			p1.setCategoryname(category_name);
			p1.setInitial_price(p1.getPrice());
			this.productserviceimpl.addProduct(p1);
		}
		
		
		
		
	}
	
	@GetMapping("/products")
	public Iterable<Product> getAll(){
		return this.productserviceimpl.retrieveAllProducts();
	}
	
	@GetMapping(value ="/findproduct/{id}")
	@ResponseBody
	public Product findproduct(@PathVariable("id")  int id){
		Product productresponse =  (Product) productserviceimpl.retrieveProduct(id);
		return productresponse;
		
		}
	
	@GetMapping(value ="/findproductbyname/{name}")
	@ResponseBody
	public List<Product> findproduct(@PathVariable String name){
		List<Product> productresponse =  (List<Product>) productserviceimpl.retrieveByName(name);
		return productresponse;
		
		}

	@DeleteMapping("/deleteproduct/{id}")
	@ResponseBody
	public void removeProduct(@PathVariable("id") int id) {
	productserviceimpl.deleteProduct(id);
	}
	
	

	
	@GetMapping(value ="/findproductbycategory/{productCategory}")
	@ResponseBody
	public List<Product> findproductbyCategory(@PathVariable("productCategory") ProductCategory productCategory){
		List<Product> productresponse =  (List<Product>) productserviceimpl.retrieveByProductCategory(productCategory);
		return productresponse;
		
		}
	
	
	@GetMapping(value ="/findproductbycategoryName/{productCategory_name}")
	@ResponseBody
	public List<Product> findproductbyCategory(@PathVariable("productCategory_name") String productCategory_name){
		
		List<Product> productresponse =  (List<Product>) productserviceimpl.retrieveByProductCategoryName(productCategory_name);
		return productresponse;
		
		}
	
		 
	@GetMapping(value ="/findproductbyquantity/{q}")
	@ResponseBody
	public List<Product> findproductbyquantity(@PathVariable("q") int q){
		List<Product> productresponse =  (List<Product>) productserviceimpl.retrieveQuantityLessThan(q);
		return productresponse;
		
		}
	
	@PutMapping("/modifyproduct")
	@ResponseBody
	public void modifyProduct(@RequestBody Product p) {
	 productserviceimpl.updateProduct(p);
	}
	
	
	@PutMapping("/promotion/{id}/{pourcentage}")
	@ResponseBody
	public void promotion(@PathVariable("id") int id, @PathVariable("pourcentage") int pourcentage) {
		Product productpromotion =  (Product) productserviceimpl.retrieveProduct(id);
		float price = (float) productpromotion.getPrice();
		float newprice= price*(100-pourcentage)/100;
		productpromotion.setPrice(newprice);
		productpromotion.setPromotion(pourcentage);
		this.productserviceimpl.updateProduct(productpromotion);
		
		
	
	}
	
	@PutMapping("/annulerpromotion/{id}")
	@ResponseBody
	public void promotion(@PathVariable("id") int id) {
		Product productpromotion =  (Product) productserviceimpl.retrieveProduct(id);
		float price = (float) productpromotion.getInitial_price();
		productpromotion.setPrice(price);
		this.productserviceimpl.updateProduct(productpromotion);
		
		
	
	}
	
	
	
	//READY FOR ML
	@GetMapping("/showlink")
	@ResponseBody
	public String showlink(){
		 String msg = "{ok ok, ok}";
		
		   try {
			   


			   ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			   String json = ow.writeValueAsString(msg);
		   
	            URL url = new URL("http://127.0.0.1:5000/");
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            conn.setRequestMethod("GET");
	            conn.setRequestProperty("Accept", "application/json");

	            if (conn.getResponseCode() != 200) {
	                throw new RuntimeException("Failed : HTTP error code : "
	                        + conn.getResponseCode());
	            }

	            BufferedReader br = new BufferedReader(new InputStreamReader(
	                    (conn.getInputStream())));

	            String output;
	            System.out.println("Output from Server .... \n");
	            while ((output = br.readLine()) != null) {
	            	return output;
	            }

	            conn.disconnect();

	        } catch (MalformedURLException e) {
	            e.printStackTrace();
	        }catch (IOException e){
	e.printStackTrace();
	        }
		   return "Not working";

	    }

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Healthy Score 
	
	@GetMapping("/generateHealthyscore/{id}")
	@ResponseBody
	public int Healthyscore(@PathVariable("id") int id ){
	
		Product p = pr.findById(id).get();
		int energie=p.getEnergie();
		float matieres_grasses=p.getMatiere_grasse();
		float acides_gras_satures=p.getAcide_gras_sature();
		float sucres=p.getSucres();
		float fibres=p.getFibres();
		float proteines=p.getProteines();
		float sel=p.getSel();
		int fruits=p.getFruits();
		int score=0;
		int pts=0;
		if (p.getNature().toString().equals("Alimentaire"/**.toLowerCase()*/) ){
			
			
			
			if (p.getProductCategory().getId() == 1)
			{
			
			  
				
			    if (energie <= 0) {pts=0;}
			        else if (energie <= 30) {pts=1;}
			        else if (energie <= 60) {pts=2;}
			        else if (energie <= 90) {pts=3;}
			        else if (energie <= 120) {pts=4;}
			        else if (energie <= 150) {pts=5;}
			        else if (energie <= 180) {pts=6;}
			        else if (energie <= 210) {pts=7;}
			        else if (energie <= 240) {pts=8;}
			        else if (energie <= 270) {pts=9;}
			        else if (energie > 270) {pts=10;}
			    
			    	
			        }
			    else {
			    	
			        if (energie <= 335) {pts=0;}
			        else if (energie <= 670) {pts=1;}
			        else if (energie <= 1005) {pts=2;}
			        else if (energie <= 1340) {pts=3;}
			        else if (energie <= 1675) {pts=4;}
			        else if (energie <= 2010) {pts=5;}
			        else if (energie <= 2345) {pts=6;}
			        else if (energie <= 2680) {pts=7;}
			        else if (energie <= 3015) {pts=8;}
			        else if (energie <= 3350) {pts=9;}
			        else if (energie > 3350) {pts=10;}
			        

			    }
			 
			score=score-pts;
			
			
			if (matieres_grasses > 100){
		        matieres_grasses = 100;
		        }

		    if (acides_gras_satures > 100){
		        acides_gras_satures = 100;
		        }   
		    
		   
		    if (p.getProductCategory().getCategoryName().equals("matieres_grasses")){
		   	
		    float ratio =0;
		    ratio = Math.round(acides_gras_satures/matieres_grasses*10000)/100;
		    
		    if (ratio < 10){pts=0;}
	        else if (ratio < 16){pts=1;}
	        else if (ratio < 22){pts=2;}
	        else if (ratio < 28){pts=3;}
	        else if (ratio < 34){pts=4;}
	        else if (ratio < 40){pts=5;}
	        else if (ratio < 46){pts=6;}
	        else if (ratio < 52){pts=7;}
	        else if (ratio < 58){pts=8;}
	        else if (ratio < 64){pts=9;}
	        else if (ratio >= 64){pts=10;}
		    score-=pts;
		    
		    }
		    
		    else {
		    	
		    	if (acides_gras_satures <= 1) {pts=0;}
		        else if (acides_gras_satures <= 2) {pts=1;}
		        else if (acides_gras_satures <= 3) {pts=2;}
		        else if (acides_gras_satures <= 4) {pts=3;}
		        else if (acides_gras_satures <= 5) {pts=4;}
		        else if (acides_gras_satures <= 6) {pts=5;}
		        else if (acides_gras_satures <= 7) {pts=6;}
		        else if (acides_gras_satures <= 8) {pts=7;}
		        else if (acides_gras_satures <= 9) {pts=8;}
		        else if (acides_gras_satures <= 10) {pts=9;}
		        else if (acides_gras_satures > 10) {pts=10;}
		    	score-=pts;
		    	
		    	 }
		    
		   
		    
		    if (sucres > 100){
                sucres = 100;
            }
		    
		    if (p.getProductCategory().getCategoryName().equals("Boissons")){
		    	
		    	 if (sucres <= 0) {pts=0;}
	                else if (sucres <= 1.5) {pts=1;}
	                else if (sucres <= 3) {pts=2;}
	                else if (sucres <= 4.5) {pts=3;}
	                else if (sucres <= 6) {pts=4;}
	                else if (sucres <= 7.5) {pts=5;}
	                else if (sucres <= 9) {pts=6;}
	                else if (sucres <= 10.5) {pts=7;}
	                else if (sucres <= 12) {pts=8;}
	                else if (sucres <= 13.5) {pts=9;}
	                else if (sucres > 13.5) {pts=10;}
		    	 score-=pts;
		    	
		    }
		    
		    else {
                if (sucres <= 4.5) {pts=0;}
                else if (sucres <= 9) {pts=1;}
                else if (sucres <= 13.5) {pts=2;}
                else if (sucres <= 18) {pts=3;}
                else if (sucres <= 22.5) {pts=4;}
                else if (sucres <= 27) {pts=5;}
                else if (sucres <= 31) {pts=6;}
                else if (sucres <= 36) {pts=7;}
                else if (sucres <= 40) {pts=8;}
                else if (sucres <= 45) {pts=9;}
                else if (sucres > 45) {pts=10;}
                score-=pts;
            }

		    
		   
		    if (fibres > 100){
                fibres = 100;
            }
		    
		    { if (fibres <= 0.9) {pts=0;}
            else if (fibres <= 1.9) {pts=1;}
            else if (fibres <= 2.8) {pts=2;}
            else if (fibres <= 3.7) {pts=3;}
            else if (fibres <= 4.7) {pts=4;}
            else if (fibres > 4.7) {pts=5;}
		    
		   score+=pts;}
		   
		   
		   if (proteines > 100){
	            proteines = 100;
	        }

		   { if (proteines <= 1.6) {pts=0;}
	        else if (proteines <= 3.2) {pts=1;}
	        else if (proteines <= 4.8) {pts=2;}
	        else if (proteines <= 6.4) {pts=3;}
	        else if (proteines <= 8) {pts=4;}
	        else if (proteines > 8) {pts=5;}
	        
	        score+=pts;
		   }
	        
	        if (sel > 100){
	            sel = 100;}

	        float sodium=sel*400;
	        {   if (sodium <= 90) {pts=0;}
	            else if (sodium <= 180) {pts=1;}
	            else if (sodium <= 270) {pts=2;}
	            else if (sodium <= 360) {pts=3;}
	            else if (sodium <= 450) {pts=4;}
	            else if (sodium <= 540) {pts=5;}
	            else if (sodium <= 630) {pts=6;}
	            else if (sodium <= 720) {pts=7;}
	            else if (sodium <= 810) {pts=8;}
	            else if (sodium <= 900) {pts=9;}
	            else if (sodium > 900) {pts=10;}
	        
	        score-=pts;}
	      
	        
	        if (fruits > 100){
	            fruits = 100;
	        }
	        
	        if (p.getProductCategory().getCategoryName().equals("Boissons")){
	        	
	        	if (fruits <= 40) {pts=0;}
	            else if (fruits <= 60) {pts=2;}
	            else if (fruits <= 80) {pts=4;}
	            else if (fruits > 80) {pts=10;}
	        	 score+=pts;
	        	 }
	        
	        else { 
	            if (fruits <= 40) {pts=0;}
	            else if (fruits <= 60) {pts=1;}
	            else if (fruits <= 80) {pts=2;}
	            else if (fruits > 80) {pts=5;}
	            score+=pts;
	        } 
	        
	       
			

		}
		
		return score;
			   
			}
	
	
	
	// Eco Score
	
	
	@GetMapping("/generateEcoScore/{id}")
	@ResponseBody
	public int Ecoscore(@PathVariable("id") int id ){
		Product p = pr.findById(id).get();
		String matiere = p.getMatiere().toString();
	    int eco=0 ;
	    if ((matiere== "carton")
	    | (matiere =="papier") 
	    | (matiere=="vegetal") 
	    | (matiere =="bioplastique"))
	    {eco=1;}

	    else if (matiere== "bois")
	    {eco=2;}

	    else if ((matiere== "aluminium")
	    | (matiere =="metal") 
	    | (matiere=="plastique") 
	    | (matiere =="papier_plastifie"))
	    {eco=3;}
	    
	    else if ((matiere== "verre")
	    	    | (matiere =="Polystyrene") 
	    	    | (matiere=="plastique_type_bouteille") 
	    	    | (matiere =="autre"))
	    	    {eco=4;}
	    
	    return eco;
	    
	}

	

	

	
	
}
			
			
		
		
	



