package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name="DELIVERY_MAN")
public class Deliveryman  extends User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	Long delivery_id;
	
	@Column(name="lastname")
	String lastname ;
	@Column(name="fristname")
	String FristName ;
	@Column(name="adress")
	String adress ;
	@Column(name="phonenumber")
	String phonenumber ;
	@Column(name="prime")
	int prime ;
	@Column(name="rank")
	int rank  ;
	@Column(name="joblist")
	String joblist;
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="user_id",nullable=true )
	private User user  ;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="deliveryman")
	private Set<OrderC> orders;

	
}
