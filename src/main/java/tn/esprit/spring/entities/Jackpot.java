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
	public Jackpot(int id, int name, String image) {
		this.id = id;
		this.name = name;
		this.image = image;
	}

	public Jackpot() {
		super();
	}

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="JACKPOT_ID")
	private int id; 

	@Column(name="JACKPOT_TYPE")
	private int  name;
	
	@Column(name="JACKPOT_IMAGE")
	private String image;
	

	//Getters&Setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public  int getName() {
		return name;
	}

	
	public void setName(int name) {
		this.name = name;
	}

	
	public String getImage() {
		return image;
	}

	
	public void setImage(String image) {
		this.image = image;
	}
	
}
