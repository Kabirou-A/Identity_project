/**
 * @author ADEBOWALE
 *@initializedConnectionServices() to set Database parameters on request
 */
package fr.epita.iam.services;

import fr.epita.iam.services.configuration.ConfigurationService;
import fr.epita.logger.Logger;

public class ConnectionService {
	
	private static final Logger LOGGER = new Logger(ConnectionService.class);
	
	/* This static bloc will allow an instance of ConnectionService Class to be load 
	 * when the file_path is load.
	*/
	static {
		new ConnectionService();
	}
	
	/*Initiate an instance of ConfigurationService() 
	* and pass the connection parameters
	*/
	public static void initializedConnectionServices() {
		
		// load the configuration thanks to the configuration service
		
		ConfigurationService cService= ConfigurationService.getInstance();
		
		cService.getConfigurationValue("db.host");
		cService.getConfigurationValue("db.user");
		cService.getConfigurationValue("db.pwd");
		cService.getConfigurationValue("file.path");
	}
	private ConnectionService() {
		
	}
}
