package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Subject implements Serializable {
	
	
	/**
	 * @param id
	 * @param name_Subject
	 * @param desc_Subject
	 * @param client
	 * @param commentforums
	 */
	public Subject(int id, String name_Subject, String desc_Subject) {
		this.id = id;
		Name_Subject = name_Subject;
		Desc_Subject = desc_Subject;
	}

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="Id_Subject")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String Name_Subject;
	private String Desc_Subject;
	
	@ManyToOne 
	private Client client; 
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="subject")
	private Set<Commentforum> commentforums;

	//Getters&Setters 
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName_Subject() {
		return Name_Subject;
	}


	public void setName_Subject(String name_Subject) {
		Name_Subject = name_Subject;
	}


	public String getDesc_Subject() {
		return Desc_Subject;
	}


	public void setDesc_Subject(String desc_Subject) {
		Desc_Subject = desc_Subject;
	}

	
}
