package tn.esprit.spring.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends User {
	
}