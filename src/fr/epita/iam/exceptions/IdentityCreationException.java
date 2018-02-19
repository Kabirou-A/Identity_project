/**
 * Ce fichier est la propriété de ADEBOWALE
 * Code application :
 * Composant :
 */
package fr.epita.iam.exceptions;

import fr.epita.iam.datamodel.Identity;

/**
 * <h3>class IdentityCreationException</h3>
 * <p>This class allows to inherit all the properties and methods of IdentityDataException class...</p>
 *
 * <h3>Usage of IdentityCreationException</h3>
 * <p>This class should be used as follows:
 * handle any exception that occur during the creation of an Identity
 * Notify the user that of an unsuccessful new Identity insertion in the database
 * 
 *   <pre><code>${type_name} instance = new ${type_name}();</code></pre>
 * </p>
 *
 * @since $${version}
 * @see See also $${link}
 * @author ${user}
 *
 * ${tags}
 */
public class IdentityCreationException extends IdentityDataException {

	/**
	 * @param e
	 * @param identity
	 */
	public IdentityCreationException(Exception e, Identity identity) {
		super(e, identity);
	}

	@Override
	public String getMessage() {
		return "A problem occurred while creating that Identity : " + faultyIdentity;
	}

}
