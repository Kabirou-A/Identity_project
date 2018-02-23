/**
 * 
 */
package fr.epita.iam.services;
import java.util.Scanner;

import fr.epita.iam.datamodel.Identity;
import fr.epita.iam.exceptions.IdentityCreationException;
import fr.epita.iam.exceptions.IdentityDeleteException;
import fr.epita.iam.exceptions.IdentitySearchException;
import fr.epita.iam.exceptions.IdentityUpdateException;
import fr.epita.iam.services.dao.IdentityJDBCDAO;
import fr.epita.logger.Logger;

/**
 * @author ADEBOWALE
 * MenuService will display on screen and allow register user to perform CRUD operation
 */
public class MenuService extends DisplayMenu{
	private static final Logger LOGGER = new Logger(MenuService.class);
	

	/*
	 * Default construction to create instance of MenuService object  
	 */
	public MenuService() {
		new DisplayMenu();
	}
	
	/*
	 * create the main menu to perform CRUD operations
	 */
	
	
	/*
	 * IdentityMenu() method to perform CRUD operations on  IDENTITIES table
	 */
	public void IdentityMenu() {
		
		identityMenu();
		
		Scanner keyboard = new Scanner( System.in );
		String input = keyboard.nextLine().toLowerCase();
		
		while(input != "0"){
			
			 switch(input){
	         case "0" : System.out.println("You close the App"); System.exit(0);
	            break;
	         
	         case "c": 
	        	 consoleCreateIdentity();
	        	 IdentityMenu();
	             break;
	         case "r" : 
	        	 consoleSearchIdentity();
	        	 IdentityMenu();
	         	break;
	         
	         case "u" :
	        	 consoleUpdateIdentity();
	        	 IdentityMenu();
	         	break;
	         case "d" : 
	        	 consoleDeleteIdentity();
	        	 IdentityMenu();
	         	break;
	         	
	         case "3" : mainMenuOption();
	         	break;
	            
	         default :System.out.println("Invalid selection"); IdentityMenu();
	            break;	
	            
			 }
		 break;
		}
	}
	
	/*
	 * AddressMenu() method to perform CRUD operations on  ADDRESS table
	 */
	public void AddressMenu() {
			
		addressMenu();
		
		Scanner keyboard = new Scanner( System.in );
		String input = keyboard.nextLine().toLowerCase();
		
		while(input != "0"){
			
			 switch(input){
	         case "0" : System.out.println("You close the App"); 
	         			System.exit(0);
	            break;
	         
	         case "c": 
	        
	            break;
	            
	         case "r" : 

	        	
	         	break;
	         case "u" : 
	        	
	         	break;
	         
	         case "d" : 
	        	 try {
						new IdentityJDBCDAO().delete(new Identity());
					} catch (IdentityDeleteException e) {
						e.printStackTrace();
					
					}
	         	break;
	         	
	         case "3" : mainMenuOption();
	         	break;
	            
	         default :	System.out.println("Invalid selection"); 
	         			mainMenuOption();
	            break;	
			 }
		 break;
		}
	}
	
	/*
	 * mainMenuOption() method allow registered user between the menus or exit the application
	 */
	public void mainMenuOption() {
		Scanner keyboard = new Scanner( System.in );
		
		firstMenu();
		
		String input = keyboard.nextLine();
		while(input != "0"){
			
			 switch(input){
	         case "0" : System.out.println("You close the App"); 
	         			System.exit(0);
	            break;
	         
	         case "1" : IdentityMenu();
	            break;
	            
	         case "2" : AddressMenu();
	         	break;
	            
	         default :	System.out.println("Invalid selection"); 
	         			mainMenuOption();
	            break;	
	            
			 }
		 break;
		}
	}

}
