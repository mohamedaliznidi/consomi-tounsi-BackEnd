package tn.esprit.spring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Table(name="commentforum")
public class Commentforum {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	Long idcommentforum;
	@Column(name="content")
	String content;
	@Column(name="commentdate")
	java.util.Date commentdate ;
	
	@ManyToOne 
	private Subject subject;
	
	public Long getIdcommentforum() {
		return idcommentforum;
	}
	public void setIdcommentforum(Long idcommentforum) {
		this.idcommentforum = idcommentforum;
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
