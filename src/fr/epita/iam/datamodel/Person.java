/**
 * 
 */
package fr.epita.iam.datamodel;

/**
 * @author ADEBOWALE
 *
 */
public class Person {
	private String personName;
	private String personSurname;
	private String personDateOfBirth;
	private String personContact;
	
	/*
	 * @Person default construction
	 */
	 public Person() {
		
	}
	/*
	 * @Person construction with all attribute
	 */
	public Person(String personName, String personSurname, String personDateOfBirth, String personContact ) {
		this.personName = personName;
		this.personSurname = personSurname;
		this.personDateOfBirth = personDateOfBirth;
		this.personContact = personContact;
	}
	
	/**
	 * @return the personName
	 */
	public String getPersonName() {
		return personName;
	}
	/**
	 * @param personName the personName to set
	 */
	public void setPersonName(String personName) {
		personName = personName;
	}
	/**
	 * @return the personSurname
	 */
	public String getPersonSurname() {
		return personSurname;
	}
	/**
	 * @param personSurname the personSurname to set
	 */
	public void setPersonSurname(String personSurname) {
		personSurname = personSurname;
	}
	/**
	 * @return the personDateOfBirth
	 */
	public String getPersonDateOfBirth() {
		return personDateOfBirth;
	}
	/**
	 * @param personDateOfBirth the personDateOfBirth to set
	 */
	public void setPersonDateOfBirth(String personDateOfBirth) {
		personDateOfBirth = personDateOfBirth;
	}
	/**
	 * @return the personContact
	 */
	public String getPersonContact() {
		return personContact;
	}
	/**
	 * @param personContact the personContact to set
	 */
	public void setPersonContact(String personContact) {
		personContact = personContact;
	}

}
