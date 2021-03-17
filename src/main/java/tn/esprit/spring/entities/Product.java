package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor


public class Product implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@NonNull
	private String name;
	@NonNull
	private String code;
	@NonNull
	private float price;
	@NonNull
	private String image;
	@NonNull
	private int quantity;
	@NonNull
	private Date expDate;
	//private ProductCategory category;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="product")
	private Set<ProductCategory> productCategory;
	
	
	

}
