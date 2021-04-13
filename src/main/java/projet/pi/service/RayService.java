package projet.pi.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import projet.pi.entity.Product;
import projet.pi.entity.Ray;
import projet.pi.exception.ProductNotFoundException;
import projet.pi.exception.RayNotFoundException;

public interface RayService {
	

		//Ray findBy(Long RayId) throws RayNotFoundException;
		//Ray findBy(String RayDescription) throws RayNotFoundException;
		//Ray findByName(String RayName) throws RayNotFoundException;
		List<String> findByCategory(String categories) throws RayNotFoundException;
		
		List<Ray> showAll() throws RayNotFoundException;
		Ray addRay(Ray ray);
		void DeleteById(@PathVariable("id") Long id) ;
		void updateRay(Ray ray) ;
		
		List<Product> findAllProductByrayon(Long id) throws ProductNotFoundException;
		
	}

