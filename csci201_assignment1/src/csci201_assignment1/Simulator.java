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
		boolean choose_all = false;
		int choice = 0;
		//determine which anwser the user choose;
		while(ongoing) {
		
		System.out.println("For what city would you like weather information ");
		String answer = reader.nextLine();
		if(answer.contentEquals("ALL")){
			choose_all = true;
		}
		else if(answer.contentEquals("EXIT")) {
			break;
		}
		else if(!Freader.isLegalCity(answer)) {
			System.out.println("Unable to find city " + answer);
			continue;
		}
		if(!choose_all) {
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
			while(ongoing) {
			choice = inputHelper.readChoice("What information would you like to know? ", reader);
			switch(choice) {
			case -1: break;
			case 1: data1.printCurTem();
			case 2: data1.printDayLowHigh();;
			case 3: data1.printHumidity();
			case 4: data1.printPressure();
			case 5: data1.printVisibility();
			case 6: data1.printWind();
			case 7: data1.printWeatherDescription();
			case 8: data1.printAll();
			case 9: break;
			}
			}
			if(choice == -1) break;
		}
		else {
			System.out.println("I do have information about the weather in all cities.\n");
			System.out.println("1) Temperature \n"
					+ "2) High and Low temperature today \n"
					+ "3) Humidity \n"
					+ "4) Pressure \n"
					+ "5) Visibility \n"
					+ "6) Wind speed and direction \n"
					+ "7) Description of weather conditions \n"
					+ "8) Everything \n"
					+ "9) Enter a different city");
			while(ongoing) {
			System.out.println(" the choice is " + Integer.toString(choice));
			choice = inputHelper.readChoice("What information would you like to know? ", reader);
			System.out.println(" the choice is " + Integer.toString(choice));
			switch(choice) {
			case -1: break;
			case 1: Freader.printCurTem();
			case 2: Freader.printDayLowHigh();;
			case 3: Freader.printHumidity();
			case 4: Freader.printPressure();
			case 5: Freader.printVisibility();
			case 6: Freader.printWind();
			case 7: Freader.printWeatherDescription();
			case 8: Freader.printAll();
			case 9: break;
			}
			}
			if(choice == -1) break;
		}
		}
	}
}
