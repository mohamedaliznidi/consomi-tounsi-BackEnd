package esprit.proj.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import esprit.proj.entity.Product;
import esprit.proj.entity.Ray;
import esprit.proj.exception.ProductNotFoundException;
import esprit.proj.exception.RayNotFoundException;
import esprit.proj.repository.RayRepository;
import esprit.proj.repository.productRepository;

@Service
public class RayServiceImpl implements RayService  {
	
		@Autowired
		RayRepository rayRepository;
		@Autowired
		productRepository product_rep;
		
		/*@Override
		public Ray findBy(Long RayId) throws RayNotFoundException {
			Ray ray = rayRepository.findBy(RayId);
			if (ray != null)
				return ray;
			else
				throw new RayNotFoundException();
		}

		@Override
		public Ray findByName(String RayName) throws RayNotFoundException {
			Ray ray=rayRepository.findBy(RayName);
			if(ray != null) 
				return ray ;
			else
				throw new RayNotFoundException();
		}*/

		
		/*@Override
		public Ray findBy(String RayDescription) throws RayNotFoundException {
			Ray ray = rayRepository.findBy(RayDescription);
			if (ray != null)
				return ray;
			else
				throw new RayNotFoundException();
		}*/

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
		public void updateRay(Ray ray) {
			rayRepository.save(ray);
			
		}

		@Override

		public void DeleteById(@PathVariable("id") Long id) {
			
			rayRepository.deleteById(id);
		}

		public void DeleteAll() {
			rayRepository.deleteAll();		
		}
		
		@Override
		public List<Product> findAllProductByrayon(Long id) throws ProductNotFoundException 
		{
			List<Product> products = product_rep.findAllProductByrayon(id);
			if (products.isEmpty() || products == null)
				throw new ProductNotFoundException();
			else
				return products;
		}
		public List<Product> updateRayon(){
			List<Integer> ray_id = product_rep.findRayon_id();
			List<Product> best_products = new ArrayList<Product>();
			for (int i = 0 ; i < ray_id.size(); i++) {
				rayRepository.findById((long)ray_id.get(i)).map(r ->{
					r.setBestProduct(product_rep.findBestProduct(product_rep.findBestProductByrayId(r.getRayId())));
					rayRepository.save(r);
					best_products.add(product_rep.findBestProduct(product_rep.findBestProductByrayId(r.getRayId())));
					return r;
				});
				
			}
			
			return best_products;
		}
	
}