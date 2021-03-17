package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	 * @return the startDateP
	 */
	public Date getStartDateP() {
		return StartDateP;
	}

	/**
	 * @param startDateP the startDateP to set
	 */
	public void setStartDateP(Date startDateP) {
		StartDateP = startDateP;
	}

	/**
	 * @return the endDateP
	 */
	public Date getEndDateP() {
		return EndDateP;
	}

	/**
	 * @param endDateP the endDateP to set
	 */
	public void setEndDateP(Date endDateP) {
		EndDateP = endDateP;
	}

	/**
	 * @return the publicitycategory
	 */
	public PublicityCategory getPublicitycategory() {
		return publicitycategory;
	}

	/**
	 * @param publicitycategory the publicitycategory to set
	 */
	public void setPublicitycategory(PublicityCategory publicitycategory) {
		this.publicitycategory = publicitycategory;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
	
	
	
}

