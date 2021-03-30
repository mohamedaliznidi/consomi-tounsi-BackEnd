package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.*;



@Entity
@Inheritance( strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="USER_TYPE")
public abstract class User implements Serializable {



	
	public User(int id, String first_Name, String last_Name, String user_Name, String email, String password,
			int phone_number, String user_Role) {
		this.id = id;
		this.first_Name = first_Name;
		this.last_Name = last_Name;
		this.user_Name = user_Name;
		this.email = email;
		this.password = password;
		this.phone_number = phone_number;
		this.User_Role = user_Role;
	}

	protected static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="USER_ID")

	protected int id; // Clé primaire

	@Column(name="USER_FIRST_NAME",  nullable = false)

	protected String first_Name;

	@Column(name="USER_LAST_NAME", nullable = false)

	protected String last_Name;

	@Column(name="USER_NAME",unique = true, nullable = false)

	protected String user_Name;

	@Column(name="USER_EMAIL",unique = true, nullable = false)

	protected String email;

	@Column(name="USER_PW",unique = true, nullable = false)

	protected String password;

	@Column(name="USER_PHONE", nullable = false)

	protected int phone_number;

	@Column(name="USER_ROLE")
	protected String User_Role;

	//Getters&Setters



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	
	public String getFirst_Name() {
		return first_Name;
	}

	
	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}


	public String getLast_Name() {
		return last_Name;
	}

	
	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}

	
	public String getUser_Name() {
		return user_Name;
	}

	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getPassword() {
		return password;
	}

	
	public void setPassword(String password) {
		this.password = password;
	}

	
	public int getPhone_number() {
		return phone_number;
	}

	
	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}

	public String getUser_Role() {
		return User_Role;
	}

	public void setUser_Role(String user_Role) {
		User_Role = user_Role;
	}



}
