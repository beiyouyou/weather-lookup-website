/**
 * 
 */

/**
 * Brief description of the code
 * 
 * @author Beiyou Zhu
 * ITP 368, Fall 2018
 * Assignment: 
 * beiyouzh@usc.edu
 */

public class Company {
	
	/**
	 * 
	 */
	private String name;
	private User[] companyMem;
	//default capacity
	private int MAX_CAPACITY = 20;
	private int currentNumUsers;
	//constructors of the company
	public Company(String name) {
		this.name = name;
		this.currentNumUsers = 0;
	}
	public Company(String name, int myMax) {
		this.name = name;
		this.MAX_CAPACITY = myMax;
	}
	public Company(String name, User[] companyMem) {
		this.name = name;
		this.companyMem = companyMem;
		this.MAX_CAPACITY = companyMem.length;
		this.currentNumUsers = helperCountUser(companyMem);
	}
	//a helper function to count the number of users in a company
	private int helperCountUser(User[] companyMem) {
		int count = 0;
		for( int i = 0; i < companyMem.length; i++) {
			if(companyMem[i] == null) break;
			count++;
		}
		return count;
	}
	public String usersToString() {
		String output = "";
		for(int i = 0; i < currentNumUsers; i++) {
			output += companyMem[i];
			output += "\n";
		}
		return output;
	}
	public boolean addUser(User user) {
		if(currentNumUsers >= MAX_CAPACITY)return false;
		companyMem[currentNumUsers] = user;
		currentNumUsers += 1;
		return true;
	}
	public User findUserByName(String name) {
		for( int i = 0; i < currentNumUsers; i++) {
			if(companyMem[i].getName().equals(name)) {
				return companyMem[i];
			}
		}
		return null;
	}
	public User findUserByEmail(String email) {
		for( int i = 0; i < currentNumUsers; i++) {
			if(companyMem[i].getEmail().equals(email)) {
				return companyMem[i];
			}
		}
		return null;
	}
	public int getMaxCapacity() {
		return MAX_CAPACITY;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User[] getUsers() {
		return companyMem;
	}
	public int getCurrentNumUsers() {
		return currentNumUsers;
	}
	public String toString() {
		return " Company name: " + name + " Current number of users: " + currentNumUsers;
	}


}
