/**
 * 
 */
package fr.epita.iam.services.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.epita.iam.datamodel.Address;

import fr.epita.iam.exceptions.AddressCreationException;
import fr.epita.iam.exceptions.AddressDeleteException;
import fr.epita.iam.exceptions.AddressSearchException;
import fr.epita.iam.exceptions.AddressUpdateException;
import fr.epita.iam.exceptions.IdentityDeleteException;
import fr.epita.iam.exceptions.IdentitySearchException;
import fr.epita.iam.exceptions.IdentityUpdateException;
import fr.epita.logger.Logger;

/**
 * @author ADEBOWALE
 *
 */
public class AddressJDBCDAO implements AddressDAO{
	
	private static final Logger LOGGER = new Logger(AddressJDBCDAO.class);

	@Override
	public void createAddress(Address address) throws AddressCreationException {
		
		LOGGER.info("creating that address" + address);
		Connection connection = null;
		try {
			
			String insertaddress = "INSERT INTO ADDRESS(ADDRESSNAME, OCCUPATION, STREETNAME, STATEAREADISTRICT, CITYTOWNVILLAGE, PROVINCE, POSTALCODE, COUNTRY) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			if (insertaddress!=null) {
				
				connection=getConnection();
				
			final PreparedStatement pstmt = connection.prepareStatement(insertaddress);
			//make sure that all attribute of address instance are set to avoid null value in the database...
				if(address.getAddressName() != null && address.getOccupation()!= null 
						&& address.getStreetName()!= null && address.getStateAreaDistrict()!= null
						&& address.getCityTownVillage()!= null && address.getProvince()!= null
						&& address.getPostalCode()!= null && address.getCountry()!= null) {
					
					pstmt.setString(1, address.getAddressName());
					pstmt.setString(2, address.getOccupation());
					pstmt.setString(3, address.getStreetName());
					pstmt.setString(4, address.getStateAreaDistrict());				
					pstmt.setString(5, address.getCityTownVillage());
					pstmt.setString(6, address.getProvince());
					pstmt.setString(7, address.getPostalCode());
					pstmt.setString(8, address.getCountry());
					
					pstmt.execute();
					System.out.println(" new address with " + address.getAddressName() + " Address  was successfull created ");
				}
				else {
					System.out.println(" Please provide states of your new address");
				}
					
			
			}
			
		} 
		catch (final Exception e) {
	 		// TODO: handle exception
			LOGGER.error("error while creating the address " + address + "got that error " + e.getMessage());
			throw new AddressCreationException(e, address);
			
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
	public List<Address> searchAddress(Address criteria) throws AddressSearchException {

		final List<Address> results = new ArrayList<>();
		
		final Address currentAddress = new Address();
		// boolean is true will confirm that the Address search is in the database.
		// A mean to insure that search method iterate all the field in ADDRESS table
		boolean num = false;
		
		Connection connection = null;
		try {
			connection = getConnection();
			final String sqlSearchAddress = "SELECT ADDRESSNAME, OCCUPATION, STREETNAME, "
					+ "STATEAREADISTRICT, CITYTOWNVILLAGE, PROVINCE, POSTALCODE, "
					+ "COUNTRY FROM ADDRESS " 
					+ "WHERE (? IS NULL OR ADDRESSNAME LIKE ?) "
					+ "AND (? IS NULL OR OCCUPATION LIKE ?) " 
					+ "AND (? IS NULL OR STREETNAME LIKE ?)"
					+ "AND (? IS NULL OR STATEAREADISTRICT LIKE ?) " 
					+ "AND (? IS NULL OR CITYTOWNVILLAGE LIKE ?)"
					+ "AND (? IS NULL OR PROVINCE LIKE ?) " 
					+ "AND (? IS NULL OR POSTALCODE LIKE ?)"
					+ "AND (? IS NULL OR COUNTRY = ?)";
			
			final PreparedStatement preparedStatement = connection.prepareStatement(
					sqlSearchAddress);
			
					preparedStatement.setString(1, criteria.getAddressName());
					preparedStatement.setString(2, criteria.getAddressName() + "%");
					
					preparedStatement.setString(3, criteria.getOccupation());
					preparedStatement.setString(4, criteria.getOccupation() + "%");
					
					preparedStatement.setString(5, criteria.getStreetName());
					preparedStatement.setString(6, criteria.getStreetName() + "%");
					
					preparedStatement.setString(7, criteria.getStateAreaDistrict());
					preparedStatement.setString(8, criteria.getStateAreaDistrict() + "%");
					
					preparedStatement.setString(9, criteria.getCityTownVillage());
					preparedStatement.setString(10, criteria.getCityTownVillage() + "%");
					
					preparedStatement.setString(11, criteria.getProvince());
					preparedStatement.setString(12, criteria.getProvince() + "%");
					
					preparedStatement.setString(13, criteria.getPostalCode());
					preparedStatement.setString(14, criteria.getPostalCode() + "%");
					
					preparedStatement.setString(15, criteria.getCountry());
					preparedStatement.setString(16, criteria.getCountry());

			final ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				
				// How to select the right index?
				currentAddress.setAddressName(rs.getString("ADDRESSNAME"));
				currentAddress.setOccupation(rs.getString("OCCUPATION"));
				currentAddress.setStreetName(rs.getString("STREETNAME"));
				currentAddress.setStateAreaDistrict(rs.getString("STATEAREADISTRICT"));
				currentAddress.setCityTownVillage(rs.getString("CITYTOWNVILLAGE"));
				currentAddress.setProvince(rs.getString("PROVINCE"));
				currentAddress.setPostalCode(rs.getString("POSTALCODE"));
				currentAddress.setCountry(rs.getString("COUNTRY"));
								
				num = results.add(currentAddress);
								
			}
			if (num == true) {
				System.out.println(" the table contain the address you are looking for!!!");
			}
			else {
				System.out.println(" the Address you are looking for is not in the table!!!");
			}
			rs.close();
		} catch (ClassNotFoundException | SQLException e) {
			LOGGER.error("error while performing search", e);
			throw new AddressSearchException(e, criteria);
		} finally {
			try {
				connection.close();
			} catch (final SQLException e) {
				e.printStackTrace();
			}
		}

		return results;
		
	}

