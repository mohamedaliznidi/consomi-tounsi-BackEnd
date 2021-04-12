package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
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
	





	public Sheet getSheet() {
		return sheet;
	}


	public void setSheet(Sheet sheet) {
		this.sheet = sheet;
	}

	@OneToOne (mappedBy = "clientplus")
	private Sheet sheet;
}
