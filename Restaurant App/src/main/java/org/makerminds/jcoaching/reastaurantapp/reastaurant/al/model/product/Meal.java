package org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.product;

public class Meal extends Product {
	
  private String description;
  
    public Meal(int productId, String name, double price) {
	  setProductId(productId);
	  setName(name);
	  setPrice(price);
	  
  }
  
   public Meal(int productId, String name, double price, String description)  {
	   this(productId, name, price);
	   this.description = description;
   }
    
    
    
    
 public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}
 
}
	
	
