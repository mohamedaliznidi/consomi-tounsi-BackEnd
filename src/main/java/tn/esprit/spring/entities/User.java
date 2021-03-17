package tn.esprit.spring.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;





@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Inheritance( strategy=InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name="USER_TYPE")
public class User {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="USER_ID")
	@NonNull
	private int id; // Clé primaire

	@Column(name="USER_NAME")
	@NonNull
	private String name;

	@Column(name="USER_EMAIL")
	@NonNull
	private String email;

	@Column(name="USER_PW")
	@NonNull
	private String password;

	@Column(name="USER_PHONE")
	@NonNull
	private int phone_number;
	
}
