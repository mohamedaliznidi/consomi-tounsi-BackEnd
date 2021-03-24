package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
			ProductCategory productcategory ,int generalrate) {
		this.id = id;
		this.name = name;
		this.code = code;
		this.price = price;
		this.image = image;
		this.quantity = quantity;
		this.expDate = expDate;
		this.productcategory = productcategory;
		this.generalrate=generalrate;
	}

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ID_PRODUCT")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String name;
	
	private String code;

	private float price;

	private String image;
	
	private int quantity;

	private Date expDate;
	
	private int generalrate;
	
	private ProductCategory productcategory;
	
	@ManyToMany(mappedBy="products", cascade = CascadeType.ALL)
	private Set<OrderC> orderc;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="products")
	private Set<ProductCategory> productCategory;
	
	
	
	//private List<CommentProduct> comments;
	@OneToMany(mappedBy="product")
	private List<CommentProduct> comments;
	public List<CommentProduct> getComments(){
		return comments;
	}
	
	public void setComments(List<CommentProduct> comments){
		this.comments=comments;
	}
	

	
	
	//Getters&Setters
	
	
	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	
	
	public String getCode() {
		return code;
	}

	
	public void setCode(String code) {
		this.code = code;
	}

	
	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}

	
	
	public String getImage() {
		return image;
	}

	
	public void setImage(String image) {
		this.image = image;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public Date getExpDate() {
		return expDate;
	}



	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public int getGeneralrate() {
		return generalrate;
	}

	public void setGeneralrate(int generalrate) {
		this.generalrate = generalrate;
	}


	

}
