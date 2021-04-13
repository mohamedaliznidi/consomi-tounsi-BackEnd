package tn.esprit.spring.controler;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Jackpot;
import tn.esprit.spring.repositry.Jackpotrepositry;

@RestController
@RequestMapping("random")
public class RandomNumberController {

	@Autowired
	Jackpotrepositry jk;
	
@GetMapping("/random")
    public int  getRandomNumber(){
	Jackpot jh =new Jackpot();
	
	
	jh.setName(  Math.abs( new Random().nextInt()  %50) );
	jk.save(jh);
        return jh.getName() ;
    }
}
