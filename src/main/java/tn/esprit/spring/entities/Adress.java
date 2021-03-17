package tn.esprit.spring.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Adress {
	@Id 
	@Column(name="CodeP")
	@NonNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NonNull
	private codeP codeP;
	@NonNull
	private String road;
	@NonNull
	private int number;

	
	@OneToMany (cascade = CascadeType.ALL, mappedBy="adress" )
	private Set<OrderC> orderc;
	@OneToMany (cascade = CascadeType.ALL, mappedBy="adress" )
	private Set<Client> client;
	
}
