package tn.esprit.spring.controler;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
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
import tn.esprit.spring.entities.OrderC;
import tn.esprit.spring.service.ItemBasketService;
import tn.esprit.spring.service.OrderCService;
import tn.esprit.spring.util.GeneratePdfReport;

@RestController
@CrossOrigin(origins = "*",maxAge=3600)
@RequestMapping("/api/v1")
public class OrderCController {	
	@Autowired
	OrderCService orderCService;
	@Autowired
	ItemBasketService itemBasketService ;
	
	@RequestMapping(value = "/pdfreport/{id}", method = RequestMethod.GET,produces = MediaType.APPLICATION_PDF_VALUE)
           
    public ResponseEntity<InputStreamResource> ordersReport(@PathVariable int id) {

      OrderC orderC = orderCService.getOrderC(id) ;	
     // GeneratePdfReport generate = new GeneratePdfReport() ;
        ByteArrayInputStream bis = GeneratePdfReport.ordersReport(orderC,itemBasketService.getItemsByBasketId(orderC.getBasket().getId()));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=order_report.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
	 @GetMapping("/searchOrderc/{search}")
	 @ResponseBody
	  public List<OrderC> searchOrder(@PathVariable("search")String search) {
	  return orderCService.search(search);
	  }	 
	
	  @PutMapping("/updateord")
	  @ResponseBody
	  public String modifyOrderC( @RequestBody OrderC orderC) {
	   orderCService.updateOrderC(orderC);
	   return "Order updated";
	  }
	  
	  @GetMapping("/ListOrderC")
	  @ResponseBody
	  public List<OrderC> getAllOrderC() {
		return orderCService.getAllEntreprises();
	  }
	  
	  @GetMapping("/ListOrderC/{id}")
	  @ResponseBody
	  public OrderC getOrderC(@PathVariable int id) {
		return orderCService.getOrderC(id);
	  }
	  
		@PostMapping("/addOrderC")
		@ResponseBody
		public void addOrderC(@RequestBody OrderC orderC) {
		 orderCService.addOrderC(orderC);
		}
		@DeleteMapping("/ListOrderC/{id}")
		  @ResponseBody
		  public String deleteOrderC(@PathVariable int id) {
			orderCService.deleteOrder(id);
			return "Order deleted";
			
			
			}
}