	@Override
	public void updateAddress(Address address) throws AddressUpdateException {

		Connection connection = null;
		String sqlUpdateAddress = "UPDATE ADDRESS SET OCCUPATION=?,  "
				+ "STREETNAME=?, STATEAREADISTRICT=?, CITYTOWNVILLAGE=?, "
				+ "PROVINCE=?, POSTALCODE=?, COUNTRY=? WHERE ADDRESSNAME = ?";
		
		
		final PreparedStatement pstmt;
		
		try {
			connection = getConnection();
				if (sqlUpdateAddress!=null) {
					pstmt = connection.prepareStatement(sqlUpdateAddress);
					
					pstmt.setString(1, address.getOccupation());
					pstmt.setString(2, address.getStreetName());
					pstmt.setString(3, address.getStateAreaDistrict());				
					pstmt.setString(4, address.getCityTownVillage());
					pstmt.setString(5, address.getProvince());
					pstmt.setString(6, address.getPostalCode());
					pstmt.setString(7, address.getCountry());
					
					
					// execute update SQL statement
					int rowUpdate = pstmt.executeUpdate();
					if (rowUpdate > 0) {
						
						System.out.println("Record is updated to ADDRESS table!");
					}
					else {
						
					}
				}
		}
		catch (final Exception e) {
	 		// TODO: handle exception
			LOGGER.error("error while updating the identity " + address + "got that error " + e.getMessage());
			
			e.printStackTrace();
			
			throw new AddressUpdateException(e, address);

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
	public void deleteAddress(Address address) throws AddressDeleteException {
		
		LOGGER.info("delete a row from ADDRESS table" + address);
		
		Connection connection = null;
		try {
				connection = getConnection();
			
				final PreparedStatement pstmt;
				
				int numberOfAddressDelete;
				
				String deleteAddress = "DELETE FROM ADDRESS WHERE ADDRESSNAME = ?";
				
				//test and see
			
				pstmt = connection.prepareStatement(deleteAddress);
			
				 pstmt.setString(1, address.getAddressName());
				 
				// execute delete SQL statement and store the number of row delete in numberOfAddressDelete integer
				 numberOfAddressDelete = pstmt.executeUpdate();
				 
								 
				// we will try to print to GUI the following message
				 if(numberOfAddressDelete == 0) {
					 System.out.println("There is no record with User Address number " + address.getAddressName() + " in ADDRESS table  ");
				 }
				 else {
					 System.out.println(numberOfAddressDelete + " rows deleted from the ADDRESS table!");
				 }
			
				
				
			
		} 
		catch (final Exception e) {
				// TODO: handle exception
				LOGGER.error("error while delete the identity " + address + "got that error " + e.getMessage());
				throw new AddressDeleteException(e, address);

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

}
