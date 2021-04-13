package tn.esprit.spring.controler;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import com.google.maps.model.LatLng;

import tn.esprit.spring.data.Store;
import tn.esprit.spring.entities.Deliveryman;
import tn.esprit.spring.repositry.Deliverymanrepositry;
import tn.esprit.spring.service.Fraislivraison;
import tn.esprit.spring.service.GeocodeService;


//import tn.resprit.com.outil.StatisticService;

@RestController
@CrossOrigin("*")

public class Deliverymancontroller {
	//@Autowired 
	//StatisticService statisticService;
	//@Autowired 
	//Fraislivraison fraislivraison ; 
	//@Autowired
	//Prime prime;
	@Autowired
	 private Deliverymanrepositry deliveryRepository;
	
	
		
	    @PostMapping(value="/add1", produces=MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody ResponseEntity<Deliveryman >   add1(@RequestBody   Deliveryman cat1) throws Exception 
		{
			return new ResponseEntity<>( this.deliveryRepository.saveAndFlush(cat1),HttpStatus.CREATED);
			
		}

	@PostMapping("/adddelevry")
	public void add(@RequestBody  Deliveryman  cat1)
	{
		this.deliveryRepository.save(cat1);
		
	}
		
		@GetMapping("/cat1")
		
		public List<Deliveryman> getAll(){
			return this.deliveryRepository.findAll(Sort.by("lastname"));
		}
		
		@RequestMapping(value = "/findcat1/{lastname}", method = RequestMethod.GET)
		@ResponseBody
		public List<Deliveryman> findStudents123(@PathVariable String lastname) {
			List<Deliveryman> studentResponse = (List<Deliveryman>) deliveryRepository. getDeliveryByDeliveryname(lastname);
			return studentResponse;
		}
        
		@PutMapping("/update/{delivery_id}")
		@ResponseBody
		public Deliveryman updatedeliveryman(@PathVariable("delivery_id") Long delivery_id, @RequestBody Deliveryman deliveryman) {
			Deliveryman d =deliveryRepository.getDeliveryById(delivery_id);
			//d.setAdress(deliveryman.getAdress());
			d.setFristName(deliveryman.getFristName());
			d.setJoblist(deliveryman.getJoblist());
			d.setLastname(deliveryman.getLastname());
			d.setPhonenumber(deliveryman.getPhonenumber());
			d.setSalary(deliveryman.getSalary());
			d.setRank(deliveryman.getRank());
		    
		
		
		deliveryRepository.save(d);
		    
		return d;  
		    }

		
		
		

@DeleteMapping("/delete/{delivery_id}")
public String deleteman(@PathVariable("delivery_id") Long delivery_id) {
	Deliveryman Deliveryman = deliveryRepository.findById(delivery_id)
      .orElseThrow(() -> new IllegalArgumentException("Invalid deliveryman Id:" + delivery_id));
    deliveryRepository.delete(Deliveryman);
    return "redirect:/index"; }


/*@GetMapping("/satitic")
public List<Deliveryman> show_d (){
	return statisticService.stat();
}*/

@Autowired
@Qualifier("geocodeService")
private GeocodeService geocodeService;

/**
 * the data store
 */
@Autowired
@Qualifier("memoryStore")
private Store<Deliveryman, LatLng> store;

/**
 * REST endpoint for adding a shop
 * 
 * @param shop
 */
@RequestMapping(path = "/shop", method = RequestMethod.POST)
public void addShop(@RequestBody Deliveryman shop) {
	LatLng geocode = geocodeService.getGeocode(shop);
	if (null != geocode) {
		shop.getShop1().setDeliveryLatitude(geocode.lat);
		shop.getShop1().setDeliveryLongitude(geocode.lng);
	}
	store.add(shop);
}

/**
 * REST endpoint to find the nearest shop from a location marked with
 * latitude and longitude
 * 
 * @param latitude,
 *            the latitude of the customer
 * @param longitude,
 *            the longitude of the customer
 * @return the nearest shop
 */
@RequestMapping(path = "/shop/{latitude}/{longitude}", method = RequestMethod.GET)
public Deliveryman getShop(@PathVariable double latitude, @PathVariable double longitude) {
	LatLng geocode = new LatLng(latitude, longitude);
	Deliveryman shop = store.get(geocode);
	return shop;
}

/**
 * REST endpoint for a default request without the customer latitude and
 * longitude
 * 
 * @return returns all the registered shops
 */
@RequestMapping(path = "/shop", method = RequestMethod.GET)
public List<Deliveryman> getShops() {
	return store.getAll();
}

}

	 
