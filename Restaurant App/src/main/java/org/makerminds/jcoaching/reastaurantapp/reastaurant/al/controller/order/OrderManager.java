package org.makerminds.jcoaching.reastaurantapp.reastaurant.al.controller.order;

import java.util.ArrayList;

import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.Menu;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.order.Order;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.order.OrderItem;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.order.OrderItemSize;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.product.Product;

public class OrderManager {
	
      private ArrayList<Order> orders = new ArrayList<>();

	
public ArrayList<Order> getOrders() {
		return orders;
	}

	public Order createOrder(Menu menu) {
	
		
	Order order = new Order();
	
    ArrayList<OrderItem> orderItems = order.getOrderItems();
    addOrderItem(order, menu.getMenuItems().get(100), 1, OrderItemSize.XXL);
    addOrderItem(order, menu.getMenuItems().get(101), 2, OrderItemSize.LARGE); 
    addOrderItem(order, menu.getMenuItems().get(102), 3, OrderItemSize.MEDIUM);
    addOrderItem(order, menu.getMenuItems().get(103), 4, OrderItemSize.SMALL);
    
    return order;
}
	
  private void addOrderItem(Order order,Product product, int quantity, OrderItemSize orderItemSize) {
  OrderItem orderItemMeal = createOrderItem(product, orderItemSize, quantity);
  order.getOrderItems().add(orderItemMeal);
  }

  private OrderItem createOrderItem(Product product, OrderItemSize orderItemSize, int quantity) {
	
	return new OrderItem(product, quantity, orderItemSize);
}
  
   
	}
