package tn.esprit.spring.controler;

import java.util.List;

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

import tn.esprit.spring.entities.ItemBasket;
import tn.esprit.spring.service.ItemBasketService;



@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/api/clients")
public class ItemBasketController {

	@Autowired
	ItemBasketService itemBasketService;
	
	@PostMapping("/additem")
	@ResponseBody
	public ItemBasket addItem(@RequestBody ItemBasket i) {
		return itemBasketService.addItem(i);
	}
	
	@PutMapping("/updateitem")
	  @ResponseBody
	  public String modifyItem( @RequestBody ItemBasket i) {
		itemBasketService.updateItem(i);
	   return "Item updated";
	  }
	  @DeleteMapping("/deleteitem/{id}")
	  @ResponseBody
	  public String deleteItem(@PathVariable int id) {
		  itemBasketService.deleteItem(id);
		return "Product deleted";
		}
	  
	  @GetMapping("/listitems")
	  @ResponseBody
	  public List<ItemBasket> getAllItems() {
		  return itemBasketService.getAll();	  
		  }
	  
	  @GetMapping("/getitem/{id}")
	  @ResponseBody
	  public ItemBasket getItem(@PathVariable int id) {
		  return itemBasketService.getItem(id);
	  }
	  
}
