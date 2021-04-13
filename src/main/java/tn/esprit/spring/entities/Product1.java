package tn.esprit.spring.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.web.bind.annotation.MatrixVariable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Products")
public class Product1 extends AuditModel {
	
	
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ProductId;
	private String ProductName ;
	private String ProductDescription  ;
	
	private Integer Quantity  ;
	private Integer Sold;
	private Double Price  ;
	private String Brand ;
	
	@ManyToOne
	private Stock stock;
	
	@OneToOne(mappedBy="bestProduct")
	private Ray rayon;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "category_id", nullable = true)
	    private Category Category;
	@Lob
	private byte[] ProductImg;
	
	@Column(nullable = true)
	private Double RemisePrice;
	
	//@Pattern(message = "codebar must start  with 619", regexp="^619*[0-9]{9}")
	private String codebar ;
	
	/*@JsonIgnore
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="PublicityId",nullable = true)*/
	//private Publicity Publicity;
	
	
	/*@JsonManagedReference
	 @JoinColumn(name = "order_id", nullable = true)
	@OneToMany(mappedBy = "ProductId",cascade = CascadeType.REMOVE)*/
	//private Set<Comment> Comments ;
	
	
	/*@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "order_id", nullable = true)*/
	    //private Orders orders;

	public Product1() {
		super();
	}

	
	public Long getProductId() {
		return ProductId;
	}

	public void setProductId(Long productId) {
		ProductId = productId;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public String getProductDescription() {
		return ProductDescription;
	}

	public void setProductDescription(String productDescription) {
		ProductDescription = productDescription;
	}

	public Integer getQuantity() {
		return Quantity;
	}

	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}

	public Double getPrice() {
		return Price;
	}

	public void setPrice(Double price) {
		Price = price;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}
	@JsonIgnore
	public Category getCategory() {
		return Category;
	}

	public void setCategory(Category category) {
		this.Category = category;
	}

	public byte[] getProductImg() {
		return ProductImg;
	}

	public void setProductImg(byte[] productImg) {
		ProductImg = productImg;
	}

	public Double getRemisePrice() {
		return RemisePrice;
	}

	public void setRemisePrice(Double remisePrice) {
		RemisePrice = remisePrice;
	}

	public String getCodebar() {
		return codebar;
	}

	public void setCodebar(String codebar) {
		this.codebar = codebar;
	}

	public Integer getSold() {
		return Sold;
	}

	public void setSold(Integer sold) {
		Sold = sold;
	}


	public Product1(Long productId, String productName, String productDescription, Integer quantity, Integer sold,
			Double price, String brand,tn.esprit.spring.entities.Category category, byte[] productImg, Double remisePrice,
			String codebar) {
		super();
		ProductId = productId;
		ProductName = productName;
		ProductDescription = productDescription;
		Quantity = quantity;
		Sold = sold;
		Price = price;
		Brand = brand;
		Category = category;
		ProductImg = productImg;
		RemisePrice = remisePrice;
		this.codebar = codebar;}


	public Product1(String productName, String productDescription, Integer quantity, Integer sold, Double price,
			String brand, tn.esprit.spring.entities.Category category, byte[] productImg, Double remisePrice, String codebar) {
		super();
		ProductName = productName;
		ProductDescription = productDescription;
		Quantity = quantity;
		Sold = sold;
		Price = price;
		Brand = brand;
		Category = category;
		ProductImg = productImg;
		RemisePrice = remisePrice;
		this.codebar = codebar;
	}


	public Ray getRayon() {
		return rayon;
	}


	public void setRayon(Ray rayon) {
		this.rayon = rayon;
	}


	public Product1(Long productId, String productName, String productDescription, Integer quantity, Integer sold,
			Double price, String brand, Ray rayon, tn.esprit.spring.entities.Category category, byte[] productImg,
			Double remisePrice, String codebar) {
		super();
		ProductId = productId;
		ProductName = productName;
		ProductDescription = productDescription;
		Quantity = quantity;
		Sold = sold;
		Price = price;
		Brand = brand;
		this.rayon = rayon;
		Category = category;
		ProductImg = productImg;
		RemisePrice = remisePrice;
		this.codebar = codebar;
	}


	public Stock getStock() {
		return stock;
	}


	public void setStock(Stock stock) {
		this.stock = stock;
	}

	/*public Publicity getPublicity() {
		return Publicity;
	}

	public void setPublicity(Publicity publicity) {
		Publicity = publicity;
	}*/

	/*public Set<Comment> getComments() {
		return Comments;
	}

	public void setComments(Set<Comment> comments) {
		Comments = comments;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}*/
	
	
	
	
	
	

}
