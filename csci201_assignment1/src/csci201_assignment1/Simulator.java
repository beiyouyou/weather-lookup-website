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
		weatherData data1;
		while(ongoing) {
		System.out.println("For what city would you like weather information ");
		String answer = reader.nextLine();
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
		else {
			data1 = Freader.findCity(answer);
			System.out.println("I do have information about the city in " + answer);
			System.out.println("1) Temperature \n"
					+ "2) High and Low temperature today \n"
					+ "3) Humidity \n"
					+ "4) Pressure \n"
					+ "5) Visibility \n"
					+ "6) Wind speed and direction \n"
					+ "7) Description of weather conditions \n"
					+ "8) Everything \n"
					+ "9) Enter a different city");
			int choice = inputHelper.readChoice("What information would you like to know? ", reader);
			System.out.print(choice);
			switch(choice) {
			case 1:
				
			}
		}
		}
	}
}
