/**
 * 
 */
package fr.epita.iam.services.dao;


import java.util.List;

import fr.epita.iam.datamodel.UserLogin;
import fr.epita.iam.exceptions.UserLoginCreationException;
import fr.epita.iam.exceptions.UserLoginSearchException;

/**
 * @author ADEBOWALE
 *
 */
public interface UserLoginDAO {
	
	public static final Integer number = 0;

	public void createUserLogin(UserLogin userLogin) throws UserLoginCreationException;
	
	public List<UserLogin> searchUserLogin(UserLogin criteria) throws UserLoginSearchException;


}
