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
		themesubject = theme_Subject;
		namesubject = name_Subject;
		descsubject = desc_Subject;
	}

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="Id_Subject")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String namesubject;
	private String descsubject;
	private String themesubject;
	
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


	public String getNamesubject() {
		return namesubject;
	}


	public void setNamesubject(String name_Subject) {
		namesubject = name_Subject;
	}


	public String getDescsubject() {
		return descsubject;
	}


	public void setDescsubject(String desc_Subject) {
		descsubject = desc_Subject;
	}


	public String getThemesubject() {
		return themesubject;
	}


	public void setThemesubject(String theme_Subject) {
		themesubject = theme_Subject;
	}

	
}
