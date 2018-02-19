/**
 *
 * Code application :
 * Composant :
 */
package fr.epita.iam.datamodel;

/**
 * <h3>Class IDENTITY</p>
 * <p>This class allow to create one or many users and store they identities details such name, email, 
 * user identity reference(Uid)and user address ...
 * </p>
 *
 * <h3>USE</h3>
 * <p>Each instance of the Object Identity will be use as follow:
 * We have different construction to achieve specific feature of the class
 * @First construction does't take any parameter and will allow to set each state of Identity.
 *   <pre><code>Identity instance = new Identity();</code></pre>
 * @Second construction take as parameter all the attribute of Identity to create or retrieve record in database table
 * 	 <pre><code>Identity instance = new Identity(Uid, Email, Display_Name );</code></pre>
 * @Third construction take Uid as parameter and we will use it to delete an Identity from the database
 * We encapsulated each attribute of Identity with key private and used getters and setters methods to manipulate them.
 * @toString: We had override the toString method to print on console Identity attributes and their values .   
 *  
 * </p>
 *
 * @since $${version I - 1 / 02 / 2018}
 * @see Voir aussi $${link}
 * @author ${KABIROU AND LAKSHARD}
 *
 * ${tags}
 */

	/*
	 * create Identity class 
	 * 
	 * 
	 */
public class Identity {

	private String displayName;
	private String uid;
	private String email;

	/**
	 * First constructor with default parameter
	 */
	public Identity() {

	}
	
	

	/**
	 * Second constructor with all the attributes of Identity object
	 * @param displayName
	 * @param uid
	 * @param email
	 */
	public Identity( String uid, String email,String displayName) {
		this.displayName = displayName;
		this.uid = uid;
		this.email = email;
	}
	/**
	 * Third construction with one parameter User Identity, use to look at a row of Identity table 
	 * @param uid
	 * 
	 */
	
	public Identity(String uid) {
		this.uid = uid;

	}
	/**
	 * getDisplayName() is used to access the value of Identity name. When this method is called, 
	 * it should return value of the attribute Display_Name.
	 * @return the displayName
	 * 
	 */
	public String getDisplayName() {
		return displayName;
	}
	/**
	 * setDisplayName(String displayName) is used to set the value of Identity name. When this method is called, 
	 * it should change the value of DisplayName with the value of the parameter String.
	 * @param displayName the displayName to set
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	/**
	 * getUid() is used to access the value of User Identity . When this method is called, 
	 * it should return value of the attribute Uid.
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}
	/**
	 * setUid(String uid) is used to set the value of User Identity . When this method is called, 
	 * it should change the value of Uid with the value of the parameter String.
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}
	/**
	 * getEmail() is used to access the value of Identity email address. When this method is called, 
	 * it should return value of the attribute Email.
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * setEmail(String email) is used to set the value of Identity email address. When this method is called, 
	 * it should change the value of Email with the value of the parameter String.
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Identity [uid=" + uid + ", email=" + email + ", displayName=" + displayName + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (displayName == null ? 0 : displayName.hashCode());
		result = prime * result + (email == null ? 0 : email.hashCode());
		result = prime * result + (uid == null ? 0 : uid.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Identity other = (Identity) obj;
		if (displayName == null) {
			if (other.displayName != null) {
				return false;
			}
		} else if (!displayName.equals(other.displayName)) {
			return false;
		}
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (uid == null) {
			if (other.uid != null) {
				return false;
			}
		} else if (!uid.equals(other.uid)) {
			return false;
		}
		return true;
	}




}
