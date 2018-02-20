/**
 * 
 */
package fr.epita.iam.exceptions;

import fr.epita.iam.datamodel.Address;


/**
 * @author ADEBOWALE
 *
 */
public class AddressSearchException extends AddressDataException{
	/**
	 * @param cause
	 * @param faultyAddress
	 */
	public AddressSearchException(Exception cause, Address faultyAddress) {
		super(cause, faultyAddress);
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	@Override
	public String getMessage() {
		return "a problem occured while searching address with that criteria : " + faultyAddress;
	}

}
