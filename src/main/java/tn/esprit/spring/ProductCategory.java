package tn.esprit.spring.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ProductCategory {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	String categoryName;
	@ManyToOne
	Product products;
}
