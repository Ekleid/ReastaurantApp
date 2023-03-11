package org.makerminds.jcoaching.reastaurantapp.reastaurant.al.controller.order;

import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.order.Order;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.order.OrderAmount;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.order.OrderItem;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.order.OrderItemSize;

public interface IOrderCalculator {
		
	public double calculateTotalOrderAmount(Order order);
	public double calculateOrderItemPrice(OrderItem orderItem);
	public double getSizeRateAmount(OrderItemSize orderItemSize);
	public double calculateTotalOrderAmountVAT(double totalOrderAmount) ;
    public OrderAmount calculateOrderAmount(Order order) ;
    public double getVATRate(boolean decimal);
}
