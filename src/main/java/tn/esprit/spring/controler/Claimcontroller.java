package tn.esprit.spring.controler;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

import tn.esprit.spring.entities.Claim;
import tn.esprit.spring.model.Nbclaimaff;
import tn.esprit.spring.repositry.Claimrepositry;
import tn.esprit.spring.service.Bestone;
import tn.esprit.spring.service.ClaimService;




@RestController
@CrossOrigin("*")
/*@RequestMapping("/api")*/
public class Claimcontroller {
	
	@Autowired
	 private Claimrepositry categoryRepository;
	
	@Autowired
	ClaimService cs ; 
	
	/*@Autowired
	private NoteApplication na; */
	
	@Autowired
	Bestone best ;

	
		@PostMapping("/add")
		public void add(@RequestBody   Claim cat)
		{
			this.categoryRepository.save(cat);
			
		}
		
		@GetMapping("/cat")
		
		public Iterable<Claim> getAll(){
			return this.categoryRepository.findAll();
		}
		
		@RequestMapping(value = "/findcat/{subject_claim}", method = RequestMethod.GET)
		@ResponseBody
		public List<Claim> findStudents(@PathVariable String subject_claim) {
			List<Claim> studentResponse = (List<Claim>) categoryRepository.getPubliityBypublictyname(subject_claim);
			return studentResponse;
		}
		
		@PutMapping("/updateclaim/{idclaim}")
		@ResponseBody
		public Claim updateclaim(@PathVariable("idclaim") Long idclaim, @RequestBody Claim claim) {
			Claim c = categoryRepository.getClaimById(idclaim);
			c.setDescreption(claim.getDescreption());
			c.setSubject_claim(claim.getSubject_claim());
			c.setState(claim.isState());
			c.setIdProblem(claim.getIdProblem());
		    
		
		
			categoryRepository.save(c);
			return c ;
		}
		

		@DeleteMapping("/deleteclaim/{idclaim}")
		public String deleteman(@PathVariable("idclaim") Long idclaim) {
			Claim claim = categoryRepository.findById(idclaim)
		      .orElseThrow(() -> new IllegalArgumentException("Invalid claim Id:" +idclaim));
			categoryRepository.delete(claim);
		    return "redirect:/index"; }
		
		
		
		@GetMapping("/saticclaim")
		public HashMap<String, Integer> statistique () {
			  return cs.Claimmax();
		}
		
			
         /*@GetMapping("/note")
         public String note() {
        	return  na.notedelivery();
         }*/
        
		
		@GetMapping("/list")
         public List<Nbclaimaff>  cl() {
        	 return best.bestone();
         }}
	 

