package org.makerminds.jcoaching.restaurantapp.restaurant.al.controller.order;


import java.util.HashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.controller.MenuImporter;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.Menu;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.product.Product;

public class MenuImporterTest {
	
	private MenuImporter menuImporter = new MenuImporter();
	private final String MENU_FILE_PATH = "/menu-test.txt";
    
	@Test
	public void testImportMenu() {
		
		Menu importedMenu = menuImporter.importMenu(MENU_FILE_PATH);
		HashMap<Integer, Product> menuItems = importedMenu.getMenuItems();
		Assertions.assertEquals(8, menuItems.size());
	}

}
