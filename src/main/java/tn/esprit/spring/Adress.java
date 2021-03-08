package tn.esprit.spring;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Adress {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int codeP;
	String gouvernorat;
	String road;
	int number;
	String delegation;
	String localite;
	
	@OneToMany (cascade = CascadeType.ALL, mappedBy="adress" )
	private Set<OrderC> orderc;
	
	
}
