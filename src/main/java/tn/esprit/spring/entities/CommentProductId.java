package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

//@Embeddable 
public class CommentProductId implements Serializable {
	private int idClient;
	private int idProduct;
	
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
	

}
