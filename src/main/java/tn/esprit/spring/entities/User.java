package tn.esprit.spring.entities;

import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class User {

@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column(name="USER_ID")
private int id; // Clé primaire

@Column(name="USER_NAME")
private String name;

@Column(name="USER_EMAIL")
private String email;

@Column(name="USER_PW")
private String password;

@Column(name="USER_PHONE")
private int phone_number;

}
