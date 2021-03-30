package tn.esprit.spring.entities;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;



@Entity
@Table(name="ADMIN")
public class Admin extends User implements Serializable {

	
	public Admin(int id, String first_Name, String last_Name, String user_Name, String email, String password,
			int phone_number) {
		super(id, first_Name, last_Name, user_Name, email, password, phone_number, "ADMIN");
		
	}

	
	

	private static final long serialVersionUID = 1L;
}