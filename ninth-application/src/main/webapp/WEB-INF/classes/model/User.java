package model;

public class User {

	private int id;
	private String loginId;
	private String password;

	public User() {}

	public User(int id, String loginId, String password) {
		this.id = id;
		this.loginId = loginId;
		this.password = password;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setPassword(String password) {
		this.password = password;
	}
 
	public String getPassword() {
		return password;
	}
}