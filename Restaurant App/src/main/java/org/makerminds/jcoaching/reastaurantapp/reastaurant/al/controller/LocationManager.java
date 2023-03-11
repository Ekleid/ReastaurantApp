package org.makerminds.jcoaching.reastaurantapp.reastaurant.al.controller;

import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.controller.order.enums.Location;

public class LocationManager {
	
	public static Location getLocationFromString(int locationID) {
		
		switch(locationID) {
		case 1:
			return Location.KOSOVO;
		case 2:
			return Location.GERMANY;
			default:
				throw new IllegalArgumentException("Location could not be found!");
		}
}
   
}
