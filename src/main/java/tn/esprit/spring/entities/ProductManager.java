package tn.esprit.spring.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@DiscriminatorValue("PRODUCT_MANAGER")
@Table(name="product_manager") 
public class ProductManager {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	Long product_id;
	@Column(name="content")
	String content ; 
	@Column(name="rate")
	int rate ; 
	@Column(name="commentdate")
	Date  commentdate ;
    
	public String getContent() {
		return content;
	}

	public ProductManager(Long product_id, String content, int rate, Date commentdate) {
		super();
		this.product_id = product_id;
		this.content = content;
		this.rate = rate;
		this.commentdate = commentdate;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public Date getCommentdate() {
		return commentdate;
	}

	public void setCommentdate(Date commentdate) {
		this.commentdate = commentdate;
	}

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public ProductManager(Long product_id) {
		super();
		this.product_id = product_id;
	}

	public ProductManager() {
		super();
	}
	

	
	
}