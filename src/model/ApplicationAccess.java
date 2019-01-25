package model;
//odpowiednik na bazie "application_access"
public class ApplicationAccess {

	private int accessId;
	private String userName;
	private int roleId;
	private String emailConfirmed;
	
	public int getAccessId() {
		return accessId;
	}
	public void setAccessId(int accessId) {
		this.accessId = accessId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getEmailConfirmed() {
		return emailConfirmed;
	}
	public void setEmailConfirmed(String emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
	}
	
	public ApplicationAccess(String userName, int roleId, String emailConfirmed) {
		
		setUserName(userName);
		setRoleId(roleId);
		setEmailConfirmed(emailConfirmed);
		
	}
}
