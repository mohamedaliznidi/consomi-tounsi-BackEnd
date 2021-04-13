package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table(name="deliveryman")
public class Deliveryman implements Serializable {
	
	

	
	private static final long serialVersionUID = 1L;

	@Id
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	Long delivery_id;
	@Embedded
	private Shop shop1  ;
	
	public Deliveryman(Shop shop1) {
		super();
		this.shop1 = shop1;
	}


	public Deliveryman(Long delivery_id, Shop shop1) {
		super();
		this.delivery_id = delivery_id;
		this.shop1 = shop1;
	}


	public Shop getShop1() {
		return shop1;
	}


	public void setShop1(Shop shop1) {
		this.shop1 = shop1;
	}

	@Column(name="lastname")
	String lastname ;
	@Column(name="fristname")
	String FristName ;
	//@Column(name="adress")
	//String adress ;
	@Column(name="phonenumber")
	String phonenumber ;
	@Column(name="prime")
	 int prime ;
	@Column(name="claim_Client")
	 int claim_client =0 ;
	@Column (name="salary")
	int salary ; 
	@NotBlank
	@Size(max=30)
	@Email
	@Column( name="Email",unique=true , nullable =false )
	String email ;
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}





	/*@Column(name="work_HH")
	 int chargedetravail ;*/
	
	/*@Column(name="longitude")
	 double longitude ;
	@Column(name="latitude")
	 double latitude  ;*/
	
	
	
	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public Deliveryman(String lastname, String fristName, String phonenumber, int prime,
			int claim_client,  int rank, String joblist, User user) {
		super();
		this.lastname = lastname;
		FristName = fristName;
		//this.adress = adress;
		this.phonenumber = phonenumber;
		this.prime = prime;
		this.claim_client = claim_client;
		//this.longitude = longitude;
		//this.latitude = latitude;
		this.rank = rank;
		this.joblist = joblist;
		this.user = user;
	}


	public Deliveryman(Long delivery_id, String lastname, String fristName, String phonenumber,
			int prime, int claim_client, int rank, String joblist, User user) {
		super();
		this.delivery_id = delivery_id;
		this.lastname = lastname;
		FristName = fristName;
		//this.adress = adress;
		this.phonenumber = phonenumber;
		this.prime = prime;
		this.claim_client = claim_client;
		//this.longitude = longitude;
		//this.latitude = latitude;
		this.rank = rank;
		this.joblist = joblist;
		this.user = user;
	}

	/*public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}*/

	public int getClaim_client() {
		return claim_client;
	}

	public void setClaim_client(int claim_client) {
		this.claim_client = claim_client;
	}

	public Deliveryman(int salary, @NotBlank @Size(max = 30) @Email String email) {
		super();
		this.salary = salary;
		this.email = email;
	}


	public Deliveryman(Long i, int prime) {
		super();
		this.delivery_id = i;
		this.prime = prime;
	}

	@Column(name="rank")
	int rank  ;
	@Column(name="joblist")
	String joblist;
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY,optional = true)
	@JoinColumn(name="user_id",nullable=true )
	private User user  ;
    //@OneToMany(mappedBy= "deliveryman", cascade = CascadeType.ALL,fetch=FetchType.LAZY )
	//private Set<Claim> claim;

	public Long getDelivery_id() {
		return delivery_id;
	}

	


	public Deliveryman(Shop shop1, String lastname, String fristName, String phonenumber, int prime, int claim_client,
			int salary, @NotBlank @Size(max = 30) @Email String email, int rank, String joblist, User user) {
		super();
		this.shop1 = shop1;
		this.lastname = lastname;
		FristName = fristName;
		this.phonenumber = phonenumber;
		this.prime = prime;
		this.claim_client = claim_client;
		this.salary = salary;
		this.email = email;
		this.rank = rank;
		this.joblist = joblist;
		this.user = user;
	}


	public Deliveryman(Long delivery_id, Shop shop1, String lastname, String fristName, String phonenumber, int prime,
			int claim_client, int salary, @NotBlank @Size(max = 30) @Email String email, int rank, String joblist,
			User user) {
		super();
		this.delivery_id = delivery_id;
		this.shop1 = shop1;
		this.lastname = lastname;
		FristName = fristName;
		this.phonenumber = phonenumber;
		this.prime = prime;
		this.claim_client = claim_client;
		this.salary = salary;
		this.email = email;
		this.rank = rank;
		this.joblist = joblist;
		this.user = user;
	}


	public  void incrementSalary() {
		this.salary += 100;
	}

	public void setDelivery_id(Long delivery_id) {
		this.delivery_id = delivery_id;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getFristName() {
		return FristName;
	}


	public void setFristName(String fristName) {
		FristName = fristName;
	}


	public String getPhonenumber() {
		return phonenumber;
	}


	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}


	public int getPrime() {
		return prime;
	}


	public void setPrime(int prime) {
		this.prime = prime;
	}


	public int getRank() {
		return rank;
	}


	public void setRank(int rank) {
		this.rank = rank;
	}


	public String getJoblist() {
		return joblist;
	}


	public void setJoblist(String joblist) {
		this.joblist = joblist;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Deliveryman(Long delivery_id, Shop shop1, String lastname, String fristName, String phonenumber, int prime,
			int claim_client, int rank, String joblist, User user) {
		super();
		this.delivery_id = delivery_id;
		this.shop1 = shop1;
		this.lastname = lastname;
		FristName = fristName;
		this.phonenumber = phonenumber;
		this.prime = prime;
		this.claim_client = claim_client;
		this.rank = rank;
		this.joblist = joblist;
		this.user = user;
	}


	public Deliveryman() {
		super();
	}

	
}
