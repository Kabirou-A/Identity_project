/**
 * 
 */
package fr.epita.iam.services;

import java.util.Scanner;

import fr.epita.iam.datamodel.UserLogin;
import fr.epita.iam.exceptions.UserLoginSearchException;
import fr.epita.iam.services.dao.UserLoginJDBCDAO;
import fr.epita.logger.Logger;

/**
 * @author ADEBOWALE
 * this class will allow to verify the user credentials 
 * And allow users with correct credentials to get the Menu  
 */
public class VerifyUserLogin {
		
	
		private static final Logger LOGGER = new Logger(VerifyUserLogin.class);
	
		private static Scanner keyboard = new Scanner( System.in );
		final static UserLogin userLogin = new UserLogin();
		final static UserLoginJDBCDAO userDao = new UserLoginJDBCDAO();
		
		/*
		 * userCredential()
		 * This method will request credential input from user
		 */
		public static void userCredential() throws UserLoginSearchException {
			
			System.out.println("Enter UserName");
			userLogin.setUserName(keyboard.nextLine());
			
			System.out.println("Enter PassWord");
			userLogin.setPassWord(keyboard.nextLine());
			
			try {
				userDao.searchUserLogin(userLogin);
			}
			finally{
				keyboard.close();
				
			}
		}
		public VerifyUserLogin() {
			
		}
		
		

}
