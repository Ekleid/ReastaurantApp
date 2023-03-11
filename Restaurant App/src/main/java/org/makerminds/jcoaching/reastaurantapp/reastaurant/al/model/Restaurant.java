package org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model;

public class Restaurant {
	
	private String name;
	private String adress;
	
	public Restaurant(String name, String adress) {
		
		this.name = name;
		this.adress = adress;
	}
	
	public String getName( ) {
		return name;
	}
		
		public void setName(String name) {
			this.name = name;
			
			// shortcut for generate : alt + shift + s
		
	}

		public String getAdress() {
			return adress;
		}

		public void setAdress(String adress) {
			this.adress = adress;
		}
		
}
	
	
	