package tn.esprit.spring.entities;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity 
@Getter
@Setter
@RequiredArgsConstructor
@Table(name="claim")
public class Claim  {
	
	//properties
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	Long idclaim;
	@Column(name="Descreption")
	String descreption;
	@Column(name="Subject_claim")
	String subject_claim ;
	@Column(name="State")
	boolean State ; 
	
	
	// Relations
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="client_id",nullable=true )
	private Client client ; 
	

}
