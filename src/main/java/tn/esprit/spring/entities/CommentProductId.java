package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable 
public class CommentProductId implements Serializable {
	private int idClient;
	private int idProduct;
}
