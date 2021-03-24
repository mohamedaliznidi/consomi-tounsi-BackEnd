package tn.esprit.spring.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class CommentProduct implements Serializable {
	

	
	
	public CommentProduct(Client client, Product product, String content, Date date,int rate) {
		super();
		this.client = client;
		this.product = product;
		this.content = content;
		this.date = date;
		this.rate=rate;
		
	}
	
	private int rate;
	private Client client;
	private Product product;
	private String content;
	private Date date;
	
	//private CommentProductId commentproductid;
	@EmbeddedId 
	private CommentProductId commentproductid;
	public CommentProductId getCommentProductId(){
		return commentproductid;
	}
	public void setCommentProductId(CommentProductId commentproductid){
		this.commentproductid=commentproductid;
	}
	
	@ManyToOne
	@JoinColumn(name="idClient",referencedColumnName="USER_ID"
	, insertable=false, updatable=false)
	
	
	public Client getClient(){
		return client;
		
	}
	public void setClient(Client client){
		
		this.client=client;
	}
	
	@ManyToOne
	@JoinColumn(name="idProduct",referencedColumnName="ID_PRODUCT"
	, insertable=false, updatable=false)
	
	public Product getProduct(){
		return product;
		
	}
	public void setProduct(Product product){
		
		this.product=product;
	}
	
	public String getContent(){
		return content;
		
	}
	public void setContent(String content){
		
		this.content=content;
	}
	
	
	public Date getDate(){
		return date;
		
	}
	public void setDate(Date date){
		
		this.date=date;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	
	
	
	

}
