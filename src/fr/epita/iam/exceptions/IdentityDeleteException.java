package fr.epita.iam.exceptions;

import fr.epita.iam.datamodel.Identity;

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
		return "A problem occurred while creating that Identity : " + faultyIdentity;
	}

}
