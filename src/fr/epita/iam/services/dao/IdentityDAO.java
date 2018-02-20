/**
 * Ce fichier est la propriété de Thomas BROUSSARD
 * Code application :
 * Composant :
 */
package fr.epita.iam.services.dao;

import java.util.List;

import fr.epita.iam.datamodel.Identity;
import fr.epita.iam.exceptions.IdentityCreationException;
import fr.epita.iam.exceptions.IdentityDeleteException;
import fr.epita.iam.exceptions.IdentitySearchException;
import fr.epita.iam.exceptions.IdentityUpdateException;

/**
 * <h3>interface IdentityDAO</h3>
 * <p>This class allows to describe different behavior to manage the Identity object.</p>
 *
 * <h3>Usage of IdentityDAO</h3>
 * <p>This class should be used as follows:
 *  Define create method 
 *   <pre><code>$void create(Identity identity);</code></pre>
 *  Define search method
 *  <pre><code>$void search(Identity identity);</code></pre>
 *  Define update method
 *  <pre><code>$void update(Identity identity);</code></pre>
 *  Define delete method
 *  <pre><code>$void delete(Identity identity);</code></pre>
 *  Define select method
 *  <pre><code>$void select(Identity identity);</code></pre>
 *  Define an Integer with unique value for the all program and initiate it to zero ;
 * </p>
 *
 * @since $${version}
 * @see See also $${link}
 * @author ${user}
 *
 * ${tags}
 */
public interface IdentityDAO {

	public static final Integer number = 0;

	public void create(Identity identity) throws IdentityCreationException;

	public List<Identity> search(Identity criteria) throws IdentitySearchException;

	public void update(Identity identity)throws IdentityUpdateException;

	public void delete(Identity identity) throws IdentityDeleteException;
	
}
