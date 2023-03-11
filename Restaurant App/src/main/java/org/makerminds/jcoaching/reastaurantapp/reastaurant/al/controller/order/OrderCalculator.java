package org.makerminds.jcoaching.reastaurantapp.reastaurant.al.controller.order;

import java.util.ArrayList;

import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.order.Order;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.order.OrderAmount;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.order.OrderItem;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.order.OrderItemSize;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.product.Product;

public class OrderCalculator {
	

	//<modifier> eshte public
	public double calculateTotalOrderAmount(Order order) {
		ArrayList<OrderItem> orderItems = order.getOrderItems();
	       double totalOrderAmount = 0.0;
	       
	       
	    for(OrderItem orderItem : orderItems) {
		   totalOrderAmount += calculateOrderItemPrice(orderItem);
	    }
	        return totalOrderAmount;

	}
	
	
	private double calculateOrderItemPrice(OrderItem orderItem) {
		double sizeRateAmount = getSizeRateAmount(orderItem.getOrderItemSize());
		
		Product product = orderItem.getProduct();
		double totalOrderItemPriceSingle = product.getPrice() * sizeRateAmount;
		orderItem.setOrderItemPrice(totalOrderItemPriceSingle);
		return totalOrderItemPriceSingle * orderItem.getQuantity();
	}


	private double getSizeRateAmount(OrderItemSize orderItemSize) {
		
	  switch(orderItemSize) {
	case SMALL:
		return 0.8;
	case MEDIUM:
		return 1;
	case LARGE:
		return 1.25;
	case XXL:
		return 1.3;
		default:
			System.err.println(" No valid order item size:" + orderItemSize);
		return 1;
	}
	
}

	public double calculateTotalOrderAmountVAT(double totalOrderAmount) {
			
		// llogarisim vleren totale te VAT
		return  totalOrderAmount * 18 / 100;
		
	}
	
	 public OrderAmount calculateOrderAmount(Order order) {
		 double totalOrderAmount = calculateTotalOrderAmount(order);
		 double totalOrderAmountVAT = calculateTotalOrderAmountVAT(totalOrderAmount);
		 double totalOrderAmountWithVAT = totalOrderAmount + totalOrderAmountVAT;
		 OrderAmount orderAmount = new OrderAmount(totalOrderAmount, totalOrderAmountVAT, totalOrderAmountWithVAT); 
			 return orderAmount; 
		 
	 }

}
			 
	
