package tn.esprit.spring.controler;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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

import tn.esprit.spring.entities.Basket;
import tn.esprit.spring.service.BasketService;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/api/v1")
public class BasketController {
	@Autowired
	BasketService basketService ;
	
	@PostMapping("/addbasket")
	@ResponseBody
	public Basket Basket(@RequestBody Basket b) {
		return basketService.addBasket(b);
	}
	@PutMapping("/updatebasket")
	  @ResponseBody
	  public Basket modifyBasket( @RequestBody Basket b) {
		return basketService.updateBasket(b);
	  }
	
	@DeleteMapping("/deletebasket/{id}")
	  @ResponseBody
	  public String deleteItem(@PathVariable int id) {
		basketService.deleteBasket(id);
		return "Basket deleted";
		}
	
	@GetMapping("/listbaskets")
	  @ResponseBody
	  public List<Basket> getAllBaskets() {
		  return basketService.getAll();	  
		  }
	@GetMapping("/getbasket/{id}")
	  @ResponseBody
	  public Map<String,Object> getItem(@PathVariable int id) {
		  return basketService.getBasket(id);
	  }
	

}
