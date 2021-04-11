package tn.esprit.spring.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;


@Entity
public class ProductManager extends User implements Serializable {
		
	
	private static final long serialVersionUID = 1L;

	public ProductManager(int id, @NotBlank @Size(max = 15) String user_Name,
			@NotBlank @Size(max = 40) @Email String email, @NotBlank @Size(max = 100) String password, int phone_number,
			String Role, String first_Name, String last_Name, Instant createdAt, Instant updatedAt, boolean active) {
		super(id, user_Name, email, password, phone_number, Role, first_Name, last_Name, createdAt, updatedAt, active);

	}

	@JsonCreator
	public ProductManager(@NotBlank @Size(max = 15) String user_Name, @NotBlank @Size(max = 40) @Email String email,
			@NotBlank @Size(max = 100) String password) {
		super(user_Name, email, password);
	
	}

	public ProductManager(User user) {
		super(user);
		
	}
	
	public ProductManager() {
		super();
	}


	
	
	
	
}