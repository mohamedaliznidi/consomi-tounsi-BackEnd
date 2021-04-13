package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import tn.esprit.spring.entities.Product1;
import tn.esprit.spring.entities.Ray;
import tn.esprit.spring.exception.ProductNotFoundException;
import tn.esprit.spring.exception.RayNotFoundException;
import tn.esprit.spring.repositry.RayRepository;
import tn.esprit.spring.repositry.productRepository1;
import tn.esprit.spring.repositry.productRepository1;;

@Service
public class RayServiceImpl implements RayService  {
	
		@Autowired
		RayRepository rayRepository;
		@Autowired
		productRepository1 product_rep;
		

		@Override
		public List<Ray> findByCategory(String categories) throws RayNotFoundException {
			List<Ray> rayons = rayRepository.findByCategory(categories);
			if (rayons.isEmpty() || rayons == null)
				throw new RayNotFoundException();
			else
				return rayons;
		}

		@Override
		public List<Ray> showAll() throws RayNotFoundException {
			List<Ray> sections = rayRepository.findAll();
			if (sections.isEmpty() || sections == null)
				throw new RayNotFoundException();
			else
				return sections;
		}

		@Override
		public Ray addRay(Ray ray) {
			
			Ray r = rayRepository.save(ray) ;
			return r ;
		}

		

		@Override

		public void DeleteById(@PathVariable("id") Long id) {
			
			rayRepository.deleteById(id);
		}

		public void DeleteAll() {
			rayRepository.deleteAll();		
		}
		
		@Override
		public List<Product1> findAllProductByrayon(Long id) throws ProductNotFoundException 
		{
			List<Product1> products = product_rep.findAllProductByrayon(id);
			if (products.isEmpty() || products == null)
				throw new ProductNotFoundException();
			else
				return products;
		}
		
	//bestproduct
		public List<Product1> updateRayon(){
			List<Integer> ray_id = product_rep.findRayon_id();
			List<Product1> best_products = new ArrayList<Product1>();
			for (int i = 0 ; i < ray_id.size(); i++) {
				rayRepository.findById((long)ray_id.get(i)).map(r ->{
					//r.setBestProduct(product_rep.findBestProduct(product_rep.findBestProductByrayId(r.getRayId())));
					rayRepository.save(r);
					best_products.add(product_rep.findBestProduct(product_rep.findBestProductByrayId(r.getRayId())));
					return r;
				});
				
			}
			
			return best_products;
		}
		
	//update capacity	
	@Scheduled(fixedDelay= 1000*60)
		public void UpdateCapacity(){
			List<Ray> ray = rayRepository.findAll();
			for (int i = 0; i < ray.size(); i++) {
				ray.get(i).setCapacity(rayRepository.UpdateSumCapacityRayon(ray.get(i)));
				rayRepository.save(ray.get(i));
				
			}
		}

	@Override
	public void updateRay(Ray ray) {
		// TODO Auto-generated method stub
		
	}

	
	
	

	
	

	  

	  

	
}