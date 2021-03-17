package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;




@Entity



public class Product implements Serializable {
	
	
	/**
	 * @param id
	 * @param name
	 * @param code
	 * @param price
	 * @param image
	 * @param quantity
	 * @param expDate
	 * @param productCategory
	 */
	public Product(int id, String name, String code, float price, String image, int quantity, Date expDate,
			Set<ProductCategory> productCategory) {
		this.id = id;
		this.name = name;
		this.code = code;
		this.price = price;
		this.image = image;
		this.quantity = quantity;
		this.expDate = expDate;
		this.productCategory = productCategory;
	}

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String name;
	
	private String code;

	private float price;

	private String image;
	
	private int quantity;

	private Date expDate;
	//private ProductCategory category;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="product")
	private Set<ProductCategory> productCategory;

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the expDate
	 */
	public Date getExpDate() {
		return expDate;
	}

	/**
	 * @param expDate the expDate to set
	 */
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	/**
	 * @return the productCategory
	 */
	public Set<ProductCategory> getProductCategory() {
		return productCategory;
	}

	/**
	 * @param productCategory the productCategory to set
	 */
	public void setProductCategory(Set<ProductCategory> productCategory) {
		this.productCategory = productCategory;
	}
	
	
	

}
