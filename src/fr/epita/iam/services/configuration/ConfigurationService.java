/**
 * Ce fichier est la propriété de Kabirou ARINLOYE
 * Code application :
 * Composant :
 */
package fr.epita.iam.services.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * <h3>ConfigurationService</h3>
 * <p>This class allows to initialize the connection </p>
 * <h3>Usage of ConfigurationService</h3>
 * <p>This class should be used as follows:
 * <pre><code>ConfigurationService cService= ConfigurationService.getInstance();</code></pre>
 * </p>
 * @since 2018/02/22 version1.1
 * @author ADEBOWALE
 */
public class ConfigurationService {

	private Properties properties;

	private static ConfigurationService instance;

	private ConfigurationService(String filePathToConfiguration) {
		try {
			properties = new Properties();
			properties.load(new FileInputStream(new File(filePathToConfiguration)));
		} catch (final IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	} 
	/*
	 * ConfigurationService getInstance() method load the connection configuration file 
	 * 
	 */
	public static ConfigurationService getInstance() {
		if (instance == null) {
			instance = new ConfigurationService(System.getProperty("conf"));
		}
		return instance;
	}
	/*
	 * getConfigurationValue(String propertyKey) will to get the connection properties 
	 */
	public String getConfigurationValue(String propertyKey) {
		return properties.getProperty(propertyKey);
	}

}
