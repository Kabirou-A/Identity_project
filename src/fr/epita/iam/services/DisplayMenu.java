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

/**
 * @author ADEBOWALE
 * DisplayMenu class allow to display text of different menus option 
 */
public class DisplayMenu {
	
	Scanner keyboard = new Scanner( System.in );

	/**
	 * Default construction to allow all class in the package to inherit the methods of DisplayMenu 
	 */
	protected DisplayMenu() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * identityMenu() method display all option to operate on Identity class and get back to menu
	 */
	public void identityMenu() {
		
		System.out.println("Select : ");
		System.out.println("C - to create an Identity");
		System.out.println("R - to search an Identity");
		System.out.println("U - to update an Identity");	
		System.out.println("D - to delete an Identity");
		System.out.println("3 - to getback to main menu");
		System.out.println("0 - to Exit IdentityApp");
		
	}
	/*
	 * addressMenu() method display all option to operate on Address class and get back to menu
	 */
	public void addressMenu() {
		
		System.out.println("Select : ");
		System.out.println("C - to create an Address");
		System.out.println("R - to search an Address");
		System.out.println("U - to update an Address");	
		System.out.println("D - to delete an Address");
		System.out.println("3 - to getback to main menu");
		System.out.println("0 - to Exit IdentityApp");
		
	}
	/*
	 * firstMenu() method display three options to access Identity  and Address menus or to end the application.
	*/
	public void firstMenu() {
		System.out.println("Welcome to IdentityApp !!!!!");
		System.out.println("Select : ");
		System.out.println("0 - to Exit IdentityApp");
		System.out.println("1 - to perform CRUD operations on  IDENTITIES table");
		System.out.println("2 - to perform CRUD operations on  ADDRESS table");	
	}
	/*
	 * consoleCreateIdentity() method will request input from user to create Identity , store in the database and return the menu. 
	 */
	public void consoleCreateIdentity() {
		
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
	}
	/*
	 * consoleSearchIdentity() method will request input from user to search for Identity in the database, display the result and return the menu. 
	 */
	public void consoleSearchIdentity() {
		
		 Identity identityR = new Identity();
    	 System.out.println("Input Identity details you are searching (display or email or uid)!!!");
    	 identityR.setDisplayName(keyboard.nextLine());
    	 
    	 try {
				new IdentityJDBCDAO().search(identityR);
			} catch (IdentitySearchException e) {
				e.printStackTrace();
			
			}
	}
	/*
	 * consoleUpdateIdentity() method will request input from user to update for Identity in the database with the user id supply,  and return the menu. 
	 */
	public void consoleUpdateIdentity() {
		
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
	}
	/*
	 * consoleDeleteIdentity() method will request input from user to delete Identity in the database with the user id supply,  and return the menu. 
	 */
	public void consoleDeleteIdentity() {
		
		 Identity identityD = new Identity();
    	 System.out.println("Input the Identity User ID you want to delete!!!");
    	 identityD.setUid(keyboard.nextLine());
    	 try {
				new IdentityJDBCDAO().delete(identityD);
			} catch (IdentityDeleteException e) {
				e.printStackTrace();
			
			}
	}
	
	
}