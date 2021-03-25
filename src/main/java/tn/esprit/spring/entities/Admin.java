package tn.esprit.spring.entities;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;



@Entity
@Table(name="ADMIN")
public class Admin extends User implements Serializable {
	
	
	public Admin(int id, String name, String email, String password, int phone_number) {
		super(phone_number, password, password, password, phone_number);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
}