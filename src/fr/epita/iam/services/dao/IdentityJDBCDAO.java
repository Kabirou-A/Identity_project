/**
 * Ce fichier est la propriété de ADEBOWALE Code application : Composant :
 */
package fr.epita.iam.services.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import fr.epita.iam.datamodel.Identity;
import fr.epita.iam.exceptions.IdentityCreationException;
import fr.epita.iam.exceptions.IdentityDeleteException;
import fr.epita.iam.exceptions.IdentitySearchException;
import fr.epita.iam.exceptions.IdentityUpdateException;
//import fr.epita.iam.services.configuration.ConfigurationService;
import fr.epita.logger.Logger;

/**
 * <h3>class IdendityJDBCDAO </h3>
 * <p>
 * This class allows to implement all methods of the interface IdentityDAO ...
 * </p>
 *
 * <h3>Usage of IdentityDDBCDAO</h3>
 * <p>
 * This class should be used as follows:
 * to create new record in IDENTIES table
 * * <pre>
 * <code> IdentityDDBCDAO daoInstance = new IdentityDDBCDAO();
 *         daoInstance.create(identity_Instance);
 * </code>
 * </pre>
 * to read all records of IDENTIES table
 * * <pre>
 * <code> IdentityDDBCDAO daoInstance = new IdentityDDBCDAO();
 *         daoInstance.select(identity_Instance);
 * </code>
 * </pre>
 * * to search for any field of IDENTIES table
 * * <pre>
 * <code> IdentityDDBCDAO daoInstance = new IdentityDDBCDAO();
 *         daoInstance.search(identity_Instance);
 * </code>
 * </pre>
 * * to update one or many fields of IDENTIES table
 * * <pre>
 * <code> IdentityDDBCDAO daoInstance = new IdentityDDBCDAO();
 *         daoInstance.update(identity_Instance);
 * </code>
 * </pre>
 * * to delete one or many fields of IDENTIES table
 * * <pre>
 * <code> IdentityDDBCDAO daoInstance = new IdentityDDBCDAO();
 *         daoInstance.delete(identity_Instance);
 * </code>
 * </pre>
 * </p>
 *
 * @since $${version}
 * @see See also $${link}
 * @author ${user}
 *
 *         ${tags}
 */
public class IdentityJDBCDAO implements IdentityDAO {


	private static final Logger LOGGER = new Logger(IdentityJDBCDAO.class);
	/**
	 *
	 */
	private static final String DB_HOST = "db.host";
	private static final String DB_PWD = "db.pwd";
	private static final String DB_USER = "db.user";

