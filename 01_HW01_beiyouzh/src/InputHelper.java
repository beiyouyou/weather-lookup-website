import java.util.Scanner;

/**
 * 
 */

/**
 * Brief description of the code
 * 
 * @author Beiyou Zhu
 * ITP 368, Fall 2018
 * Assignment: 01
 * beiyouzh@usc.edu
 */

public class InputHelper {

	/**
	 * 
	 */
	public static String getString(String prompt, Scanner sc) {
		System.out.println(prompt);
		String output = sc.nextLine();
		return output;
	}
	public static int getInt(String prompt, Scanner sc) {
		System.out.println(prompt);
		while(! sc.hasNextInt()) {
			String garbage = sc.nextLine();
			System.out.println(garbage + " not recognized\n" + prompt);
		}
		int num = sc.nextInt();
		sc.nextLine(); //get rid of the enter (clear the buffer)
		return num;
	}
	public static int getInt(String prompt, int rangeA, int rangeB, Scanner sc) {
		System.out.println(prompt);
		int num = 0;
		boolean ongoing = true;
		while(ongoing) {
			if(!sc.hasNextInt()) {
			String garbage = sc.nextLine();
			System.out.println(garbage + " not recognized\n" + prompt);
			continue;
			}
			num = sc.nextInt();
			if(num < rangeA || num > rangeB) {
				System.out.println(num + " not within range " + rangeA + " and " + rangeB + prompt);
				sc.nextLine();
				continue;
			}
			else {
				break;
			}
		}
		sc.nextLine();
		return num;
		
	}
	public static User getUserObject(Scanner sc) {
		String username = sc.next();
		String useremail = sc.next();
		String userpass = sc.next();
		User newUser = new User(username, useremail, userpass);
		return newUser;
	}
	public static boolean getBoolean(String prompt, Scanner sc) {
		System.out.println(prompt);
		return true;
	}
}
