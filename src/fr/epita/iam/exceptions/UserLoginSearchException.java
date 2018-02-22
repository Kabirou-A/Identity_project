/**
 * 
 */
package fr.epita.iam.exceptions;

import fr.epita.iam.datamodel.UserLogin;
import fr.epita.logger.Logger;

/**
 * @author ADEBOWALE
 * this class will rise an exception message if something when wrong while search for a user
 */
public class UserLoginSearchException extends UserLoginDataException{
	
	private static final Logger LOGGER = new Logger(UserLoginSearchException.class);
	/**
	 * @param e
	 * @param address
	 * @construction  UserLoginSearchException(e , address)
	 */
	
	public UserLoginSearchException(Exception e, UserLogin userLogin) {
		super(e, userLogin);
	}

	@Override
	//this method the message when an error arise to inform of unsuccessful creation of User
	public String getMessage() {
		return "A problem occurred while searching that User : " + faultyUserLogin;
	}
}	
	
	
