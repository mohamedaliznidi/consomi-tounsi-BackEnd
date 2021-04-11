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

@Table(name="COMMENT_FORUM")
public class CommentForum implements Serializable {
	
	
	/**
	 * @param idcommentforum
	 * @param content
	 * @param commentdate
	 */
	public CommentForum(int id, String content, Date commentdate) {
		this.id = id;
		this.content = content;
		this.commentdate = commentdate;
	}

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	@Column(name="content")
	String content;
	
	@Column(name="commentdate")
	java.util.Date commentdate ;
	
	@ManyToOne 
	private Subject subject;
	
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

	public java.util.Date getCommentdate() {
		return commentdate;
	}

	public void setCommentdate(java.util.Date commentdate) {
		this.commentdate = commentdate;
	}

}