	/*
	 * (non-Javadoc)
	 * @see fr.epita.iam.services.dao.IdentityDAO#create(fr.epita.iam.datamodel.Identity)
	 */
	@Override
	public void create(Identity identity) throws IdentityCreationException {

		LOGGER.info("creating that identity" + identity);
		Connection connection = null;
		try {
			String insertIdentity = "INSERT INTO IDENTITIES(UID, EMAIL, DISPLAY_NAME) VALUES (?, ?, ?)";
			if (insertIdentity!=null) {
				
				connection=getConnection();
				
			final PreparedStatement pstmt = connection.prepareStatement(insertIdentity);
				if(identity.getUid() != null && identity.getEmail()!= null && identity.getDisplayName()!= null) {
					pstmt.setString(1, identity.getUid());
					pstmt.setString(2, identity.getEmail());
					pstmt.setString(3, identity.getDisplayName());
					pstmt.execute();
					System.out.println(" new Identity with " + identity.getUid() + " User number was successfull created ");
				}
				else {
					System.out.println(" Please provide states of your new Identity");
				}
					
			
			}
			
		} 
		catch (final Exception e) {
	 		// TODO: handle exception
			LOGGER.error("error while creating the identity " + identity + "got that error " + e.getMessage());
			throw new IdentityCreationException(e, identity);
			
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

	/*
	 * (non-Javadoc)
	 * @see fr.epita.iam.services.dao.IdentityDAO#search(fr.epita.iam.datamodel.Identity)
	 */
	@Override
	public List<Identity> search(Identity criteria) throws IdentitySearchException {

		final List<Identity> results = new ArrayList<>();
		
		final Identity currentIdentity = new Identity();
		// boolean is true will confirm that the Identity search is in the database.
		// A mean to insure that search method iterate all the field in IDENTITIES table
		boolean num = false;
		
		Connection connection = null;
		try {
			connection = getConnection();
			final String sqlString = "SELECT DISPLAY_NAME, EMAIL, UID FROM IDENTITIES " 
					+ "WHERE (? IS NULL OR DISPLAY_NAME LIKE ?) "
					+ "AND (? IS NULL OR EMAIL LIKE ?) " + "AND (? IS NULL OR UID = ?)";
			final PreparedStatement preparedStatement = connection.prepareStatement(
					sqlString);

			preparedStatement.setString(1, criteria.getDisplayName());
			preparedStatement.setString(2, criteria.getDisplayName() + "%");
			preparedStatement.setString(3, criteria.getEmail());
			preparedStatement.setString(4, criteria.getEmail() + "%");
			preparedStatement.setString(5, criteria.getUid());
			preparedStatement.setString(6, criteria.getUid());
			final ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				
				// How to select the right index?
				currentIdentity.setDisplayName(rs.getString("DISPLAY_NAME"));
				currentIdentity.setEmail(rs.getString("EMAIL"));
				currentIdentity.setUid(rs.getString("UID"));

				num = results.add(currentIdentity);
				
				
			}
			if (num == true) {
				System.out.println(" the table contain the person you are looking for!!!");
			}
			else {
				System.out.println(" the Identity you are looking for is not in the table!!!");
			}
			rs.close();
		} catch (ClassNotFoundException | SQLException e) {
			//LOGGER.error("error while performing search", e);
			throw new IdentitySearchException(e, criteria);
		} finally {
			try {
				connection.close();
			} catch (final SQLException e) {
				e.printStackTrace();
			}
		}

		return results;
	}
	
					

	/*
	 * (non-Javadoc)
	 * @see fr.epita.iam.services.dao.IdentityDAO#update(fr.epita.iam.datamodel.Identity)
	 */
	@Override
	public void update(Identity identity) throws IdentityUpdateException{
		Connection connection = null;
		
		String sqlUpdate = "UPDATE IDENTITIES SET EMAIL=?, DISPLAY_NAME=? WHERE UID = ?";
		
		final PreparedStatement pstmt;
		
		try {
			connection = getConnection();
				if (sqlUpdate!=null) {
					pstmt = connection.prepareStatement(sqlUpdate);
					pstmt.setString(1, identity.getEmail());
					pstmt.setString(2, identity.getDisplayName());
					pstmt.setString(3, identity.getUid());
					
					// execute update SQL statement
					int rowUpdate = pstmt.executeUpdate();
					if (rowUpdate > 0) {
						
						System.out.println("Record is updated to IDENTITIES table!");
					}
					else {
						
					}
				}
		}
		catch (final Exception e) {
	 		// TODO: handle exception
			LOGGER.error("error while updating the identity " + identity + "got that error " + e.getMessage());
			
			e.printStackTrace();
			
			throw new IdentityUpdateException(e, identity);

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

	/*
	 * (non-Javadoc)
	 * @see fr.epita.iam.services.dao.IdentityDAO#delete(fr.epita.iam.datamodel.Identity)
	 */
	@Override
	public void delete(Identity identity) throws IdentityDeleteException{
		
		LOGGER.info("delete a row from IDENTITY table" + identity);
		
		Connection connection = null;
		try {
				connection = getConnection();
			
				final PreparedStatement pstmt; 
				int numberIdentityDelete;
				String deleteIdentity = "DELETE FROM IDENTITIES WHERE UID = ?";
				
				//test and see
			
				pstmt = connection.prepareStatement(deleteIdentity);
			
				 pstmt.setString(1, identity.getUid());
				 
				// execute delete SQL statement and store the number of row delete in numberIdentityDelete integer
				 numberIdentityDelete = pstmt.executeUpdate();
				 
								 
				// we will try to print to GUI the following message
				 if(numberIdentityDelete == 0) {
					 System.out.println("There is no record with User Identity number " + identity.getUid() + " in IDENTITY table  ");
				 }
				 else {
					 System.out.println(numberIdentityDelete + " rows deleted from the IDENTTITIES table!");
				 }
			
				
				
			
		} 
		catch (final Exception e) {
				// TODO: handle exception
				LOGGER.error("error while delete the identity " + identity + "got that error " + e.getMessage());
				throw new IdentityDeleteException(e, identity);

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
	
	private static Connection getConnection() throws ClassNotFoundException, SQLException {
		final String url = "jdbc:derby://localhost:1527/IDENTITIES_DB;create=true";
		final String password = "root";
		final String username = "root";

		Class.forName("org.apache.derby.jdbc.ClientDriver");

		final Connection connection = DriverManager.getConnection(url, username, password);
		return connection;
	}

	
	/*
	 * private static Connection getConnection() throws ClassNotFoundException, SQLException {
	 
		// TODO make this variable through configuration

		final ConfigurationService confService = ConfigurationService.getInstance();

		final String url = confService.getConfigurationValue(DB_HOST);
		final String password = confService.getConfigurationValue(DB_PWD);
		final String username = confService.getConfigurationValue(DB_USER);

		Class.forName("org.apache.derby.jdbc.ClientDriver");

		final Connection connection = DriverManager.getConnection(url, username, password);
		return connection;
	}
	*/
	

}
