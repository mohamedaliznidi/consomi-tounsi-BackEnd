package tn.esprit.spring.entities;

import java.beans.Transient;
import java.io.Serializable;
import java.util.Date;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Product;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;


@Entity
public class CommentProduct implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	

	public CommentProduct(float rate, String content, Client client, Product product,
			CommentProductId commentproductid) {
		super();
		this.rate = rate;
		this.content = content;
		this.client = client;
		this.product = product;
		this.commentproductid = commentproductid;
	}
	
	





	public CommentProduct(float rate, String content, Client client, Product product) {
		super();
		this.rate = rate;
		this.content = content;
		this.client = client;
		this.product = product;

	}




	private float rate;
	private String content;

	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	

	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(insertable = false, updatable = false, name ="idClient",referencedColumnName= "USER_ID")
	private Client client;
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	

	@JsonIgnore
	@ManyToOne
	@JoinColumn(insertable = false, updatable = false, name ="idProduct",referencedColumnName= "ID_PRODUCT")
	private Product product;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

	@JsonIgnore
	@EmbeddedId
	private CommentProductId commentproductid;
	public CommentProductId getCommentproductid() {
		return commentproductid;
	}
	public void setCommentproductid(CommentProductId commentproductid) {
		this.commentproductid = commentproductid;
	}
	
	
	
	public CommentProduct() {
		super();
		
	}
	
	
	
}
