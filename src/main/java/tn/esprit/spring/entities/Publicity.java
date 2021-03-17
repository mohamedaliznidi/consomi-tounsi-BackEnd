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

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Publicity implements Serializable {
	
	
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
	@NonNull
	private String image;
	
	
	
}

