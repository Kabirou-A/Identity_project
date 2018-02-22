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
public class MenuService {
	private static final Logger LOGGER = new Logger(MenuService.class);
	

	/*
	 * Default construction to create instance of MenuService object  
	 */
	public MenuService() {
		
	}
	
	/*
	 * create the main menu to perform CRUD operations
	 */
	public void mainMenu() {
		System.out.println("Welcome to IdentityApp !!!!!");
		System.out.println("Select : ");
		System.out.println("0 - to Exit IdentityApp");
		System.out.println("1 - to perform CRUD operations on  IDENTITIES table");
		System.out.println("2 - to perform CRUD operations on  ADDRESS table");	
	}
	
	/*
	 * IdentityMenu() method to perform CRUD operations on  IDENTITIES table
	 */
	public void IdentityMenu() {
		System.out.println("Select : ");
		System.out.println("C - to create an Identity");
		System.out.println("R - to search an Identity");
		System.out.println("U - to update an Identity");	
		System.out.println("D - to delete an Identity");
		System.out.println("3 - to getback to main menu");
		System.out.println("0 - to Exit IdentityApp");
		
		Scanner keyboard = new Scanner( System.in );
		String input = keyboard.nextLine().toLowerCase();
		
		while(input != "0"){
			
			 switch(input){
	         case "0" : System.out.println("You close the App"); System.exit(0);
	            break;
	         
	         case "c": 
	        	 Identity identityC = new Identity();
	        	 System.out.println("Input Identity name");
	        	 identityC.setDisplayName(keyboard.nextLine());
	        	 System.out.println("Input Identity email");
	        	 identityC.setEmail(keyboard.nextLine());
	        	 System.out.println("Input Identity user id");
	        	 identityC.setUid(keyboard.nextLine());
	        	 	        	 
	        	 try {
					new IdentityJDBCDAO().create(identityC);
				} catch (IdentityCreationException e) {
					e.printStackTrace();
				}
	        	IdentityMenu();
	            break;
	            
	         case "r" : 
	        	 Identity identityR = new Identity();
	        	 System.out.println("Input Identity details you are searching (display or email or uid)!!!");
	        	 identityR.setDisplayName(keyboard.nextLine());
	        	 
	        	 try {
						new IdentityJDBCDAO().search(identityR);
					} catch (IdentitySearchException e) {
						e.printStackTrace();
					
					}
	        	 IdentityMenu();
	         	break;
	         
	         case "u" :
	        	 Identity identityU = new Identity();
	        	 System.out.println("Input the Identity name you want to update");
	        	 identityU.setDisplayName(keyboard.nextLine());
	        	 System.out.println("Input the Identity email you want to update");
	        	 identityU.setEmail(keyboard.nextLine());
	        	 System.out.println("Input the Identity user id you want to update");
	        	 identityU.setUid(keyboard.nextLine());
	        	 try {
						new IdentityJDBCDAO().update(identityU);
					} catch (IdentityUpdateException e) {
						e.printStackTrace();
					
					}
	        	 IdentityMenu();
	         	break;
	         case "d" : 
	        	 Identity identityD = new Identity();
	        	 System.out.println("Input the Identity User ID you want to delete!!!");
	        	 identityD.setUid(keyboard.nextLine());
	        	 try {
						new IdentityJDBCDAO().delete(identityD);
					} catch (IdentityDeleteException e) {
						e.printStackTrace();
					
					}
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
		System.out.println("Select : ");
		System.out.println("C - to create an Address");
		System.out.println("R - to search an Address");
		System.out.println("U - to update an Address");	
		System.out.println("D - to delete an Address");
		System.out.println("3 - to getback to main menu");
		System.out.println("0 - to Exit IdentityApp");
		
		
		Scanner keyboard = new Scanner( System.in );
		String input = keyboard.nextLine().toLowerCase();
		
		while(input != "0"){
			
			 switch(input){
	         case "0" : System.out.println("You close the App"); System.exit(0);
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
	            
	         default :System.out.println("Invalid selection"); mainMenuOption();
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
		
		mainMenu();
		
		String input = keyboard.nextLine();
		while(input != "0"){
			
			 switch(input){
	         case "0" : System.out.println("You close the App"); System.exit(0);
	            break;
	         
	         case "1" : IdentityMenu();
	            break;
	            
	         case "2" : AddressMenu();
	         	break;
	            
	         default :System.out.println("Invalid selection"); mainMenuOption();
	            break;	
	            
			 }
		 break;
		}
	}

}
