/**
 * 
 */
package fr.epita.iam.exceptions;

import fr.epita.iam.datamodel.Address;
import fr.epita.iam.datamodel.UserLogin;

/**
 * @author ADEBOWALE
 * UserLoginCreationException class will hand all exception while create login credentials 
 */
public class UserLoginCreationException extends UserLoginDataException {

	/**
	 * @param e
	 * @param address
	 * @construction 
	 */
	public UserLoginCreationException(Exception e, UserLogin userLogin) {
		super(e, userLogin);
	}

	@Override
	//this method the message when an error arise to inform of unsuccessful creation of User
	public String getMessage() {
		return "A problem occurred while creating that User : " + faultyUserLogin;
	}
}
