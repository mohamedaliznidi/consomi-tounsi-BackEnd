package tn.esprit.spring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity 
@Getter
@Setter
@RequiredArgsConstructor
@Table(name="commentforum")
public class Commentforum {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NonNull
	int idcommentforum;
	@Column(name="content")
	@NonNull
	String content;
	@Column(name="commentdate")
	@NonNull
	java.util.Date commentdate ;
	
	@ManyToOne 
	private Subject subject;

}
