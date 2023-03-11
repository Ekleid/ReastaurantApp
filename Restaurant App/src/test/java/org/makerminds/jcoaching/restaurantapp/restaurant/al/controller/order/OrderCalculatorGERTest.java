package org.makerminds.jcoaching.restaurantapp.restaurant.al.controller.order;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.controller.order.OrderCalculatorGER;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.order.OrderItemSize;

public class OrderCalculatorGERTest {
	 OrderCalculatorGER orderCalculatorGER = new OrderCalculatorGER();
	 
	 @Test
	 public void testGetVATRate() {
		 double VATRate = orderCalculatorGER.getVATRate(false);
		Assertions.assertEquals(19.0, VATRate);
	 }
	@Test 
  public void testSizeRateAmount() {
		  
		  double sizeRateAmount = orderCalculatorGER.getSizeRateAmount(OrderItemSize.SMALL);
		  Assertions.assertEquals(0.8, sizeRateAmount);
		 
		  double sizeRateAmountForMediumSize = orderCalculatorGER.getSizeRateAmount(OrderItemSize.MEDIUM);
		  Assertions.assertEquals(1, sizeRateAmountForMediumSize);
		
		  double sizeRateAmountForLargeSize = orderCalculatorGER.getSizeRateAmount(OrderItemSize.LARGE);
		  Assertions.assertEquals(1.25, sizeRateAmountForLargeSize);
		
		  double sizeRateAmountForXXLSize = orderCalculatorGER.getSizeRateAmount(OrderItemSize.XXL);
		  Assertions.assertEquals(1.3, sizeRateAmountForXXLSize);
		
	  }

}
