package model;
//javaBeans odpowiednik tabeli na bazie "user_email_confirm"
public class EmailConfirm {
	private int userId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getEmailCode() {
		return emailCode;
	}
	public void setEmailCode(int emailCode) {
		this.emailCode = emailCode;
	}
	private int emailCode;
	
	public EmailConfirm(int userId,int emailCode) {
		setUserId(userId);
		setEmailCode(emailCode);
	}
}
