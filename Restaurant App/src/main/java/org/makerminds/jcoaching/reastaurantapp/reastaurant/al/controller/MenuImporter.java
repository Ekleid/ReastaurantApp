package org.makerminds.jcoaching.reastaurantapp.reastaurant.al.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.Menu;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.product.Drink;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.product.Meal;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.product.Product;
import org.makerminds.jcoaching.restaurantapp.restaurant.al.exceptions.InvalidMenuFileException;

public class MenuImporter {
	
	public Menu importMenu(String filePath) {
	
	Menu importedMenu = new Menu();
		try {
		   List<String> fileLines = Files.readAllLines(Paths.get(getClass().getResource(filePath).toURI()));      
		        for(String menuItemAsString : fileLines) {
		          String[] menuItemsStringArray = menuItemAsString.split(",");
		          int productID = Integer.valueOf(menuItemsStringArray[0]);
		          String productName = menuItemsStringArray[1];
		          double productPrice = Double.valueOf(menuItemsStringArray[2]);
		          String productCategory = menuItemsStringArray[3];
		          Product product = null;
		          
		          if("meal".equals(productCategory)) {
		        	  product = new Meal(productID, productName, productPrice);
		       	  }
		          else if("drink".equals(productCategory)) {
	        		boolean sugarFree = Boolean.valueOf(menuItemsStringArray[4]);
		         	  product = new Drink(productID, productName, productPrice, sugarFree);
	        	  }
		          else {
		        	  StringBuffer stringBuffer = new StringBuffer();
		        	  stringBuffer.append("The menu file couldn't be processed as the product category from product")
		        	  .append(productName).append("Is invalid!");
		        	  throw new InvalidMenuFileException(stringBuffer.toString());
		          }
		            importedMenu.getMenuItems().put(productID, product);
		        }
		      }
		        
		        catch(IOException | URISyntaxException e) {
		        	  throw new RuntimeException("Menu file could not be found!");
		          }
		
		        return importedMenu;
	
      }
}

	

