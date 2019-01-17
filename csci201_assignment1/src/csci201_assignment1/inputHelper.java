package csci201_assignment1;

import java.util.Scanner;

public class inputHelper {
	public static int readChoice(String prompt, Scanner sc) {
		System.out.println(prompt);
		boolean ongoing = true;
		int output = 0;
		while(ongoing) {
		if(!sc.hasNextInt()) {
		System.out.println("This is not a valid option." + "\n" + prompt);
		sc.nextLine();
		continue;
		}
		output = sc.nextInt();
		if(output < 1 || output > 9) {
		System.out.println("This is not a valid option." + "\n" + prompt);
		sc.nextLine();
		continue;
		}
		break;
		}
		return output;
	}
}
