package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;





@Entity


@Inheritance( strategy=InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name="USER_TYPE")
public class User implements Serializable {
	
	
	/**
	 * @param id
	 * @param name
	 * @param email
	 * @param password
	 * @param phone_number
	 */
	public User(int id, String name, String email, String password, int phone_number) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone_number = phone_number;
	}

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
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

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the phone_number
	 */
	public int getPhone_number() {
		return phone_number;
	}

	/**
	 * @param phone_number the phone_number to set
	 */
	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
