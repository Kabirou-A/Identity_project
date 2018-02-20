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

import fr.epita.iam.datamodel.Address;
import fr.epita.iam.datamodel.Identity;
import fr.epita.iam.exceptions.AddressCreationException;
//import fr.epita.iam.datamodel.Identity;
import fr.epita.iam.exceptions.IdentityCreationException;
import fr.epita.iam.exceptions.IdentityDeleteException;
import fr.epita.iam.exceptions.IdentitySearchException;
import fr.epita.iam.exceptions.IdentityUpdateException;
import fr.epita.iam.services.dao.AddressDAO;
import fr.epita.iam.services.dao.AddressJDBCDAO;
//import fr.epita.iam.exceptions.IdentitySearchException;
import fr.epita.iam.services.dao.IdentityDAO;
import fr.epita.iam.services.dao.IdentityJDBCDAO;
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
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IdentityCreationException, IdentityDeleteException {
		
		// given
		Address address1 = new Address("ADDRESSNAME", "OCCUPATION", "STREETNAME", "STATEAREADISTRICT", "CITYTOWNVILLAGE", "PROVINCE", "POSTALCODE", "COUNTRY");
		final AddressDAO aDAO = new AddressJDBCDAO();
		
		try {
			aDAO.searchAddress(address1);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			   Identity identity1 = new Identity("99911", "sjunior@gmail.com", "junior");
				
				final IdentityDAO dao = new IdentityJDBCDAO();
				
				 Identity searchIdentity = new Identity("5010", "ssodiq@gmail.com", "Akambi");
				 dao.create(searchIdentity);
				 //dao.create(new Identity("40110", "ssodiq@gmail.com", "Akambi"));
				 
				Identity iddelete1 = new Identity();
				//iddelete.setUid("4011200");
				
				//identity1.setDisplayName("waleUpdate");
				//identity1.setEmail("adebowaledocallprog");
				 identity1.setUid("401");
				 //dao.create(iddelete1);
				
				 try {
					dao.search(searchIdentity);
				} catch (IdentitySearchException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 

				

				
						
						
						// c'est pas correcte.
						//tu as utiliser le method directement de IdentityJDBCDAO.
						
						//you are not supposed to write the whole method here again.
						//do you understand.
						// ok j'ai comprisc
						// how do I do it?
						// when I use update(identiy1) it was not compiling
				
				
						/*IdentityDAO dao1=new IdentityJDBCDAO();
						try {
							dao1.update(identity1);
						} catch (IdentityUpdateException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						*/
				
						//ok
						// merci beaucoup
						// that is great man
						// can you help me with delete method
						// i'm thing any to provide some UID string to the method but I don't how to get work
						//ok show.
						
						
					
		// testSelectQuery();

		// differenceBetweenPreparedStatementAndStatement();

		 //rawSelect();

		
		
	
	}




	/**
	 * <h3>Description</h3>
	 * <p>
	 * This methods allows to  test the database and the insertion query....
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
	 */
	private static void rawSelect() throws ClassNotFoundException, SQLException {
		// Given
		final Connection connection = getConnectionTest();
		final PreparedStatement pstmt = connection.prepareStatement("INSERT INTO IDENTITIES(UID, EMAIL, DISPLAY_NAME) VALUES (?, ?, ?)");
		pstmt.setString(1, "9999");
		pstmt.setString(2, "karinloye@gmail.com");
		pstmt.setString(3, "karinloye");

		// When
		pstmt.execute();

		// Then
		final PreparedStatement verificationStatement = connection
				.prepareStatement("SELECT DISPLAY_NAME FROM IDENTITIES WHERE DISPLAY_NAME='karinloye'");
		final ResultSet resultSet = verificationStatement.executeQuery();
		resultSet.next();
		if (resultSet.getString(1).equals("karinloye")) {
			System.out.println("Success");
		} else {
			System.out.println("Failure");
		}

		connection.close();
	}
	

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
	 */
	private static Connection getConnectionTest() throws ClassNotFoundException, SQLException {
		final String url = "jdbc:derby://localhost:1527/IDENTITIES_DB;create=true";
		final String password = "root";
		final String username = "root";

		Class.forName("org.apache.derby.jdbc.ClientDriver");

		final Connection connection = DriverManager.getConnection(url, username, password);
		return connection;
	}
	
	
	
	
}