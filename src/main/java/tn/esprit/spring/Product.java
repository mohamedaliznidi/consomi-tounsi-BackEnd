package tn.esprit.spring.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String name;
	String code;
	float price;
	String image;
	int quantity;
	Date expDate;
	categoryP category;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="Product")
	private Set<ProductCategory> productCategory;
	
	
	

}
