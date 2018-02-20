/**
 * 
 */
package fr.epita.iam.exceptions;

import fr.epita.iam.datamodel.Address;
import fr.epita.iam.datamodel.Identity;

/**
 * @author ADEBOWALE
 *
 */
public class AddressCreationException extends AddressDataException{
	
	/**
	 * @param e
	 * @param address
	 */
	public AddressCreationException(Exception e, Address address) {
		super(e, address);
	}

	@Override
	public String getMessage() {
		return "A problem occurred while creating that Address : " + faultyAddress;
	}

}
