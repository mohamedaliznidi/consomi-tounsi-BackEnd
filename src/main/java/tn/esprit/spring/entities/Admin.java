package tn.esprit.spring.entities;


import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;



@Entity
@Table(name="ADMIN")
public class Admin extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	public Admin(int id, @NotBlank @Size(max = 15) String user_Name, @NotBlank @Size(max = 40) @Email String email,
			@NotBlank @Size(max = 100) String password, int phone_number, String Role, String first_Name,
			String last_Name, Instant createdAt, Instant updatedAt, boolean active) {
		super(id, user_Name, email, password, phone_number, Role, first_Name, last_Name, createdAt, updatedAt, active);
		
	}

	public Admin(@NotBlank @Size(max = 15) String user_Name, @NotBlank @Size(max = 40) @Email String email,
			@NotBlank @Size(max = 100) String password) {
		super(user_Name, email, password);
	
	}

	public Admin(User user) {
		super(user);
		
	}
}