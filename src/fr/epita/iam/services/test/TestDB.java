/**
 * 
 */
package fr.epita.iam.services.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.epita.iam.datamodel.Address;
import fr.epita.iam.datamodel.Identity;
import fr.epita.iam.datamodel.UserLogin;
import fr.epita.iam.exceptions.AddressCreationException;
//import fr.epita.iam.datamodel.Identity;
import fr.epita.iam.exceptions.IdentityCreationException;
import fr.epita.iam.exceptions.IdentityDeleteException;
import fr.epita.iam.exceptions.IdentitySearchException;
import fr.epita.iam.exceptions.IdentityUpdateException;
import fr.epita.iam.exceptions.UserLoginCreationException;
import fr.epita.iam.exceptions.UserLoginSearchException;
import fr.epita.iam.services.MenuService;
import fr.epita.iam.services.dao.AddressDAO;
import fr.epita.iam.services.dao.AddressJDBCDAO;
//import fr.epita.iam.exceptions.IdentitySearchException;
import fr.epita.iam.services.dao.IdentityDAO;
import fr.epita.iam.services.dao.IdentityJDBCDAO;
import fr.epita.iam.services.dao.UserLoginJDBCDAO;
import fr.epita.logger.Logger;

/**
 * @author ADEBOWALE
 *
 */
public class TestDB {

	private static final Logger LOGGER = new Logger(TestDB.class);

	/**
	 * <h3>Description</h3>
	 * <p>
	 * This methods allows to ...
	 * </p>
	 *
	 * <h3>Usage</h3>
	 * <p>
	 * It should be used as follows :
	 *
	 * <pre>
	 * <code> ${enclosing_type} sample;
	 *
	 * //...
	 *
	 * sample.${enclosing_method}();
	 *</code>
	 * </pre>
	 * </p>
	 *
	 * @since $${version}
	 * @see Voir aussi $${link}
	 * @author ${user}
	 *
	 *         ${tags}
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IdentityCreationException
	 * @throws IdentityDeleteException 
	 * @throws IdentitySearchException 
	 */
	private static Scanner keyboard = new Scanner( System.in );
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IdentityCreationException, IdentityDeleteException {
		
		
		 /** test UserLOgin class		 
				UserLogin userLogin = new UserLogin();
				UserLoginJDBCDAO userDao = new UserLoginJDBCDAO();
				
				System.out.println("Enter UserName");
				userLogin.setUserName(keyboard.nextLine());
				System.out.println("Enter PassWord");
				userLogin.setPassWord(keyboard.nextLine());
				
				try {
					//userDao.searchUserLogin(userLogin);
				} catch (UserLoginSearchException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally{
					keyboard.close();
					
				}
		*/
		
		// test MenuService class
		final MenuService menuService = new MenuService();
		menuService.mainMenuOption();
		
	}




	
	
	
}