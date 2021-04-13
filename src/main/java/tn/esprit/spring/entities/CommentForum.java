package tn.esprit.spring.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity 

@Table(name="COMMENT_FORUM")
public class CommentForum implements Serializable {
	
	
	/**
	 * @param idcommentforum
	 * @param content
	 * @param commentdate
	 */
	public CommentForum(int id, String content, Instant commentdate) {
		this.id = id;
		this.content = content;
		this.commentdate = commentdate;
	}
	
	public CommentForum() {}

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	@Column(name="content")
	private String content;
	
	@Column(name="commentdate")
	private Instant commentdate = Instant.now() ;
	
	@ManyToOne 
	private Subject subject;
	
	@ManyToOne
	private Client client;
	
	//Getters&Setters

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}

	public Instant getCommentdate() {
		return commentdate;
	}

	public void setCommentdate(Instant commentdate) {
		this.commentdate = commentdate;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	

}
