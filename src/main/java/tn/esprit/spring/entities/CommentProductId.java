package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Embeddable
public class CommentProductId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Column(name="idClient")
	private int idClient;
	@Column(name="idProduct")
	private int idProduct;
	private Date date;
	
	

	
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idClient;
		result = prime * result + idProduct;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommentProductId other = (CommentProductId) obj;
		if (idClient != other.idClient)
			return false;
		if (idProduct != other.idProduct)
			return false;
		return true;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public CommentProductId(int idClient, int idProduct, Date date) {
		super();
		this.idClient = idClient;
		this.idProduct = idProduct;
		this.date = date;
	}
	public CommentProductId() {
		super();
	}
}
	
	
	
	
