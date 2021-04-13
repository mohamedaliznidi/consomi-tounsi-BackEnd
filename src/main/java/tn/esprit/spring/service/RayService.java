package tn.esprit.spring.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import tn.esprit.spring.entities.Product1;
import tn.esprit.spring.entities.Ray;
import tn.esprit.spring.exception.ProductNotFoundException;
import tn.esprit.spring.exception.RayNotFoundException;

public interface RayService {
	

		/*Ray findBy(Long RayId) throws RayNotFoundException;
		Ray findBy(String RayDescription) throws RayNotFoundException;*/
		//Ray findByName(String RayName) throws RayNotFoundException;
		List<Ray> findByCategory(String categories) throws RayNotFoundException;
		
		List<Ray> showAll() throws RayNotFoundException;
		Ray addRay(Ray ray);
		void DeleteById(@PathVariable("id") Long id) ;
		void updateRay(Ray ray) ;
		
		List<Product1> findAllProductByrayon(Long id) throws ProductNotFoundException;
		
	}

