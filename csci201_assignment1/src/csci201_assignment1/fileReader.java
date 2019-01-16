package csci201_assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class fileReader {
	private weatherData[] dataArray;
	private int sizeOfArray = 100;
	private int numCity;
	boolean legalFile;
	public fileReader() {
		dataArray = new weatherData[sizeOfArray];
		legalFile = false;
		numCity = 0;
	}

	public void readFile(Scanner sc) {
		//clean and create a new array
		this.dataArray = new weatherData[this.sizeOfArray];
		String file = sc.next();
		File fr = new File(file);
		Scanner chart = null;
			try {
				chart = new Scanner(fr);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				System.out.println("The file " + file + " does not exist.\n");
				return;
			}
		// see if the file is correctly formated
		String city;
		int currentTemperature = 0;
		int dayLow = 0;
		int dayHigh = 0;
		int humidity = 0;
		float pressure = 0;
		float visibility = 0;
		float windspeed = 0;
		int windDirection = 0;
		String conditionDescription = "";
		String next = "";
		int index = 0;
		if(chart!= null) {
			while (chart.hasNextLine()) {
				String read = chart.nextLine();
				StringTokenizer tokenizer = new StringTokenizer(read, "|");
				if (!tokenizer.hasMoreTokens()) {
					System.out.println("This file " + file + " is not formatted properly.\n"
							+ "There are not enough parameters on line " + read);
					return;
				}
				city = tokenizer.nextToken();
				if (!tokenizer.hasMoreTokens()) {
					System.out.println("This file " + file + " is not formatted properly.\n"
							+ "There are not enough parameters on line " + read);
					return;
				}
				next = tokenizer.nextToken();
				try {
					currentTemperature = Integer.parseInt(next);
				} catch (NumberFormatException nfe) {
					System.out.println("This file " + file + " is not formatted properly.\n" + "Unable to convert " + next
							+ " to an integer.");
					return;
				}
				if (!tokenizer.hasMoreTokens()) {
					System.out.println("This file " + file + " is not formatted properly.\n"
							+ "There are not enough parameters on line " + read);
					return;
				}
				next = tokenizer.nextToken();
				try {
					dayLow = Integer.parseInt(next);
				} catch (NumberFormatException nfe) {
					System.out.println("This file " + file + " is not formatted properly.\n" + "Unable to convert " + next
							+ " to an integer.");
					return;
				}
				if (!tokenizer.hasMoreTokens()) {
					System.out.println("This file " + file + " is not formatted properly.\n"
							+ "There are not enough parameters on line " + read);
					return;
				}
				next = tokenizer.nextToken();
				try {
					dayHigh = Integer.parseInt(next);
				} catch (NumberFormatException nfe) {
					System.out.println("This file " + file + " is not formatted properly.\n" + "Unable to convert " + next
							+ " to an integer.");
					return;
				}
				if (!tokenizer.hasMoreTokens()) {
					System.out.println("This file " + file + " is not formatted properly.\n"
							+ "There are not enough parameters on line " + read);
					return;
				}
				next = tokenizer.nextToken();
				try {
					humidity = Integer.parseInt(next);
				} catch (NumberFormatException nfe) {
					System.out.println("This file " + file + " is not formatted properly.\n" + "Unable to convert " + next
							+ " to an integer.");
					return;
				}
				if (!tokenizer.hasMoreTokens()) {
					System.out.println("This file " + file + " is not formatted properly.\n"
							+ "There are not enough parameters on line " + read);
					return;
				}
				next = tokenizer.nextToken();
				try {
					pressure = Float.parseFloat(next);
				} catch (NumberFormatException nfe) {
					System.out.println("This file " + file + " is not formatted properly.\n" + "Unable to convert " + next
							+ " to a float.");
					return;
				}
				if (!tokenizer.hasMoreTokens()) {
					System.out.println("This file " + file + " is not formatted properly.\n"
							+ "There are not enough parameters on line " + read);
					return;
				}
				next = tokenizer.nextToken();
				try {
					visibility = Float.parseFloat(next);
				} catch (NumberFormatException nfe) {
					System.out.println("This file " + file + " is not formatted properly.\n" + "Unable to convert " + next
							+ " to a float.");
					return;
				}
				if (!tokenizer.hasMoreTokens()) {
					System.out.println("This file " + file + " is not formatted properly.\n"
							+ "There are not enough parameters on line " + read);
					return;
				}
				next = tokenizer.nextToken();
				try {
					windspeed = Float.parseFloat(next);
				} catch (NumberFormatException nfe) {
					System.out.println("This file " + file + " is not formatted properly.\n" + "Unable to convert " + next
							+ " to a float.");
					return;
				}
				if (!tokenizer.hasMoreTokens()) {
					System.out.println("This file " + file + " is not formatted properly.\n"
							+ "There are not enough parameters on line " + read);
					return;
				}
				next = tokenizer.nextToken();
				try {
					windDirection = Integer.parseInt(next);
				} catch (NumberFormatException nfe) {
					System.out.println("This file " + file + " is not formatted properly.\n" + "Unable to convert " + next
							+ " to an Integer.");
					return;
				}
				if (!tokenizer.hasMoreTokens()) {
					System.out.println("This file " + file + " is not formatted properly.\n"
							+ "There are not enough parameters on line " + read);
					return;
				}
				while (tokenizer.hasMoreTokens()) {
					conditionDescription += tokenizer.nextToken() + " ";
				}
				weatherData cityWeather = new weatherData(city, currentTemperature, dayLow, dayHigh, humidity, pressure,
						visibility, windspeed, windDirection, conditionDescription);
				this.dataArray[index] = cityWeather;
				index++;
			}
		}
		this.legalFile = true;
		this.numCity = index;
		chart.close();
		return;
	}
	public boolean isLegalCity(String name) {
		for(int i = 0; i < this.numCity; i++) {
			if(this.dataArray[i].getCity().contentEquals(name)) return true;
		}
		return false;
	}
	public weatherData findCity(String name) {
		for(int i = 0; i < this.numCity; i++) {
			if(this.dataArray[i].getCity().contentEquals(name)) return this.dataArray[i];
		}
		return null;
	}
	@Override
	public String toString() {
		String output = "";
		for(int i = 0; i < this.numCity; i++) {
			output += this.dataArray[i] + "\n";
		}
		return output;
	}

	public boolean isLegalFile() {
		return this.legalFile;
	}
}
