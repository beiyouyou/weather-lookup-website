/**
 * 
 */

/**
 * User class records users' information
 * 
 * @author Beiyou Zhu
 * ITP 368, Fall 2018
 * Assignment: 01
 * beiyouzh@usc.edu
 */

public class User {
	private String name;
	private String password;
	private String email;

	public User(String name, String email, String password) {
		this.name = name;
		this.password = password;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean changePassword(String current, String newPass) {
		if(!checkPassword(current)){
			return false;
		}
		this.password = newPass;
		return true;
	}
	public boolean checkPassword(String attempt) {
		if(attempt.equals(this.password)) {
			return true;
		}
		return false;
	}
	public String toString() {
		return "User name: "+ name +" email address: " + email;
	}

}
