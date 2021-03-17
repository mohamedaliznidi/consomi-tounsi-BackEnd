package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity

public class Jackpot implements Serializable {
	
	
	/**
	 * @param id
	 * @param name
	 * @param image
	 */
	public Jackpot(int id, Jackpot_Type name, String image) {
		this.id = id;
		this.name = name;
		this.image = image;
	}

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="JACKPOT_ID")
	private int id; 

	@Column(name="JACKPOT_TYPE")
	private Jackpot_Type name;
	
	@Column(name="JACKPOT_IMAGE")
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
	 * @return the name
	 */
	public Jackpot_Type getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(Jackpot_Type name) {
		this.name = name;
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
