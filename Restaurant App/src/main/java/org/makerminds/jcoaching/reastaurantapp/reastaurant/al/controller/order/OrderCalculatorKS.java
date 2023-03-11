package org.makerminds.jcoaching.reastaurantapp.reastaurant.al.controller.order;


import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.order.Order;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.order.OrderAmount;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.order.OrderItem;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.order.OrderItemSize;

public class OrderCalculatorKS extends AbstractOrderCalculator{
	
	private final double VAT_Rate = 0.18;

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
	public double getVATRate() {
		
		return VAT_Rate;
	}



	@Override
	public double calculateTotalOrderAmount(Order order) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public double calculateOrderItemPrice(OrderItem orderItem) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public double calculateTotalOrderAmountVAT(double totalOrderAmount) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public OrderAmount calculateOrderAmount(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
			 
	