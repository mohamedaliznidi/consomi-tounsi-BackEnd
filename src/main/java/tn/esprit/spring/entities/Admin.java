package tn.esprit.spring.entities;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;



@Entity
@Table(name="ADMIN")
public class Admin extends User implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
}