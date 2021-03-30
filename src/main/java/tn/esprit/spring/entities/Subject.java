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
	
	
	public Subject(int id, String name_Subject, String desc_Subject, String theme_Subject) {
		this.id = id;
		Theme_Subject = theme_Subject;
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
	private String Theme_Subject;
	
	@ManyToOne 
	private Client client; 
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="subject")
	private Set<CommentForum> commentForums;

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


	public String getTheme_Subject() {
		return Theme_Subject;
	}


	public void setTheme_Subject(String theme_Subject) {
		Theme_Subject = theme_Subject;
	}

	
}
