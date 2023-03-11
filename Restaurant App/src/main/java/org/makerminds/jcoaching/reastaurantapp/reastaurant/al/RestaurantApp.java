package org.makerminds.jcoaching.reastaurantapp.reastaurant.al;



import java.util.Scanner;

import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.controller.LocationManager;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.controller.menu.MenuPrinter;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.controller.order.OrderCalculator;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.controller.order.OrderManager;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.controller.order.OrderPrinter;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.controller.order.enums.ApplicationMode;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.controller.order.enums.Location;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.Menu;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.Restaurant;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.client.Client;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.order.Order;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.order.OrderAmount;

public class RestaurantApp {
	
	private static Location currentLocation;

	private static Scanner scanner = new Scanner(System.in);
	
	public static void main (String[] args) {
	
	 
	ApplicationMode selectedApplicationMode = getApplicationMode();	
	getCurrentLocation();
	validateApplicationMode(selectedApplicationMode);
	
	} // end of method
	
	private static void getCurrentLocation() {
	
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("Please select your location:").append(System.lineSeparator())
		.append("1. " + Location.KOSOVO.name()).append(System.lineSeparator())
		.append("2. " + Location.GERMANY.name());
		
		System.out.println(stringBuilder.toString());
		
		int selectedLocationID = scanner.nextInt();
		
		currentLocation = LocationManager.getLocationFromString(selectedLocationID);
	}

	private static ApplicationMode getApplicationMode() {
	
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("Please select an application mode(type number).").append(System.lineSeparator())
		.append("1. " + ApplicationMode.ORDER.name()).append(System.lineSeparator())
		.append("2. " + ApplicationMode.TABLERESERVATION.name());
		
		System.out.println(stringBuilder.toString());
		
		int selectedApplicationModeID = scanner.nextInt();
	       ApplicationMode selectedApplicationMode = getSelectedApplicationModeFromID(selectedApplicationModeID);
		
		return selectedApplicationMode;
	}
	
	private static ApplicationMode getSelectedApplicationModeFromID(int selectedApplicationModeID) {
		
		switch(selectedApplicationModeID) {
		case 1:
			return ApplicationMode.ORDER;
		case 2:
			return ApplicationMode.TABLERESERVATION;
			default :
				return null;
		}
	}

	private static void validateApplicationMode(ApplicationMode applicationMode) {
		
		switch(applicationMode) {
		case ORDER:
			runOrderProcess();
			break;
			
			
		case TABLERESERVATION:
			runTableReservationProcess();
			break;
		
		default: System.err.println("No valid appication mode selected!");
		
		}
	}


	      private static void runTableReservationProcess() {
	    	  System.out.println("Table number 3 was reserved successfully.");
	    	
		
	}

	private static void runOrderProcess() {
		
		Menu menu = new Menu();
		menu.initializeMenuProducts();
		
	    MenuPrinter menuPrinter = new MenuPrinter();
	    menuPrinter.printMenu(menu);
	
	    OrderManager orderManager = new OrderManager();
		
		Order order = orderManager.createOrder(menu);
		
		OrderCalculator orderCalculator = new OrderCalculator();
		
		OrderAmount orderAmount = orderCalculator.calculateOrderAmount(order);
		
		OrderPrinter orderPrinter = new OrderPrinter();
		
		Client client =  new Client("Ekleid Bodo","+355987567" );
		
		Restaurant restaurant = new Restaurant("Grepi i Arte", "Rruga Myslym Shyri");
		
		orderPrinter.printOrderInfo(restaurant, client, order, orderAmount);
	 }

   
 }
        
        
