package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity

public class Publicity implements Serializable {
	
	
	public Publicity() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Publicity(int id, Date startDateP, Date endDateP, PublicityCategory publicitycategory, String image,
			Product product) {
		super();
		this.id = id;
		StartDateP = startDateP;
		EndDateP = endDateP;
		this.publicitycategory = publicitycategory;
		this.image = image;
		this.product = product;
		
	}


	/**
	 * @param id
	 * @param startDateP
	 * @param endDateP
	 * @param publicitycategory
	 * @param image
	 */
	public Publicity(int id, Date startDateP, Date endDateP, PublicityCategory publicitycategory, String image) {
		this.id = id;
		this.StartDateP = startDateP;
		this.EndDateP = endDateP;
		this.publicitycategory = publicitycategory;
		this.image = image;
	}

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="PUBLICITY_ID")
	private int id;
	private Date StartDateP;
	private Date EndDateP;
	@Enumerated(EnumType.ORDINAL)
	private PublicityCategory publicitycategory;
	private String image;
	private boolean current= false;

	
	public Publicity(int id, Date startDateP, Date endDateP, PublicityCategory publicitycategory, String image,
			boolean current, Product product) {
		super();
		this.id = id;
		StartDateP = startDateP;
		EndDateP = endDateP;
		this.publicitycategory = publicitycategory;
		this.image = image;
		this.current = current;
		this.product = product;
		
	}






	public boolean isCurrent() {
		return current;
	}



	public void setCurrent(boolean current) {
		this.current = current;
	}

	
	@ManyToOne
	private Product product;




	public Publicity(Date startDateP, Date endDateP, PublicityCategory publicitycategory, String image, boolean current,
			Product product) {
		super();
		StartDateP = startDateP;
		EndDateP = endDateP;
		this.publicitycategory = publicitycategory;
		this.image = image;
		this.current = current;
		this.product = product;
	}




	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}


	public Date getStartDateP() {
		return StartDateP;
	}



	public void setStartDateP(Date startDateP) {
		this.StartDateP = startDateP;
	}



	public Date getEndDateP() {
		return EndDateP;
	}



	public void setEndDateP(Date endDateP) {
		this.EndDateP = endDateP;
	}



	public PublicityCategory getPublicitycategory() {
		return publicitycategory;
	}



	public void setPublicitycategory(PublicityCategory publicitycategory) {
		this.publicitycategory = publicitycategory;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}
	
	
	
}

