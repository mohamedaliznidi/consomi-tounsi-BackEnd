package tn.esprit.spring.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Adress {
	@Id 
	@Column(name="CodeP")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private codeP codeP;
	private String road;
	private int number;

	
	@OneToMany (cascade = CascadeType.ALL, mappedBy="adress" )
	private Set<OrderC> orderc;
	@OneToMany (cascade = CascadeType.ALL, mappedBy="adress" )
	private Set<Client> client;
	
}
