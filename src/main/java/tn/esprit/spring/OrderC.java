package tn.esprit.spring.entity;

import java.lang.reflect.Array;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class OrderC {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String shippingAdress;
	@Enumerated(EnumType.STRING)
	PaymentMethode paymentMethode;
	float taxPrice;
	float totalPrice;
	boolean isPaid;
	Date paidAt;
	boolean isDelivered;
	Date DeliveredAt;
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Product> productss;


	@ManyToOne 
	 Client client;
	@ManyToOne
	Adress adress;
}
