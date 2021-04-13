package projet.pi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.bytebuddy.build.HashCodeAndEqualsPlugin.Sorted;
import projet.pi.entity.Category;
import projet.pi.entity.Product;
import projet.pi.repository.productRepository;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


//algorithme qui va calculer les meilleurs produits chaque mois et les mettre dans le 1er rangé du rayon

@Service
public class BestOf {
	
	@Autowired
	productRepository product;
	
//bestproduct	
	public List<Product> SortBySold() {
		List<Product> sorted=product.findAll();
	     sorted.sort(new Comparator<Product>() {
	    	@Override
	    	public int compare(Product P1,Product P2){
	    		return P2.getSold()-P1.getSold();
	    	}
		});
	     return sorted;
	}
	
	
	
	
	
	}