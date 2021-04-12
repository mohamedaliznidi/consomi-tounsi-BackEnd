package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;






@Entity
public class Product implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ID_PRODUCT")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;


	@ManyToOne(cascade = CascadeType.ALL)
	Donations donations;


	public Product(Donations donations, String name, String categoryname, int promotion, String code, float price,
			String image, int quantity, Date expDate, float generalrate, String nature, float initial_price,
			int energie, float matiere_grasse, float acide_gras_sature, float sucres, float fibres, float proteines,
			float sel, int fruits, Set<OrderC> orderc, ProductCategory productCategory) {
		super();
		this.donations = donations;

		this.name = name;
		this.categoryname = categoryname;
		this.promotion = promotion;
		this.code = code;
		this.price = price;
		this.image = image;
		this.quantity = quantity;
		this.expDate = expDate;

		this.generalrate = generalrate;
		this.nature = nature;
		this.initial_price = initial_price;
		this.energie = energie;
		this.matiere_grasse = matiere_grasse;
		this.acide_gras_sature = acide_gras_sature;
		this.sucres = sucres;
		this.fibres = fibres;
		this.proteines = proteines;
		this.sel = sel;
		this.fruits = fruits;
		this.orderc = orderc;
		this.productCategory = productCategory;
	}


	public Donations getDonations() {
		return donations;
	}


	public void setDonations(Donations donations) {
		this.donations = donations;
	}

		

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;

	


	



	private String name;
	
	private String categoryname;
	public String getCategoryname() {
		return categoryname;
	}


	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}


	public String getNature() {
		return nature;
	}


	public void setNature(String nature) {
		this.nature = nature;
	}



	public Set<OrderC> getOrderc() {

		return orderc;
	}


	public void setOrderc(Set<OrderC> orderc) {
		this.orderc = orderc;
	}
	private int promotion;
	public int getPromotion() {
		return promotion;
	}


	public void setPromotion(int promotion) {
		this.promotion = promotion;
	}


	private String code;

	private float price;

	private String image;
	
	private int quantity;

	private Date expDate;
	
	private float generalrate;
	private String nature;
	private float initial_price;
	

	public float getInitial_price() {
		return initial_price;
	}


	public void setInitial_price(float initial_price) {
		this.initial_price = initial_price;
	}


	private int energie;
	private float matiere_grasse;
	private float acide_gras_sature;
	private float sucres;
	private float fibres ;
	private float proteines ;
	private float sel;
	private int fruits;
	
	
	public Product(int id, String name, String code, float price, String image, int quantity, Date expDate,
			float generalrate, String nature, /*Set<OrderC> orderc,*/ ProductCategory productCategory,Matiere matiere) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.price = price;
		this.image = image;
		this.quantity = quantity;
		this.expDate = expDate;
		this.generalrate = generalrate;
		this.nature = nature;
		this.productCategory = productCategory;
		this.matiere=matiere;
	}


	public Product(int id, String name, String code, float price, String image, int quantity, Date expDate,
			float generalrate, String nature, int energie, float matiere_grasse, float acide_gras_sature, float sucres,
			float fibres, float proteines, float sel, int fruits,/* Set<OrderC> orderc,*/ ProductCategory productCategory,Matiere matiere) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.price = price;
		this.image = image;
		this.quantity = quantity;
		this.expDate = expDate;
		this.generalrate = generalrate;
		this.nature = nature;
		this.energie = energie;
		this.matiere_grasse = matiere_grasse;
		this.acide_gras_sature = acide_gras_sature;
		this.sucres = sucres;
		this.fibres = fibres;
		this.proteines = proteines;
		this.sel = sel;
		this.fruits = fruits;
		this.productCategory = productCategory;
		this.matiere=matiere;
	}


	public Product(String nature, int energie, float matiere_grasse, float acide_gras_sature,float sucres, float fibres,
			float proteines, int fruits, float sel) {
		super();
		this.nature = nature;
		this.energie = energie;
		this.matiere_grasse = matiere_grasse;
		this.acide_gras_sature = acide_gras_sature;
	}


	public Product(String name, String code, float price, String image, int quantity, Date expDate, float generalrate,
			String nature,Matiere matiere) {
		super();
		this.name = name;
		this.code = code;
		this.price = price;
		this.image = image;
		this.quantity = quantity;
		this.expDate = expDate;
		this.generalrate = generalrate;
		this.nature = nature;
		this.matiere=matiere;
	}


	public Product(String name, String code) {
		super();
		this.name = name;
		this.code = code;
	}


	public Product(String name, String code, float price, String image, int quantity, Date expDate, float generalrate,
			String nature, int energie, float matiere_grasse, float acide_gras_sature, float sucres, float fibres,
			float proteines, float sel, int fruits,ProductCategory productCategory,Matiere matiere) {
		super();
		this.name = name;
		this.code = code;
		this.price = price;
		this.image = image;
		this.quantity = quantity;
		this.expDate = expDate;
		this.generalrate = generalrate;
		this.nature = nature;
		this.energie = energie;
		this.matiere_grasse = matiere_grasse;
		this.acide_gras_sature = acide_gras_sature;
		this.sucres = sucres;
		this.fibres = fibres;
		this.proteines = proteines;
		this.sel = sel;
		this.fruits = fruits;
		//this.orderc = orderc;
		this.productCategory = productCategory;
		this.matiere=matiere;
	}
	
	
