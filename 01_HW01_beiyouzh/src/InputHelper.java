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
				System.out.println(num + " not within range " + rangeA + " and " + rangeB + " " + prompt);
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
		System.out.println("Please enter user's full name: ");
		String username = sc.next();
		sc.nextLine();
		System.out.println("Please enter user's password: ");
		String userpass = sc.next();
		sc.nextLine();
		System.out.println("Please enter email: ");
		boolean valid = false;
		String useremail = null;
		while(!valid) {
			useremail = sc.next();
			for( int i = 0; i < useremail.length(); i++) {
				if(useremail.charAt(i) =='@') {
					valid = true;
					break;
				}
			}
			if(!valid) {
				System.out.println("The email you entered is invalid. Please enter email: ");
			}
		}
		sc.nextLine();
		User newUser = new User(username, useremail, userpass);
		return newUser;
	}
	public static boolean getBoolean(String prompt, Scanner sc) {
		System.out.println(prompt);
		String anwser = sc.next();
		boolean ongoing = true;
		while(ongoing) {
			if(anwser.contentEquals("y") || anwser.contentEquals("yes") || anwser.contentEquals("Y")) {
				sc.nextLine();
				return true;
			}
			else if(anwser.contentEquals("n") || anwser.contentEquals("no") || anwser.contentEquals("N")) {
				sc.nextLine();
				return false;
			}
			System.out.println(anwser + " not recognized\n" + prompt);
			sc.nextLine();
			anwser = sc.next();			
		}
		return false;
	}
}
