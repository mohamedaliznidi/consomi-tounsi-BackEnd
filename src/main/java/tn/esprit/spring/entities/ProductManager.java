package tn.esprit.spring.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity

@Table(name="PRODUCT_MANAGER") 
public class ProductManager extends User implements Serializable {
	
	
	public ProductManager(int id, String name, String email, String password, int phone_number) {
		super(id, name, email, password, phone_number);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
	
	
}