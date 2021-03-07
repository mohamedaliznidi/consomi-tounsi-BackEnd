package tn.esprit.spring;

import javax.persistence.Column; 
import javax.persistence.Entity;


@Entity
public class Client {
	

@Column(name="CLIENT_ADRESS")
private Adress Adress;


}
