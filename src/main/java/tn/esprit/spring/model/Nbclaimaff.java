package tn.esprit.spring.model;



public class Nbclaimaff {
public Nbclaimaff(Long id_deli, int nbclaims) {
		super();
		this.id_deli = id_deli;
		this.nbclaims = nbclaims;
	}
public Nbclaimaff() {
		super();
		// TODO Auto-generated constructor stub
	}
Long id_deli;
int nbclaims ;
public Long getId_deli() {
	return id_deli;
}
public void setId_deli(Long id_deli) {
	this.id_deli = id_deli;
}
public int getNbclaims() {
	return nbclaims;
}
public void setNbclaims(int nbclaims) {
	this.nbclaims = nbclaims;
}
}
