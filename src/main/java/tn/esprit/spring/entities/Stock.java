package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Stock implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id ;
	private int amount;
	@Temporal(TemporalType.DATE)
	public Date entry_date;
	@Temporal(TemporalType.DATE)
	public Date exit_date;
	@JsonIgnore
	@OneToMany( mappedBy="stock",cascade = CascadeType.ALL)
	private List<Product> product;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getEntry_date() {
		return entry_date;
	}

	public void setEntry_date(Date entry_date) {
		this.entry_date = entry_date;
	}

	public Date getExit_date() {
		return exit_date;
	}

	public void setExit_date(Date exit_date) {
		this.exit_date = exit_date;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}
	
	

	public int getId() {
		return id;
	}

	public Stock(int amount, Date entry_date, Date exit_date, List<Product> product) {
		super();
		this.amount = amount;
		this.entry_date = entry_date;
		this.exit_date = exit_date;
		this.product = product;
	}
	
	

	public Stock() {
		super();
	}

	@Override
	public String toString() {
		return "Stock [amount=" + amount + ", entry_date=" + entry_date + ", exit_date=" + exit_date + "]";
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}

