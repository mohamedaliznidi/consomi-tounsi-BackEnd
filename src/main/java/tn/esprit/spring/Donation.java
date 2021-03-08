package tn.esprit.spring;


import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Donation {

@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column(name="DONATION_ID")
private int id ; 

@Column(name="DONATION_TYPE")
@Enumerated(EnumType.STRING)
private Donation_Type type;

@Column(name="DONATION_STATE")
private boolean state;


}





