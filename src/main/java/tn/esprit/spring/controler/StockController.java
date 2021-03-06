package tn.esprit.spring.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Stock;
import tn.esprit.spring.service.StockServiceImp;
import tn.esprit.spring.service.StockServiceImpl;

@RestController
@RequestMapping("/stock")
public class StockController {

	@Autowired
	StockServiceImpl stockService;
	
	@PostMapping("/addStock")	
	public int addStock(@RequestBody Stock s) {
		stockService.addStock(s);
		return s.getId();
	}
	
	@DeleteMapping(value = "/deleteStock/{id}")
	public void deleteStock(@PathVariable("id")int id) {
		stockService.deleteStock(id);
		
		
	}
	
	@PutMapping(value = "/updateStock") 
	public Stock updateBill(@RequestBody Stock s)  {
		return stockService.updateStock(s);
	}

	@GetMapping("/getAllStocks")
	public List<Stock> getAllStocks() {

		return stockService.getAllStocks();
	}
	@PutMapping(value = "/orderProduct/{pid}/{amount}")
	public void orderProduct(@PathVariable("pid")int pid,@PathVariable("amount")int amount) {
		 stockService.orderProduct(pid, amount);
		
	}
	@PostMapping("sendMail")
	public void SendMail(){
		stockService.sendEmail();
	}
}