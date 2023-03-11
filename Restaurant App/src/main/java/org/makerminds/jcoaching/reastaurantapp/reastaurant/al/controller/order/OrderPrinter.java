package org.makerminds.jcoaching.reastaurantapp.reastaurant.al.controller.order;

import java.util.ArrayList;

import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.controller.order.enums.Location;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.Restaurant;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.client.Client;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.order.Order;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.order.OrderAmount;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.order.OrderItem;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.product.Product;

public class OrderPrinter {
	   
	
	
	public void printOrderInfoHeader(Client client) {
		System.out.println("Order from: " + " " + client.getName()); 
       	System.out.println("Contact number: " + " " + client.getPhoneNr()); 
        System.out.println("---------------------------------");
	 
	}
	
	
	public void printOrderItemInfo(OrderItem orderItem) {
		Product product = orderItem.getProduct();
		double totalOrderItemPrice = orderItem.getOrderItemPrice() * orderItem.getQuantity();
		System.out.println(orderItem.getQuantity() + "x |" + product.getProductId() + ". " + 
		product.getName() + "| " + orderItem.getOrderItemPrice() + " | " + totalOrderItemPrice + " Euro." );
	}
	
	
	public void printOrderInfoFooter(Restaurant restaurant, Order order, Location location) {
		IOrderCalculator orderCalculator = getOrderCalculator(location);
		OrderAmount orderAmount = orderCalculator.calculateOrderAmount(order);
	   int VAT_Rate =(int)orderCalculator.getVATRate(false);
		
		    System.out.println("---------------------------------");
			System.out.println("SUB total:" +  orderAmount.getTotalOrderAmount() + " " + "Euro.");
			System.out.println("VAT value:" + VAT_Rate + "%" +  orderAmount.getTotalOrderAmountVAT() + " " + "Euro.");
	        System.out.println("Total:" +  orderAmount.getTotalOrderAmountWithVAT() + " " + "Euro.");       
	        System.out.println("---------------------------------");
	        System.out.println(restaurant.getName() + " " + "in" + " " + restaurant.getAdress());
	        		
	}


	private IOrderCalculator getOrderCalculator(Location currentLocation)  {
		
		
		if(currentLocation == null) {
			throw new IllegalArgumentException("Current lcoation must not be null!");
		}
		else {
			switch(currentLocation) {
			case KOSOVO:
				return new OrderCalculatorKS();
			case GERMANY:
				return new OrderCalculatorGER();
			default:
				System.out.println("Current location is invalid");
				return null;
			}
		}
	}


	public void printOrderInfo( Client client,Restaurant restaurant, Order order,Location location) {
		printOrderInfoHeader(client);
		ArrayList<OrderItem> OrderProducts = order.getOrderItems();
	for(OrderItem orderItem : OrderProducts){
		printOrderItemInfo(orderItem);
	}
		printOrderInfoFooter(restaurant, order, location);
		
	}



public void printOrderInfo(Restaurant restaurant, Client client, Order order, OrderAmount orderAmount) {
		
	}

}
