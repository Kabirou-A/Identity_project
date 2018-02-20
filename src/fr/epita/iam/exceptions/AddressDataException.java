/**
 * 
 */
package fr.epita.iam.exceptions;

import fr.epita.iam.datamodel.Address;


/**
 * @author ADEBOWALE
 *
 */
public class AddressDataException extends Exception{
	
	protected final Address faultyAddress;


	public AddressDataException(Exception cause, Address faultyAddress) {
		initCause(cause);
		this.faultyAddress = faultyAddress;
	}

}
