package tn.esprit.spring.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity

@Table(name="PRODUCT_MANAGER") 
public class ProductManager extends User  {
	

	
	
}