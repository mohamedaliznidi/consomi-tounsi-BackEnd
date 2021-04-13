package tn.esprit.spring.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("slot")
public class SlotMachineController {
	

	
	    private final RestTemplate restTemplate;
	
	
	    private static final String[] slotMachineSymbols = {"Cherry", "Bar", "Orange", "Plum"};

	    

		
	    @Autowired
	    public SlotMachineController(RestTemplate restTemplate){
	        this.restTemplate = restTemplate;
	    }
	    @SuppressWarnings("unlikely-arg-type")
		@RequestMapping("rand")
	    public String spin(){
	    	String s1 = getSingleSpinResult();
	    	String s2 = getSingleSpinResult();
	    	String s3 = getSingleSpinResult();
	    	if(s1.equals(s3) && s3.equals(s2) && s1.equals(s2))
	    	 {
	    		System.out.println("won");
	    	
	    		
		        return String.format("won  %s %s %s", s1, s2, s3);
	    	}
	    	
	    	
	        return String.format("lose  %s %s %s", s1, s2, s3);
	    }

	    private String getSingleSpinResult(){
	        int randomNumber = restTemplate.getForObject("http://localhost:8092/random/random", Integer.class);
	        
	        return slotMachineSymbols[Math.abs(randomNumber % slotMachineSymbols.length)];
	    }
}
	 


