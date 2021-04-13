package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.bytebuddy.build.HashCodeAndEqualsPlugin.Sorted;
import tn.esprit.spring.entities.Category;
import tn.esprit.spring.entities.Product;
import tn.esprit.spring.entities.Product1;
import tn.esprit.spring.repositry.productRepository1;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


//algorithme qui va calculer les meilleurs produits chaque mois et les mettre dans le 1er rangé du rayon

@Service
public class BestOf {
	
	@Autowired
	productRepository1 product1;
	
//bestproduct	
	
	
	
	
	
	
	}