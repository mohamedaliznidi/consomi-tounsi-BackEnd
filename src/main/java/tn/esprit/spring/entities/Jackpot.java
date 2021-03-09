package tn.esprit.spring.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Jackpot {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="JACKPOT_ID")
	private int id; 

	@Column(name="JACKPOT_TYPE")
	private Jackpot_Type name;
	
	@Column(name="JACKPOT_IMAGE")
	private String image;
	
}
