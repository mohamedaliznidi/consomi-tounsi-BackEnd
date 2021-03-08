package tn.esprit.spring;
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
public class Publicity {
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
	
	
	
}

