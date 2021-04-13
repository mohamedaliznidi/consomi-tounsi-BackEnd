package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Basket implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
    private OrderC orderC;
	
	
	boolean stateBasket;
	
	public Basket() {
		// TODO Auto-generated constructor stub
	}

	public Basket(List<ItemBasket> items, OrderC orderC, boolean stateBasket) {
		super();
		this.orderC = orderC;
		this.stateBasket = stateBasket;
	}



	public Basket(OrderC orderC, boolean stateBasket) {
		super();
		this.orderC = orderC;
		this.stateBasket = stateBasket;
	}
	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public OrderC getOrderC() {
		return orderC;
	}

	public void setOrderC(OrderC orderC) {
		this.orderC = orderC;
	}

	public boolean isStateBasket() {
		return stateBasket;
	}

	public void setStateBasket(boolean stateBasket) {
		this.stateBasket = stateBasket;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	


	@Override
	public String toString() {
		return "Basket [id=" + id + ", orderC=" + orderC + ", stateBasket=" + stateBasket + "]";
	}

	

	
	
	

	
	
}
