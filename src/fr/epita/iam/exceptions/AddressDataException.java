/**
 * 
 */
package fr.epita.iam.exceptions;

import fr.epita.iam.datamodel.Address;


/**
 * @author ADEBOWALE
 *@ AddressDataException allow to inherit all methods of class Exception
 */
public class AddressDataException extends Exception{
	
	//@faultyAddress is an instance of Address available for all package to generate any exception related to Address CRUD operation  
	protected final Address faultyAddress;

	//@construction with parameters to inform about the Exception occur
	public AddressDataException(Exception cause, Address faultyAddress) {
		initCause(cause);
		this.faultyAddress = faultyAddress;
	}

}
