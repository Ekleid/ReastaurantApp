package org.makerminds.jcoaching.reastaurantapp.reastaurant.al.controller.menu;

import java.util.Map.Entry;

import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.Menu;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.product.Product;

public class MenuPrinter {
	
	public void printMenu(Menu menu) {
		
		System.out.println("-------------------Menu-------------------");
		//Set<Entry<Integer, Product>> menuEntry = menu.getMenuItems().entrySet();---> alt+shift+L
		for(Entry<Integer, Product> menuEntry : menu.getMenuItems().entrySet()) {
			Product menuItem = menuEntry.getValue();
			System.out.println(menuItem.getProductId() +" " + menuItem.getName() + " " + menuItem.getPrice());
			
			
		}
		System.out.println("--------------------------------------");
		System.out.println("");
	}

}
