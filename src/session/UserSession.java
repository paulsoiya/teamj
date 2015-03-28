package session;

/**
 * Used to keep track of the important session related data
 * @author Paul Soiya II
 * @version March 28, 2015
 */
public class UserSession {

	private int userId;
	private String userEmail;
	private static final int INVALID_ID_VALUE = -1;
	
	public UserSession() { 
		//set the default value of userId to the invalid value
		this.userId = INVALID_ID_VALUE;
		
	}
	
	public UserSession(int userId, String userEmail){
		this.userId = userId;
		this.userEmail = userEmail;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
}
