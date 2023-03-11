package org.makerminds.jcoaching.restaurantapp.restaurant.al.controller.order;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.controller.order.OrderCalculatorKS;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.order.OrderItemSize;

public class OrderCalculatorKSTest {

	   OrderCalculatorKS orderCalculatorKS = new OrderCalculatorKS();
	 
	  @Test 
	 public void testGetVATRate() {
	   double vatRate = orderCalculatorKS.getVATRate();
	   Assertions.assertEquals(0.18, vatRate);
	  }
   
	  @Test
	  public void testSizeRateAmount() {
		  
		  double sizeRateAmount = orderCalculatorKS.getSizeRateAmount(OrderItemSize.SMALL);
		  Assertions.assertEquals(0.8, sizeRateAmount);
		 
		  double sizeRateAmountForMediumSize = orderCalculatorKS.getSizeRateAmount(OrderItemSize.MEDIUM);
		  Assertions.assertEquals(1, sizeRateAmountForMediumSize);
		
		  double sizeRateAmountForLargeSize = orderCalculatorKS.getSizeRateAmount(OrderItemSize.LARGE);
		  Assertions.assertEquals(1.25, sizeRateAmountForLargeSize);
		
		  double sizeRateAmountForXXLSize = orderCalculatorKS.getSizeRateAmount(OrderItemSize.XXL);
		  Assertions.assertEquals(1.3, sizeRateAmountForXXLSize);
		
	  }
	 
}
