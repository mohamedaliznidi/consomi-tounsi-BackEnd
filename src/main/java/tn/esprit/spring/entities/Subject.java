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
	public Subject(int id, String name_Subject, String desc_Subject, Client client, Set<Commentforum> commentforums) {
		this.id = id;
		Name_Subject = name_Subject;
		Desc_Subject = desc_Subject;
		this.client = client;
		this.commentforums = commentforums;
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
	 * @return the name_Subject
	 */
	public String getName_Subject() {
		return Name_Subject;
	}

	/**
	 * @param name_Subject the name_Subject to set
	 */
	public void setName_Subject(String name_Subject) {
		Name_Subject = name_Subject;
	}

	/**
	 * @return the desc_Subject
	 */
	public String getDesc_Subject() {
		return Desc_Subject;
	}

	/**
	 * @param desc_Subject the desc_Subject to set
	 */
	public void setDesc_Subject(String desc_Subject) {
		Desc_Subject = desc_Subject;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return the commentforums
	 */
	public Set<Commentforum> getCommentforums() {
		return commentforums;
	}

	/**
	 * @param commentforums the commentforums to set
	 */
	public void setCommentforums(Set<Commentforum> commentforums) {
		this.commentforums = commentforums;
	}
	

}
