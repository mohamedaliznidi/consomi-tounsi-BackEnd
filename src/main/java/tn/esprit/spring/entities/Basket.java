package tn.esprit.spring.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Basket {
	@Id
	@NonNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idBasket;
	@NonNull
	private boolean stateBasket;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Product> products;
	
	@OneToOne (mappedBy = "basket")
	private Client client;

}
