package org.makerminds.jcoaching.reastaurantapp.reastaurant.al.controller.order;

import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.order.Order;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.order.OrderAmount;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.order.OrderItem;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.order.OrderItemSize;

public class OrderCalculatorGER extends AbstractOrderCalculator {
	
	 private final double VAT_Rate = 0.19;
	
	public double getSizeRateAmount(OrderItemSize orderItemSize) {
		
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

	@Override
	public double calculateTotalOrderAmount(Order order) {
		
		return 0;
	}

	@Override
	public double calculateOrderItemPrice(OrderItem orderItem) {
		
		return 0;
	}

	
	@Override
	public double calculateTotalOrderAmountVAT(double totalOrderAmount) {
		
		return totalOrderAmount;
	}

	@Override
	public OrderAmount calculateOrderAmount(Order order) {
	
		return null;
	}

	@Override
	protected double getVATRate() {
		
		return VAT_Rate;
	}
	
}
			 
		 
	 
		 
	
	   


