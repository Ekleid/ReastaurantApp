package org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.product;

public abstract class Product {
	private String name;
	private int productId;
	private double price;
	
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}