/**
 * 
 */
package fr.epita.iam.exceptions;


import fr.epita.iam.datamodel.UserLogin;

/**
 * @author ADEBOWALE
 *UserLoginDataException allow to inherit all methods of class Exception
 *
 */
public class UserLoginDataException extends Exception{
	
	//@faultyLongin is an instance of User available for all package to generate any exception related to UserLogin CRUD operations  
		protected final UserLogin faultyUserLogin;

		//@construction with parameters to inform about the Exception occur
		public UserLoginDataException(Exception cause, UserLogin faultyUserLogin) {
			initCause(cause);
			this.faultyUserLogin = faultyUserLogin;
		}

}
