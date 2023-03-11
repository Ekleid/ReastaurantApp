package org.makerminds.jcoaching.reastaurantapp.reastaurant.al.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.controller.MenuImporter;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.Menu;
import org.makerminds.jcoaching.reastaurantapp.reastaurant.al.model.product.Product;

import javax.swing.JLabel;
import javax.swing.JButton;

public class RestaurantAppGUI {

	private JFrame frame;
	
	private DefaultTableModel menuDataTableModel = new DefaultTableModel();
	
	private final String Menu_File_Path = "/pizza-menu.txt";
	
	private boolean fromFile = true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RestaurantAppGUI window = new RestaurantAppGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RestaurantAppGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
			
		JLabel jLabel = new JLabel("Welcome to Restaurant Ora");
		frame.getContentPane().add(jLabel, BorderLayout.NORTH);
		jLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
	    prepareMenuDataForTable();
        JTable table = new JTable(menuDataTableModel);
        
        //e ben tabelen te levizshme
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Restaurant menu"));
        
        //ruan dhe organizon me mire tabelen
        JPanel panel = new JPanel();
        panel.add(scrollPane);
        
        JButton sitchButton = createSwitchButton(panel);
        panel.add(sitchButton);
        frame.getContentPane().add(panel);
        
        
    }
	
	private Menu getMenu() {
		Menu menu;
		if(fromFile) {
			MenuImporter menuImporter = new MenuImporter();
			menu = menuImporter.importMenu(Menu_File_Path);
		}else {
			menu = new Menu();
			menu.initializeMenuProducts();
		}
		return menu;
	}
	
	private JButton createSwitchButton(JPanel panel) {
		JButton switchButton = new JButton("Switch");
		switchButton.setBounds(100, 115, 95, 40);
		switchButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fromFile = fromFile == false ? true : false;
				prepareMenuDataForTable();
				
		}
			
     });
		return switchButton;
 }
	
	
	
	
	private void prepareMenuDataForTable() {
	
		
		String[][] menuArray = createMenuArray();
		String[] tableHeader = {"ID", "Name", "Price"};
		menuDataTableModel.setDataVector(menuArray, tableHeader);
		
		
	}

	private String[][] createMenuArray() {
		
		Menu menu = getMenu();
		menu.initializeMenuProducts();
		
		HashMap<Integer, Product> menuItems = menu.getMenuItems();
		String[][] menuArray = new String[menuItems.size()][3];
		
		int i = 0;
		for(Entry<Integer, Product> menuItem : menuItems.entrySet()) {
			
			Product product = menuItem.getValue();
			menuArray[i][0] = Integer.toString(product.getProductId());
			menuArray[i][1] = product.getName();
			menuArray[i][2] = Double.toHexString(product.getPrice());
		    i++;
		}
		
		return menuArray;
	}
		

}

