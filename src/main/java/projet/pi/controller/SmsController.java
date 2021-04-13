package projet.pi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projet.pi.repository.productRepository;
import projet.pi.service.TwillioServiceImpl;


@RestController
@RequestMapping("/sms")
public class SmsController {
	
	@Autowired
	productRepository product_rep;
	@Autowired
	TwillioServiceImpl twillioService;
	
	@PostMapping("/sendSMS/{id}")
	public void sendSMS(@PathVariable("id") Long id) {
		String body = "Hello ConsommiTounsi user! " + product_rep.findBestProduct(product_rep.findBestProductByrayId(id)).getProductDescription() + "is our Produtc of the month , thank you for passing by soon !";
		twillioService.NotifSms("+21650204817","+18646614971", body);
		
		
	}
}
