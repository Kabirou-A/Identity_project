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
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((personContact == null) ? 0 : personContact.hashCode());
		result = prime * result + ((personDateOfBirth == null) ? 0 : personDateOfBirth.hashCode());
		result = prime * result + ((personName == null) ? 0 : personName.hashCode());
		result = prime * result + ((personSurname == null) ? 0 : personSurname.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (personContact == null) {
			if (other.personContact != null)
				return false;
		} else if (!personContact.equals(other.personContact))
			return false;
		if (personDateOfBirth == null) {
			if (other.personDateOfBirth != null)
				return false;
		} else if (!personDateOfBirth.equals(other.personDateOfBirth))
			return false;
		if (personName == null) {
			if (other.personName != null)
				return false;
		} else if (!personName.equals(other.personName))
			return false;
		if (personSurname == null) {
			if (other.personSurname != null)
				return false;
		} else if (!personSurname.equals(other.personSurname))
			return false;
		return true;
	}

}
