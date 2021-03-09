package tn.esprit.spring.entities;

import java.lang.reflect.Array;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
	@Column(name="Id_Order")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Adress shippingAdress;
	@Enumerated(EnumType.STRING)
	private PaymentMethode paymentMethode;
	private float taxPrice;
	private float totalPrice;
	private boolean isPaid;
	private Date paidAt;
	private boolean isDelivered;
	private Date DeliveredAt;
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Product> products;


	@ManyToOne 
	 Client client;
	@ManyToOne
	Adress adress;
}
