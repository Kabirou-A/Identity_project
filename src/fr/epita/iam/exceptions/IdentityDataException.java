/**
 * Ce fichier est la propriété de Thomas BROUSSARD
 * Code application :
 * Composant :
 */
package fr.epita.iam.exceptions;

import fr.epita.iam.datamodel.Identity;

/**
 * <h3>Class IdentityDataException</h3>
 * <p>This class allows to inherit all methods and attributes of java Exception class ...</p>
 * <h3>Usage of IdentityDataException</h3>
 * <p>This class should be used as follows
 * declare on instance final of Identity 
 * declare one construction with two parameters
 *  It initiate the exception, print it and Identity that cause the exception  
 * </p>
 * @since $${version 1.1}
 * @author ${ADEBOWALE}
 * ${tags}
 */
public class IdentityDataException extends Exception {

	protected final Identity faultyIdentity;
	/*
	 *  @cause- an instance of Exception 
	 *  @faultyIdentity - an instance of Identity
	 */

	public IdentityDataException(Exception cause, Identity faultyIdentity) {
		initCause(cause);
		this.faultyIdentity = faultyIdentity;
	}
}
