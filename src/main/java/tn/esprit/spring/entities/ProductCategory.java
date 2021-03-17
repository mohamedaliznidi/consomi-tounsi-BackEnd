package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity

public class ProductCategory implements Serializable {
	
	
	/**
	 * @param id
	 * @param categoryName
	 * @param products
	 */
	public ProductCategory(int id, String categoryName, Product products) {
		this.id = id;
		this.categoryName = categoryName;
		this.products = products;
	}
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String categoryName;
	@ManyToOne
	Product products;
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
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	/**
	 * @return the products
	 */
	public Product getProducts() {
		return products;
	}
	/**
	 * @param products the products to set
	 */
	public void setProducts(Product products) {
		this.products = products;
	}
	
}
