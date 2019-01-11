import java.util.Scanner;

public class InputHelper {

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

}
