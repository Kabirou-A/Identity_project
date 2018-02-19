package fr.epita.iam.exceptions;

import fr.epita.iam.datamodel.Identity;

/*
 * <h3>class IdentityDeleteException</h3>
 * <p>This class allows to inherit all the properties and methods of IdentityDataException class...</p>
 *
 * <h3>Usage of IdentityDeleteException</h3>
 * <p>This class should be used as follows:
 * handle any exception that rise while deleting  an Identity
 * Notify the user that of an unsuccessful of query to delete an Identity
 */

public class IdentityDeleteException extends IdentityDataException {

	/**
	 * @param e
	 * @param identity
	 */
	public IdentityDeleteException(Exception e, Identity identity) {
		super(e, identity);
	}

	@Override
	public String getMessage() {
		return "A problem occurred while deleting an Identity : " + faultyIdentity;
	}

}
