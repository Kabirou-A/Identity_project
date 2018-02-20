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
	/*
	* @param e
	* @param identity
	*/
public class AddressUpdateException extends AddressDataException{
	
	public AddressUpdateException(Exception e, Address address) {
		super(e, address);
	}

	@Override
	public String getMessage() {
		return "A problem occurred while update that Address : " + faultyAddress;
	}


}
