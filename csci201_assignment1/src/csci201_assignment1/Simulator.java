package csci201_assignment1;

import java.util.Scanner;

public class Simulator {
	public static void main(String args[]) {
		Scanner reader = new Scanner(System.in);
		fileReader Freader = new fileReader();
		while(!Freader.isLegalFile()) {
		System.out.println("What is the name of the weather file? ");
		Freader.readFile(reader);
		}
		boolean ongoing = true;
		while(ongoing) {
		System.out.println("For what city would you like weather information ");
		String answer = reader.next();
		if(answer.contentEquals("ALL")){
			System.out.println(Freader);
			continue;
		}
		else if(answer.contentEquals("EXIT")) {
			break;
		}
		else if(!Freader.isLegalCity(answer)) {
			System.out.println("Unable to find city " + answer);
			continue;
		}
		}
	}
}
