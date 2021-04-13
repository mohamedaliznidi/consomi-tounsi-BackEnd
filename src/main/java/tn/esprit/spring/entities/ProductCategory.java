package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;




@Entity

public class ProductCategory implements Serializable {

	public ProductCategory(int id, String categoryName) {
		this.id = id;
		this.categoryName = categoryName;
	}
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	public ProductCategory(String categoryName) {
		super();
	
	}
	
	@Column(name="category_name", unique =true , nullable = false)
	private String categoryName;

	
	
	
	@OneToMany( mappedBy="productCategory")
	private Set<Product> products;


	
	public int getId() {
		return id;
	}
	
	
	public ProductCategory() {
		super();
	}


	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getCategoryName() {
		return categoryName;
	}
	
	
	
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	
}
