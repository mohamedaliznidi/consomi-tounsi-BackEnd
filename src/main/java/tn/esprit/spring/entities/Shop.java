package tn.esprit.spring.entities; 
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;



@Embeddable

public class Shop {
     @Column
	private String deliveryName;
     @Embedded
	private Address deliveryAddress;
     @Column
	private double deliveryLatitude;
     public Shop() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Shop(String deliveryName, Address deliveryAddress, double deliveryLatitude, double deliveryLongitude) {
		super();
		this.deliveryName = deliveryName;
		this.deliveryAddress = deliveryAddress;
		this.deliveryLatitude = deliveryLatitude;
		this.deliveryLongitude = deliveryLongitude;
	}
	@Column
	private double deliveryLongitude;
	@Column
     public String getDeliveryName() {
		return deliveryName;
	}
	
	

	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}
	public Address getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public double getDeliveryLatitude() {
		return deliveryLatitude;
	}
	public void setDeliveryLatitude(double deliveryLatitude) {
		this.deliveryLatitude = deliveryLatitude;
	}
	public double getDeliveryLongitude() {
		return deliveryLongitude;
	}
	public void setDeliveryLongitude(double deliveryLongitude) {
		this.deliveryLongitude = deliveryLongitude;
	}
     
	/*public double getShopLatitude() {
		return deliveryLatitude;
	}

	public void setdeliveryLatitude(double deliveryLatitude) {
		this.deliveryLatitude = deliveryLatitude;
	}

	public double getShopLongitude() {
		return deliveryLongitude;
	}

	public void setShopLongitude(double shopLongitude) {
		this.deliveryLongitude = shopLongitude;
	}

	public String getShopName() {
		return deliveryName;
	}

	public void setShopName(String shopName) {
		this.deliveryName = shopName;
	}

	public Address getShopAddress() {
		return deliveryAddress;
	}

	public void setShopAddress(Address shopAddress) {
		this.deliveryAddress = shopAddress;
	}*/

}

