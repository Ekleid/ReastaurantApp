package org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.product;
 
public class Drink extends Product{
	
	private boolean sugarFree;
	
	public Drink(int productId, String name, double price, boolean sugarFree) {
		setProductId(productId);
		setName(name);
		setPrice(price);
		this.sugarFree = sugarFree;
		
	}

	public Drink(int productId, String name, double price) {
		
	}

	public boolean isSugarFree() {
		return sugarFree;
	}

	public void setSugarFree(boolean sugarFree) {
		this.sugarFree = sugarFree;
	}

}
