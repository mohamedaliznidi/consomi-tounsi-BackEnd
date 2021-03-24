package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity

public class Publicity implements Serializable {
	
	
	/**
	 * @param id
	 * @param startDateP
	 * @param endDateP
	 * @param publicitycategory
	 * @param image
	 */
	public Publicity(int id, Date startDateP, Date endDateP, PublicityCategory publicitycategory, String image) {
		this.id = id;
		StartDateP = startDateP;
		EndDateP = endDateP;
		this.publicitycategory = publicitycategory;
		this.image = image;
	}

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="PUBLICITY_ID")
	private int id;
	@Temporal (TemporalType.DATE)
	private Date StartDateP;
	@Temporal (TemporalType.DATE)
	private Date EndDateP;
	@Enumerated(EnumType.ORDINAL)
	private PublicityCategory publicitycategory;
	private String image;
	
	@ManyToOne(cascade = CascadeType.ALL)
	Product products;

	
	
	
	//Getters&Setters


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
		StartDateP = startDateP;
	}



	public Date getEndDateP() {
		return EndDateP;
	}



	public void setEndDateP(Date endDateP) {
		EndDateP = endDateP;
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

