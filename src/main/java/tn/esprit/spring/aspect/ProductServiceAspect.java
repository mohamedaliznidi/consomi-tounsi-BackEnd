package tn.esprit.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;



import tn.esprit.spring.entities.Product;

//changer system.out avec le logger 

public class ProductServiceAspect {
	
	
	@Before(value = "execution(* tn.esprit.spring.service.IProductSercice.*(..)) and args( p1 , imageprod,  category_id ,  publicity_id)")
	public void beforeAdvice(JoinPoint joinPoint, Product p1 , byte[] imageprod, Long category_id , Long publicity_id) {
		System.out.println("Before method:" + joinPoint.getSignature());

		System.out.println("Creating Product with name - " + p1.getName() + " and id - " + p1.getId());
	}

	@After(value = "execution(* tn.esprit.spring.service.IProductSercice.*(..)) and args( p1 , imageprod,  category_id ,  publicity_id)")
	public void afterAdvice(JoinPoint joinPoint, Product p1 , byte[] imageprod, Long category_id , Long publicity_id) {
		System.out.println("After method:" + joinPoint.getSignature());

		System.out.println("Successfully created Product with name - " + p1.getName() + " and id - " + p1.getId());
	}
	
}
	