public Product(String name, String code, float price, String image, int quantity, Date expDate, float generalrate,
			String nature, int energie, float matiere_grasse, float acide_gras_sature, float sucres, float fibres,
			float proteines, float sel, int fruits,Matiere matiere) {
		super();
		this.name = name;
		this.code = code;
		this.price = price;
		this.image = image;
		this.quantity = quantity;
		this.expDate = expDate;
		this.generalrate = generalrate;
		this.nature = nature;
		this.energie = energie;
		this.matiere_grasse = matiere_grasse;
		this.acide_gras_sature = acide_gras_sature;
		this.sucres = sucres;
		this.fibres = fibres;
		this.proteines = proteines;
		this.sel = sel;
		this.fruits = fruits;
		this.matiere=matiere;
	}
	


	public int getEnergie() {
		return energie;
	}


	public void setEnergie(int energie) {
		this.energie = energie;
	}


	public float getMatiere_grasse() {
		return matiere_grasse;
	}


	public void setMatiere_grasse(float matiere_grasse) {
		this.matiere_grasse = matiere_grasse;
	}


	public float getAcide_gras_sature() {
		return acide_gras_sature;
	}


	public void setAcide_gras_sature(float acide_gras_sature) {
		this.acide_gras_sature = acide_gras_sature;
	}


	public float getSucres() {
		return sucres;
	}


	public void setSucres(float sucres) {
		this.sucres = sucres;
	}


	public float getFibres() {
		return fibres;
	}


	public void setFibres(float fibres) {
		this.fibres = fibres;
	}


	public float getProteines() {
		return proteines;
	}


	public void setProteines(float proteines) {
		this.proteines = proteines;
	}


	public float getSel() {
		return sel;
	}


	public void setSel(float sel) {
		this.sel = sel;
	}


	public int getFruits() {
		return fruits;
	}


	public void setFruits(int fruits) {
		this.fruits = fruits;
	}


	
	
	
	@JsonIgnore
	@ManyToOne
	ProductCategory productCategory;
	
	
	public ProductCategory getProductCategory() {
		return productCategory;
	}


	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}
	

	@OneToMany(mappedBy="product")
	private List<ItemBasket> items;


	public float getFibres() {
		return fibres;
	}


	public void setFibres(float fibres) {
		this.fibres = fibres;
	}


	public float getProteines() {
		return proteines;
	}


	public void setProteines(float proteines) {
		this.proteines = proteines;
	}


	public float getSel() {
		return sel;
	}


	public void setSel(float sel) {
		this.sel = sel;
	}


	public int getFruits() {
		return fruits;
	}


	public void setFruits(int fruits) {
		this.fruits = fruits;
	}


	@JsonIgnore
	@ManyToMany(mappedBy="products", cascade = CascadeType.ALL)
	private Set<OrderC> orderc;
	
	public Product(String name, String categoryname, int promotion, String code, float price, String image,
			int quantity, Date expDate, float generalrate, String nature, float initial_price, int energie,
			float matiere_grasse, float acide_gras_sature, float sucres, float fibres, float proteines, float sel,
			int fruits, ProductCategory productCategory, List<ItemBasket> items, Matiere matiere) {
		super();
		this.name = name;
		this.categoryname = categoryname;
		this.promotion = promotion;
		this.code = code;
		this.price = price;
		this.image = image;
		this.quantity = quantity;
		this.expDate = expDate;
		this.generalrate = generalrate;
		this.nature = nature;
		this.initial_price = initial_price;
		this.energie = energie;
		this.matiere_grasse = matiere_grasse;
		this.acide_gras_sature = acide_gras_sature;
		this.sucres = sucres;
		this.fibres = fibres;
		this.proteines = proteines;
		this.sel = sel;
		this.fruits = fruits;
		this.productCategory = productCategory;
		this.items = items;
		this.matiere = matiere;
	}


	
	
	public List<ItemBasket> getItems() {
		return items;
	}


	public Product(int id, String name, String categoryname, int promotion, String code, float price, String image,
			int quantity, Date expDate, float generalrate, String nature, float initial_price, int energie,
			float matiere_grasse, float acide_gras_sature, float sucres, float fibres, float proteines, float sel,
			int fruits, ProductCategory productCategory, List<ItemBasket> items, Matiere matiere) {
		super();
		this.id = id;
		this.name = name;
		this.categoryname = categoryname;
		this.promotion = promotion;
		this.code = code;
		this.price = price;
		this.image = image;
		this.quantity = quantity;
		this.expDate = expDate;
		this.generalrate = generalrate;
		this.nature = nature;
		this.initial_price = initial_price;
		this.energie = energie;
		this.matiere_grasse = matiere_grasse;
		this.acide_gras_sature = acide_gras_sature;
		this.sucres = sucres;
		this.fibres = fibres;
		this.proteines = proteines;
		this.sel = sel;
		this.fruits = fruits;
		this.productCategory = productCategory;
		this.items = items;
		this.matiere = matiere;
	}


	public void setItems(List<ItemBasket> items) {
		this.items = items;
	}

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

	public float getGeneralrate() {
		return generalrate;
	}
	public void setGeneralrate(float generalrate) {
		this.generalrate = generalrate;
	}
	public Product() {
		super();
	}

	@Enumerated(EnumType.ORDINAL)
	private Matiere matiere;

	public Matiere getMatiere() {
		return matiere;
	}


	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	


}

