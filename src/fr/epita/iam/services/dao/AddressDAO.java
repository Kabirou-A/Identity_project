/**
 * 
 */
package fr.epita.iam.services.dao;

import java.util.List;

import fr.epita.iam.datamodel.Address;
import fr.epita.iam.exceptions.AddressCreationException;
import fr.epita.iam.exceptions.AddressDeleteException;
import fr.epita.iam.exceptions.AddressSearchException;
import fr.epita.iam.exceptions.AddressUpdateException;

/**
 * @author ADEBOWALE
 *
 */
public interface AddressDAO {
	
	public static final Integer number = 0;

	public void createAddress(Address address) throws AddressCreationException;

	public List<Address> searchAddress(Address criteria) throws AddressSearchException;

	public void updateAddress(Address address)throws AddressUpdateException;

	public void deleteAddress(Address address) throws AddressDeleteException;

}
