/**
 * 
 */
package fr.epita.iam.datamodel;

/**
 * @author ADEBOWALE
 *
 */
public class UserLogin extends Person{
	
	private String userName;
	private String passWord;
	
	/*
	 * @UserLogin default construction
	 */
	public UserLogin() {
		
	}
	/*
	 * @UserLogin construction with two parameters
	 */
	public UserLogin(String userName, String passWord) {
		
		this.setUserName(userName);
		this.setPassWord(passWord);
		
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the passWord
	 */
	public String getPassWord() {
		return passWord;
	}
	/**
	 * @param passWord the passWord to set
	 */
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	

}
