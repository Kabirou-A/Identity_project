/**
 * 
 */
package fr.epita.iam.services.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.epita.iam.datamodel.Identity;
import fr.epita.iam.datamodel.UserLogin;
import fr.epita.iam.exceptions.IdentitySearchException;
import fr.epita.iam.exceptions.UserLoginCreationException;
import fr.epita.iam.exceptions.UserLoginSearchException;
import fr.epita.iam.services.IdentityConnection;
import fr.epita.iam.services.MenuService;
import fr.epita.iam.services.VerifyUserLogin;
import fr.epita.logger.Logger;

/**
 * @author ADEBOWALE
 *
 */
public class UserLoginJDBCDAO implements UserLoginDAO{
	private static final Logger LOGGER = new Logger(UserLoginJDBCDAO.class);
	final MenuService menuService = new MenuService();

	@Override
	public void createUserLogin(UserLogin userLogin) throws UserLoginCreationException {

		LOGGER.info("creating that user" + userLogin);
		Connection connection = null;
		try {
			String insertUser = "INSERT INTO USERLOGINS(USERNAME, PASSWORD) VALUES (?, ?)";
			if (insertUser!=null) {
				
				connection = IdentityConnection.getConnection();
				
			final PreparedStatement pstmt = connection.prepareStatement(insertUser);
				if(userLogin.getUserName() != null && userLogin.getPassWord()!= null ) {
					pstmt.setString(1, userLogin.getUserName());
					pstmt.setString(2, userLogin.getPassWord());
					
					pstmt.execute();
					System.out.println(" new User with " + userLogin.getUserName() + " User was successfull created ");
				}
				else {
					System.out.println(" Please provide login details of a new User");
				}
			}
		} 
		catch (final Exception e) {
	 		// TODO: handle exception
			LOGGER.error("error while creating the identity " + userLogin + "got that error " + e.getMessage());
			throw new UserLoginCreationException(e, userLogin);
		} 
		finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (final SQLException e) {
					// can do nothing here, except logging maybe?
				}
			}
		}
	}

	@Override
	public List<UserLogin> searchUserLogin(UserLogin criteria) throws UserLoginSearchException {
		

			final List<UserLogin> results = new ArrayList<>();
			
			final UserLogin currentUserLogin = new UserLogin();
			// boolean is true will confirm that the User searched is in the database.
			// A mean to insure that search method iterate all the field in USERLOGINS table
			boolean num = false;
			
			Connection connection = null;
			try {
				connection = IdentityConnection.getConnection();
				final String sqlString = "SELECT USERNAME, PASSWORD FROM USERLOGINS "
						+ "WHERE (? IS NULL OR USERNAME LIKE ?) " 
						+ "AND (? IS NULL OR PASSWORD = ?)";
						
						//+ "AND ( PASSWORD LIKE ?) " ;
				final PreparedStatement preparedStatement = connection.prepareStatement(
						sqlString);

				preparedStatement.setString(1, criteria.getUserName());
				preparedStatement.setString(2, criteria.getUserName() + "%");
				preparedStatement.setString(3, criteria.getPassWord());
				preparedStatement.setString(4, criteria.getPassWord() );
				
				final ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					
					// How to select the right index?
					currentUserLogin.setUserName(rs.getString("USERNAME"));
					currentUserLogin.setPassWord(rs.getString("PASSWORD"));
					

					num = results.add(currentUserLogin);
							
				}
				int count = 0;
				if (num == true) {
					System.out.println(" You are a registerd User !!!");
					menuService.mainMenuOption();
					System.out.println("Password= "+currentUserLogin.getPassWord()+" UserName= "+ currentUserLogin.getUserName());
				}
				else if(count < 3) {
					
					System.out.println(" the user you are looking for is not in the system, try again!!!");
					 //I need to fix line 
					  new VerifyUserLogin().userCredential();
					
					count++;
					System.out.println("count = "+ count);
				}
				else {
						System.out.println("You have enter more than "+ count +" times Username or Password");
						System.out.println("contact the Application Admnistrator!!!!");
						System.exit(0);
				}
				rs.close();
			} catch (ClassNotFoundException | SQLException e) {
				LOGGER.error("error while performing search", e);
				throw new UserLoginSearchException(e, criteria);
			} finally {
				try {
					connection.close();
				} catch (final SQLException e) {
					e.printStackTrace();
				}
			}
			
			return results;
		
	}
	
	
	

}
