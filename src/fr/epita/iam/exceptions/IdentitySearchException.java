/**
 * Ce fichier est la propriété de Thomas BROUSSARD
 * Code application :
 * Composant :
 */
package fr.epita.iam.exceptions;

import fr.epita.iam.datamodel.Identity;

/**

 * <h3>class IdentitySearchException</h3>
 * <p>This class allows to inherit all the properties and methods of IdentityDataException class...</p>
 *
 * <h3>Usage of IdentitySearchException</h3>
 * <p>This class should be used as follows:
 * handle any exception that occur while search  an Identity
 * Notify the user that of an unsuccessful of search query  
 * @since $${version}
 * @see See also $${link}
 * @author ${user}
 *
 * ${tags}
 */
public class IdentitySearchException extends IdentityDataException {

	/**
	 * @param cause
	 * @param faultyIdentity
	 */
	public IdentitySearchException(Exception cause, Identity faultyIdentity) {
		super(cause, faultyIdentity);
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
		return "a problem occured while searching identities with that criteria : " + faultyIdentity;
	}
}
