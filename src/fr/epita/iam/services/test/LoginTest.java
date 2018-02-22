/**
 * 
 */
package fr.epita.iam.services.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author ADEBOWALE
 *
 */
public class LoginTest {

	// Create a single shared Scanner for keyboard input
    private static Scanner keyboard = new Scanner( System.in );
	

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			getInput();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	public static void getInput() throws SQLException{
		Connection con = null;
		
		int countTree = 0;
		boolean found = false;
		String tempUsername ="wale" ;
		String tempPassword ="123";
		
		if(countTree < 3) {System.out.println("Enter your login details : ");
		System.out.print("Enter your Username : ");	
		}
		while(countTree < 3 && keyboard.hasNextLine() ) {
            
            String username = keyboard.nextLine();
            System.out.println("");
            
            System.out.print("Enter your Password  : ");
	    	String password = keyboard.nextLine();
	    	
	    	countTree++;
	    	
	    	if(tempUsername.trim().equals(username.trim()) && 
					tempPassword.trim().equals(password.trim())){
		
				found = true;
            	System.out.println("Username: " + username + " Password " + password );

				System.out.println("Exit!");
                break;
	    	}
	    	else if(countTree <3) {
	    		System.out.println("Incorrect entries. Enter your login details again: ");
	    		System.out.print("Enter your Username : ");	
	    	}
	    	else {
	    		System.out.print("You have supplied wrong entries : " + countTree++ + " times. You are not allowed to use the system! Sorry contact the Admn" );	
	    	}  			        
        };
		keyboard.close();
		
			
		
		
	}
	
	
	

}
