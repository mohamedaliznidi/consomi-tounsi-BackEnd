package tn.esprit.spring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class codeP {
	@Id
	@Column(name="CodeP")
	private int codeP;
	private String gouvernorat;
	private String delegation;
	private String localite;

}
