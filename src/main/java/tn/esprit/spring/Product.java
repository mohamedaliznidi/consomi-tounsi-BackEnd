package tn.esprit.spring;

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
	private int id;
	private String name;
	private String code;
	private float price;
	private String image;
	private int quantity;
	private Date expDate;
	private ProductCategory category;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="Product")
	private Set<ProductCategory> productCategory;
	
	
	

}
