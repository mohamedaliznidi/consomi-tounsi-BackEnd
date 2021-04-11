package tn.esprit.spring.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class ItemBasket {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		int id;
		int quantity;
		@ManyToOne
		Basket basket;
		@ManyToOne
		Product product;
		public ItemBasket() {
		
		}
		
		public ItemBasket(int quantity, Basket basket, Product product) {
			this.quantity = quantity;
			this.basket = basket;
			this.product = product;
		}

		public ItemBasket(int id, int quantity, Basket basket, Product product) {
			super();
			this.id = id;
			this.quantity = quantity;
			this.basket = basket;
			this.product = product;
		}
		

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public Basket getBasket() {
			return basket;
		}

		public void setBasket(Basket basket) {
			this.basket = basket;
		}

		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}

		@Override
		public String toString() {
			return "ItemBasket [id=" + id + ", quantity=" + quantity + ", basket=" + basket + ", product=" + product
					+ "]";
		}
		
		
		
}
