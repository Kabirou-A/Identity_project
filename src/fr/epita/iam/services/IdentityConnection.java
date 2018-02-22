package fr.epita.iam.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import fr.epita.iam.services.configuration.ConfigurationService;
import fr.epita.logger.Logger;

/*
*@author ADEBOWALE
* this Class IdentityConnection creates the connection to  Database parameters.
*/
public class IdentityConnection {
	
		private static final Logger LOGGER = new Logger(IdentityConnection.class);
	
		private static final String DB_HOST = "db.host";
		private static final String DB_PWD = "db.pwd";
		private static final String DB_USER = "db.user";
		
		/*
		 * this static bloc create an instance of IdentityConnection class when the program is loaded
		 */
		static {
			new IdentityConnection();
		}
		
		/*
		 * the method is an instance of java Connection Class to load the driver (Class.forName)
		 * pass the connection  parameters (URL, PASSWORD, USERNAME) 
		 * return the connection for the whole program
		 */
		 public static Connection getConnection() throws ClassNotFoundException, SQLException {
		 		
			final ConfigurationService confService = ConfigurationService.getInstance();
	
			final String url = confService.getConfigurationValue(DB_HOST);
			final String password = confService.getConfigurationValue(DB_PWD);
			final String username = confService.getConfigurationValue(DB_USER);
	
			Class.forName("org.apache.derby.jdbc.ClientDriver");
	
			final Connection connection = DriverManager.getConnection(url, username, password);
			
			return connection;
		}
		 
		private IdentityConnection() {
			 
			}
}
