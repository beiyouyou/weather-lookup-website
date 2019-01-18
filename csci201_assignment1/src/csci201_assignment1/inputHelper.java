package csci201_assignment1;

import java.util.Scanner;

public class inputHelper {
	public static int readChoice(String prompt, Scanner sc) {
		System.out.println(prompt);
		boolean ongoing = true;
		int output = 0;
		while(ongoing) {
		String input = sc.nextLine();
		if(input.contentEquals("EXIT")){
			return -1;
		}//return -1 if the user wants to quit
		try {
			output = Integer.parseInt(input);
		}catch(NumberFormatException nfe) {	
			System.out.println("This is not a valid option." + "\n" + prompt);
			continue;
		}
		if(output < 1 || output > 9) {
		System.out.println("This is not a valid option." + "\n" + prompt);
		continue;
		}
		break;
		}
		return output;
	}
}
