package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;




@Entity

public class OrderC implements Serializable {
	
	
	/**
	 * @param id
	 * @param shippingAdress
	 * @param paymentMethode
	 * @param taxPrice
	 * @param totalPrice
	 * @param isPaid
	 * @param paidAt
	 * @param isDelivered
	 * @param deliveredAt
	 * @param products
	 * @param client
	 * @param adress
	 * @param deliveryMan
	 */
	public OrderC(int id, Adress shippingAdress, PaymentMethode paymentMethode, float taxPrice, float totalPrice,
			boolean isPaid, Date paidAt, boolean isDelivered, Date deliveredAt) {
		this.id = id;
		this.shippingAdress = shippingAdress;
		this.paymentMethode = paymentMethode;
		this.taxPrice = taxPrice;
		this.totalPrice = totalPrice;
		this.isPaid = isPaid;
		this.paidAt = paidAt;
		this.isDelivered = isDelivered;
		DeliveredAt = deliveredAt;

	}

	private static final long serialVersionUID = 1L;
	
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
	
	
	//@ManyToOne
	//DeliveryMan deliveryMan; 

	//Getters&Setters
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}


	public Adress getShippingAdress() {
		return shippingAdress;
	}



	public void setShippingAdress(Adress shippingAdress) {
		this.shippingAdress = shippingAdress;
	}



	public PaymentMethode getPaymentMethode() {
		return paymentMethode;
	}



	public void setPaymentMethode(PaymentMethode paymentMethode) {
		this.paymentMethode = paymentMethode;
	}


	public float getTaxPrice() {
		return taxPrice;
	}
	

	public void setTaxPrice(float taxPrice) {
		this.taxPrice = taxPrice;
	}

	

	public float getTotalPrice() {
		return totalPrice;
	}

	
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}


	public boolean isPaid() {
		return isPaid;
	}

	
	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	
	public Date getPaidAt() {
		return paidAt;
	}


	public void setPaidAt(Date paidAt) {
		this.paidAt = paidAt;
	}

	
	
	public boolean isDelivered() {
		return isDelivered;
	}


	public void setDelivered(boolean isDelivered) {
		this.isDelivered = isDelivered;
	}

	
	public Date getDeliveredAt() {
		return DeliveredAt;
	}


	public void setDeliveredAt(Date deliveredAt) {
		DeliveredAt = deliveredAt;
	}


}
