package tn.esprit.spring.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Entity

@DiscriminatorValue("PLUS")
public class ClientPlus extends Client implements Serializable {
	
	

public ClientPlus(int id, String name, String email, String password, int phone_number,Adress adress) {
		super(id, name, email, password, phone_number,adress);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
	
	
	public ClientPlus(int id, String name, String email, String password, int phone_number, Adress adress,
			Sheet sheet) {
		super(id, name, email, password, phone_number, adress);
		this.sheet = sheet;
	}
	


	@ManyToMany(mappedBy="clientpluss", cascade = CascadeType.ALL)
	private Set<Donation> donations;

	public Sheet getSheet() {
		return sheet;
	}


	public void setSheet(Sheet sheet) {
		this.sheet = sheet;
	}

	@OneToOne (mappedBy = "clientplus")
	private Sheet sheet;

	public ClientPlus(int id, @NotBlank @Size(max = 15) String user_Name, @NotBlank @Size(max = 40) @Email String email,
			@NotBlank @Size(max = 100) String password, int phone_number, String Role, String first_Name,
			String last_Name, Instant createdAt, Instant updatedAt, boolean active) {
		super(id, user_Name, email, password, phone_number, Role, first_Name, last_Name, createdAt, updatedAt, active);
		
	}

	public ClientPlus(@NotBlank @Size(max = 15) String user_Name, @NotBlank @Size(max = 40) @Email String email,
			@NotBlank @Size(max = 100) String password) {
		super(user_Name, email, password);
		
	}

	public ClientPlus(User user) {
		super(user);
		
	}
	
	public ClientPlus() {}

	
	
}
