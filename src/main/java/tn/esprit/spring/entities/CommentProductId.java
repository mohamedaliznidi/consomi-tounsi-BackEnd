package tn.esprit.spring.entities;

import javax.persistence.Embeddable;

@Embeddable 
public class CommentProductId {
	private int idClient;
	private int idProduct;
	private int idComment;

}
