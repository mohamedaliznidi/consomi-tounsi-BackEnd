package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@OneToOne
	private Adress shippingAdress;
	//private String shippingAdress ;
	@Enumerated(EnumType.STRING)
	private PaymentMethode paymentMethode;
	private float taxPrice;
	private float totalPrice;
	private boolean isPaid;
	private Date paidAt;
	private boolean isDelivered;
	private Date DeliveredAt;
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "orderC")
    private Basket basket;

	
	@ManyToOne 
	@JsonIgnore
	private Client client;

	public OrderC() {
		// TODO Auto-generated constructor stub
		
	}
	

	//@ManyToOne
	//DeliveryMan deliveryMan; 


	public OrderC(Adress shippingAdress, PaymentMethode paymentMethode, float taxPrice, float totalPrice,
			boolean isPaid, Date paidAt, boolean isDelivered, Date deliveredAt, Basket basket, Client client) {
		super();
		this.shippingAdress = shippingAdress;
		this.paymentMethode = paymentMethode;
		this.taxPrice = taxPrice;
		this.totalPrice = totalPrice;
		this.isPaid = isPaid;
		this.paidAt = paidAt;
		this.isDelivered = isDelivered;
		DeliveredAt = deliveredAt;
		this.basket = basket;
		this.client = client;
	}


	public OrderC(int id, Adress shippingAdress, PaymentMethode paymentMethode, float taxPrice, float totalPrice,
			boolean isPaid, Date paidAt, boolean isDelivered, Date deliveredAt, Basket basket, Client client) {
		super();
		this.id = id;
		this.shippingAdress = shippingAdress;
		this.paymentMethode = paymentMethode;
		this.taxPrice = taxPrice;
		this.totalPrice = totalPrice;
		this.isPaid = isPaid;
		this.paidAt = paidAt;
		this.isDelivered = isDelivered;
		DeliveredAt = deliveredAt;
		this.basket = basket;
		this.client = client;
	}


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


	public Basket getBasket() {
		return basket;
	}


	public void setBasket(Basket basket) {
		this.basket = basket;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "OrderC [id=" + id + ", shippingAdress=" + shippingAdress + ", paymentMethode=" + paymentMethode
				+ ", taxPrice=" + taxPrice + ", totalPrice=" + totalPrice + ", isPaid=" + isPaid + ", paidAt=" + paidAt
				+ ", isDelivered=" + isDelivered + ", DeliveredAt=" + DeliveredAt + ", basket=" + basket + ", client="
				+ client + "]";
	}

	
}
