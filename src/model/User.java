package model;

public class User {
	//model usera i kilka konsturktorów, jest to odpowiednik tabeli na bazie "user_definition"
	private int userID;
	private String userName;
	private String userEmail;
	private int userStatus;
	private String userPassword;
	private int userRole;
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public int getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public int getUserRole() {
		return userRole;
	}
	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}

	public User (String userName, String userEmail, String userPassword,  int userRole) {
		setUserName(userName);
		setUserEmail(userEmail);
		setUserPassword(userPassword);
		setUserRole(userRole);
	}
	public User() {
		
	}
	public User(String username,String userPassword) {
		setUserName(username);
		setUserPassword(userPassword);
	}
	
}
