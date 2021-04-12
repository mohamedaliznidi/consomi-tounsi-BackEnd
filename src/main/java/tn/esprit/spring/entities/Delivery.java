package tn.esprit.spring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name= "Delivery")
public class Delivery {
	
@Id
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)

Long id_deliv ; 
@Column
	float weight; 
@Column
float Lenght ; 
@Column 
float Width; 
@Column 
float longitude ; 
@Column
float laltitude ;
public Long getId_deliv() {
	return id_deliv;
}
public void setId_deliv(Long id_deliv) {
	this.id_deliv = id_deliv;
}
public float getWeight() {
	return weight;
}
public void setWeight(float weight) {
	this.weight = weight;
}
public float getLenght() {
	return Lenght;
}
public void setLenght(float lenght) {
	Lenght = lenght;
}
public float getWidth() {
	return Width;
}
public void setWidth(float width) {
	Width = width;
}
public float getLongitude() {
	return longitude;
}
public void setLongitude(float longitude) {
	this.longitude = longitude;
}
public float getLaltitude() {
	return laltitude;
}
public void setLaltitude(float laltitude) {
	this.laltitude = laltitude;
}
public Delivery(Long id_deliv, float weight, float lenght, float width, float longitude, float laltitude) {
	super();
	this.id_deliv = id_deliv;
	this.weight = weight;
	Lenght = lenght;
	Width = width;
	this.longitude = longitude;
	this.laltitude = laltitude;
}
public Delivery() {
	super();
}  

}
