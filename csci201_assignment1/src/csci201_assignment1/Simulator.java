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
		if(answer.contentEquals("ALL") || answer.contentEquals("all")){
			choose_all = true;
		}
		else if(answer.contentEquals("EXIT") || answer.contentEquals("exit")) {
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
			case 1: data1.printCurTem();break;
			case 2: data1.printDayLowHigh();break;
			case 3: data1.printHumidity();break;
			case 4: data1.printPressure();break;
			case 5: data1.printVisibility();break;
			case 6: data1.printWind();break;
			case 7: data1.printWeatherDescription();break;
			case 8: data1.printAll();break;
			case 9: break;
			}
			if(choice == 9 || choice == -1)break;
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
			choice = inputHelper.readChoice("What information would you like to know? ", reader);
			switch(choice) {
			case -1: break;
			case 1: Freader.printCurTem(); break;
			case 2: Freader.printDayLowHigh();break;
			case 3: Freader.printHumidity();break;
			case 4: Freader.printPressure();break;
			case 5: Freader.printVisibility();break;
			case 6: Freader.printWind();break;
			case 7: Freader.printWeatherDescription();break;
			case 8: Freader.printAll();break;
			case 9: break;
			}
			if(choice == 9 || choice == -1)break;
			}
			if(choice == -1) break;
		}
		}
	}
}
