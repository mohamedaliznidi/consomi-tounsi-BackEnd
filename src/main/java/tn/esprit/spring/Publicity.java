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
	@Enumerated(EnumType.ORDINAL)
	private PublicityCategory publicitycategory;
	
	public enum PublicityCategory {
		Balise1 , Balise2, Balise3,Balise4 , Balise5, BaliseForum, BaliseHome1,BaliseHome2,BaliseHome3,
		BaliseJackpot, BaliseEvent,BaliseDonation,
		
	}
	
}

