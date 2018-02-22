/**
 * 
 */
package fr.epita.iam.exceptions;

import fr.epita.iam.datamodel.Address;
import fr.epita.iam.datamodel.Identity;
import fr.epita.iam.services.dao.AddressJDBCDAO;
import fr.epita.logger.Logger;

/**
 * @author ADEBOWALE
 * This a child of AddressDataExcetion to handle any exception that will rise while creating address object.
 */
public class AddressCreationException extends AddressDataException{
	
	private static final Logger LOGGER = new Logger(AddressCreationException.class);

	/**
	 * @param e
	 * @param address
	 * @construction 
	 */
	public AddressCreationException(Exception e, Address address) {
		super(e, address);
	}

	@Override
	//this method the message when an error arise to inform of unsuccessful creation of Address
	public String getMessage() {
		return "A problem occurred while creating that Address : " + faultyAddress;
	}

}
