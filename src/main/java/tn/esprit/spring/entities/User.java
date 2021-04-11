package tn.esprit.spring.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;



@Entity
@Inheritance( strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="USER_TYPE")
public abstract class User implements Serializable {

	protected static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="USER_ID")
	protected int id; // Clé primaire

	@Column(name="USER_NAME",unique = true, nullable = false)
	@NotBlank
    @Size(max = 15)
	@JsonProperty("username")
	protected String username;

	@NotBlank
    @Size(max = 40)
    @Email
	@Column(name="USER_EMAIL",unique = true, nullable = false)
	@JsonProperty("email")
	protected String email;

	
	@NotBlank
    @Size(max = 100)
    @JsonIgnore
	@Column(name="USER_PW",unique = true, nullable = false)
	@JsonProperty("password")
	protected String password;

	@Column(name="USER_PHONE", nullable = false)
	@JsonProperty("number")
	protected int phone_number;

	@Column(name="ROLE")
	protected String Role;
	
	@Column(name="USER_FIRST_NAME",  nullable = false)
	@JsonProperty("firstname")
	protected String first_Name;

	@Column(name="USER_LAST_NAME", nullable = false)
	@JsonProperty("lastname")
	protected String last_Name;

	@Column(name="CREATED_AT")
	@CreatedDate
	@JsonProperty("createdAt")
    protected Instant createdAt = Instant.now();

	@Column(name="UPDATED_AT")
    @LastModifiedDate
    protected Instant updatedAt = Instant.now();

	@Column(name="ACTIVE")
	
    protected boolean active;

	
	
	//Getters&Setters
	
	
	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	
	public String getUsername() {
		return username;
	}

	
	public void setUsername(String user_Name) {
		this.username = user_Name;
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

	
	public String getRole() {
		return Role;
	}

	
	public void setRole(String role) {
		Role = role;
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

	
	public Instant getCreatedAt() {
		return createdAt;
	}

	
	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	
	public Instant getUpdatedAt() {
		return updatedAt;
	}

	
	public void setUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public boolean isActive() {
		return active;
	}

	public boolean getActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	//Constractors
	
	
	public User(User user) {
		this.id = user.id;
		this.username = user.username;
		this.email = user.email;
		this.password = user.password;
		this.phone_number = user.phone_number;
		this.Role = user.Role;
		this.first_Name = user.first_Name;
		this.last_Name = user.last_Name;
		this.createdAt = user.createdAt;
		this.updatedAt = user.updatedAt;
		this.active = user.active;
	}


	public User(int id, @NotBlank @Size(max = 15) String user_Name, @NotBlank @Size(max = 40) @Email String email,
			@NotBlank @Size(max = 100) String password, int phone_number, String Role, String first_Name,
			String last_Name, Instant createdAt, Instant updatedAt, boolean active) {
		this.id = id;
		this.username = user_Name;
		this.email = email;
		this.password = password;
		this.phone_number = phone_number;
		this.Role = Role;
		this.first_Name = first_Name;
		this.last_Name = last_Name;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.active = active;
	}


	public User(@NotBlank @Size(max = 15) String user_Name, @NotBlank @Size(max = 40) @Email String email,
			@NotBlank @Size(max = 100) String password) {
		this.username = user_Name;
		this.email = email;
		this.password = password;
		this.active = true;
	}


	public User() {};
}


