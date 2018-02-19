package fr.epita.iam.exceptions;

import fr.epita.iam.datamodel.Identity;

public class IdentityUpdateException extends IdentityDataException {

	/**
	 * <h3>class IdentityUpdateException</h3>
	 * <p>This class allows to inherit all the properties and methods of IdentityDataException class...</p>
	 *
	 * <h3>Usage of IdentityUpdateException</h3>
	 * <p>This class should be used as follows:
	 * handle any exception that rise while update one or more  Identities
	 * Notify the user that of an unsuccessful of query to update the Identity field
	 * 
	 * @param e
	 * @param identity
	 */
	public IdentityUpdateException(Exception e, Identity identity) {
		super(e, identity);
	}

	@Override
	public String getMessage() {
		return "A problem occurred while creating that Identity : " + faultyIdentity;
	}

}
