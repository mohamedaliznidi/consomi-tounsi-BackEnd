package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity 

@Table(name="commentforum")
public class Commentforum implements Serializable {
	
	
	/**
	 * @param idcommentforum
	 * @param content
	 * @param commentdate
	 */
	public Commentforum(int idcommentforum, String content, Date commentdate) {
		this.idcommentforum = idcommentforum;
		this.content = content;
		this.commentdate = commentdate;
	}

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	int idcommentforum;
	@Column(name="content")

	String content;
	@Column(name="commentdate")

	java.util.Date commentdate ;
	
	@ManyToOne 
	private Subject subject;

	/**
	 * @return the idcommentforum
	 */
	public int getIdcommentforum() {
		return idcommentforum;
	}

	/**
	 * @param idcommentforum the idcommentforum to set
	 */
	public void setIdcommentforum(int idcommentforum) {
		this.idcommentforum = idcommentforum;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the commentdate
	 */
	public java.util.Date getCommentdate() {
		return commentdate;
	}

	/**
	 * @param commentdate the commentdate to set
	 */
	public void setCommentdate(java.util.Date commentdate) {
		this.commentdate = commentdate;
	}

}
