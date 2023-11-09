package application;
// A class for the object type Account which stores username and password.

public class Account {
	private String username, password;
	
	public Account(String user, String pw) {
		this.username = user;
		this.password = pw;
	}
	
	public void setUser(String user) {
		this.username = user;
	}
	
	public void setPW(String pw) {
		this.password = pw;
	}
	
	public String getUser() { return username; }
	public String getPW() { return password; }
}
