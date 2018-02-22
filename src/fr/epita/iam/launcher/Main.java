/**
 *
 * Code application : Composant :
 */
package fr.epita.iam.launcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import fr.epita.iam.datamodel.Address;
import fr.epita.iam.datamodel.Identity;
import fr.epita.iam.exceptions.AddressCreationException;
import fr.epita.iam.exceptions.IdentityCreationException;
import fr.epita.iam.exceptions.UserLoginSearchException;
import fr.epita.iam.services.ConnectionService;
import fr.epita.iam.services.VerifyUserLogin;
import fr.epita.iam.services.configuration.ConfigurationService;
import fr.epita.iam.services.dao.AddressJDBCDAO;
import fr.epita.iam.services.dao.IdentityJDBCDAO;

/**
 * <h3>Description</h3>
 * <p>
 * Cette classe permet de ...
 * </p>
 *
 * <h3>Utilisation</h3>
 * <p>
 * Elle s'utilise de la manière suivante :
 *
 * <pre>
 * <code>${type_name} instance = new ${type_name}();</code>
 * </pre>
 * </p>
 *
 * @since $${version}
 * @see Voir aussi $${link}
 * @author ${user}
 *
 *         ${tags}
 */
public class Main {

	/**
	 * <h3>Description</h3>
	 * <p>
	 * This method allows to launch the program
	 * </p>
	 *
	 * <h3>Utilisation</h3>
	 * <p>
	 * The first argument is the file path to the configuration file
	 * </p>
	 * <p>
	 *
	 * <pre>
	 * <code>
	 * java -Dconf=${configLocation} -jar ${jarName}
	 *</code>
	 * </pre>
	 * </p>
	 *
	 * @since $${version}
	 * @see Voir aussi $${link}
	 * @author ${user}
	 *
	 *         ${tags}
	 */
	public static void main(String[] args) {
		final ConnectionService connect = null;
		final String confFileLocation = args[0];
		if (confFileLocation == null || confFileLocation.isEmpty()) {
			// no configuration, trying default
			System.out.println("no configuration file argument");
		} 
		else {
			connect.initializedConnectionServices();
			System.out.println("connection is available on request!!!");
		}
		VerifyUserLogin verifyUser = new VerifyUserLogin();
		try {
			verifyUser.userCredential();
		} catch (UserLoginSearchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
