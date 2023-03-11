package org.makerminds.jcoaching.reastaurantapp.reastaurant.al.controller.order;

import java.util.ArrayList;


import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.order.Order;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.order.OrderAmount;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.order.OrderItem;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.product.Product;
import org.makerminds.jcoaching.restaurantapp.restaurant.al.exceptions.InvalidOrderItemSizeException;

public abstract class  AbstractOrderCalculator implements IOrderCalculator{
	
	protected abstract double getVATRate();
	public double getVATRate(boolean decimal) {
		if(decimal) {
			return getVATRate();
		}
		else {
			return getVATRate() * 100; 
		}
		
	} 
	public double calculateTotalOrderAmunt(Order order) {
		ArrayList<OrderItem> orderItems = order.getOrderItems();
		double totalOrderAmount= 0.0;
		
		for(OrderItem orderItem : orderItems) {
			totalOrderAmount +=calculateTotalOrderItemPrice(orderItem);
		}
		return totalOrderAmount;
	} 
	public double calculateTotalOrderItemPrice(OrderItem orderItem) {
		double orderItemPriceIncludingSizeRate = calculateOrderItemPriceIncludingSizeRate(orderItem);
		return orderItemPriceIncludingSizeRate*orderItem.getQuantity();
	}

	private double calculateOrderItemPriceIncludingSizeRate(OrderItem orderItem) {
		double sizeRateAmount = 1;
		try {
			sizeRateAmount=getSizeRateAmount(orderItem.getOrderItemSize());
		}
		catch (InvalidOrderItemSizeException e){
			System.err.println("No valid orderItem size for item "+ orderItem.getProduct().getName()
					+". Default size rate amount 100% will be applied.");
		}
			
			Product product = orderItem.getProduct();
			double  totalOrderItemPriceSingle = product.getPrice()*sizeRateAmount;
			orderItem.setOrderItemPrice(totalOrderItemPriceSingle);
				
		return totalOrderItemPriceSingle;
	}
	public double  calculateTotalOrderAmountVAT(double totalOrderAmount) {
		return totalOrderAmount * getVATRate();
	}
	
	public OrderAmount calculateOrderAmount(Order order ) {
		
		double totalOrderAmount=calculateTotalOrderAmount(order);
		double totalOrderAmountVAT= calculateTotalOrderAmountVAT(totalOrderAmount);
		double totalOrderAmountWithVAT = totalOrderAmount+totalOrderAmountVAT;
		OrderAmount orderAmount = new OrderAmount(totalOrderAmount,totalOrderAmountVAT,totalOrderAmountWithVAT);
		return orderAmount;
	}
	

}
