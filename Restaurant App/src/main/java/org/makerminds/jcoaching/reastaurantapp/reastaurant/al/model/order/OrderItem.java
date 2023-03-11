package org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.order;

import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.product.Product;

public class OrderItem {
	
	private Product product;
	private int quantity;
	private OrderItemSize orderItemSize;
	private double orderItemPrice;
	
	
	public OrderItem(Product product, int quantity, OrderItemSize orderItemSize) {
	    this.product = product;
		this.quantity = quantity;
		this.orderItemSize = orderItemSize;
		
	}
	
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public OrderItemSize getOrderItemSize() {
		return orderItemSize;
	}
	public void setOrderItemSize(OrderItemSize orderItemSize) {
		this.orderItemSize = orderItemSize;
	}
	public double getOrderItemPrice() {
		return orderItemPrice;
	}
	public void setOrderItemPrice(double orderItemPrice) {
		this.orderItemPrice = orderItemPrice;
	}
	
	

}
