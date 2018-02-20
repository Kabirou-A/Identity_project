/**
 * 
 */
package fr.epita.iam.exceptions;

import fr.epita.iam.datamodel.Address;


/**
 * @author ADEBOWALE
 *
 */
public class AddressDeleteException extends AddressDataException{/**
	 * @param e
	 * @param identity
	 */
	public AddressDeleteException(Exception e, Address address) {
		super(e, address);
	}

	@Override
	public String getMessage() {
		return "A problem occurred while deleting an Address : " + faultyAddress;
	}

}
