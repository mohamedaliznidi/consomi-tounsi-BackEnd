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
	 * @param deliveryman
	 */
	public OrderC(int id, Adress shippingAdress, PaymentMethode paymentMethode, float taxPrice, float totalPrice,
			boolean isPaid, Date paidAt, boolean isDelivered, Date deliveredAt, Set<Product> products, Client client,
			Adress adress, Deliveryman deliveryman) {
		this.id = id;
		this.shippingAdress = shippingAdress;
		this.paymentMethode = paymentMethode;
		this.taxPrice = taxPrice;
		this.totalPrice = totalPrice;
		this.isPaid = isPaid;
		this.paidAt = paidAt;
		this.isDelivered = isDelivered;
		DeliveredAt = deliveredAt;
		this.products = products;
		this.client = client;
		this.adress = adress;
		this.deliveryman = deliveryman;
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
	
	@ManyToOne
	Deliveryman deliveryman;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the shippingAdress
	 */
	public Adress getShippingAdress() {
		return shippingAdress;
	}

	/**
	 * @param shippingAdress the shippingAdress to set
	 */
	public void setShippingAdress(Adress shippingAdress) {
		this.shippingAdress = shippingAdress;
	}

	/**
	 * @return the paymentMethode
	 */
	public PaymentMethode getPaymentMethode() {
		return paymentMethode;
	}

	/**
	 * @param paymentMethode the paymentMethode to set
	 */
	public void setPaymentMethode(PaymentMethode paymentMethode) {
		this.paymentMethode = paymentMethode;
	}

	/**
	 * @return the taxPrice
	 */
	public float getTaxPrice() {
		return taxPrice;
	}

	/**
	 * @param taxPrice the taxPrice to set
	 */
	public void setTaxPrice(float taxPrice) {
		this.taxPrice = taxPrice;
	}

	/**
	 * @return the totalPrice
	 */
	public float getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * @return the isPaid
	 */
	public boolean isPaid() {
		return isPaid;
	}

	/**
	 * @param isPaid the isPaid to set
	 */
	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	/**
	 * @return the paidAt
	 */
	public Date getPaidAt() {
		return paidAt;
	}

	/**
	 * @param paidAt the paidAt to set
	 */
	public void setPaidAt(Date paidAt) {
		this.paidAt = paidAt;
	}

	/**
	 * @return the isDelivered
	 */
	public boolean isDelivered() {
		return isDelivered;
	}

	/**
	 * @param isDelivered the isDelivered to set
	 */
	public void setDelivered(boolean isDelivered) {
		this.isDelivered = isDelivered;
	}

	/**
	 * @return the deliveredAt
	 */
	public Date getDeliveredAt() {
		return DeliveredAt;
	}

	/**
	 * @param deliveredAt the deliveredAt to set
	 */
	public void setDeliveredAt(Date deliveredAt) {
		DeliveredAt = deliveredAt;
	}

	/**
	 * @return the products
	 */
	public Set<Product> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return the adress
	 */
	public Adress getAdress() {
		return adress;
	}

	/**
	 * @param adress the adress to set
	 */
	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	/**
	 * @return the deliveryman
	 */
	public Deliveryman getDeliveryman() {
		return deliveryman;
	}

	/**
	 * @param deliveryman the deliveryman to set
	 */
	public void setDeliveryman(Deliveryman deliveryman) {
		this.deliveryman = deliveryman;
	}

}
