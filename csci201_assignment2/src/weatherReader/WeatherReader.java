package weatherReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class WeatherReader {
	private ArrayList<Weather> cities = new ArrayList<Weather>();
	public boolean isLegal = false;
	public String ErrorMessage = "";
	
	public void parseFile(String File, String Path) {
		//String path = getServletContext().getRealPath();
		String fileName = File;
		String path = Path;
		boolean everInvalid = false;
			try {
				
				@SuppressWarnings("resource")
				BufferedReader br = new BufferedReader(new FileReader(path));
				String info = br.readLine();
				
				while(info != null) {
					if(this.hasConditions(fileName, info)) {
						this.parseConditions(info);
					}
					else {
						everInvalid = true;
						break;
					}
					info = br.readLine();
				}
				
				if(!everInvalid) {
					isLegal = true;
				}
			} 
			catch (FileNotFoundException fnfe) {
				ErrorMessage += "The file " + fileName + " could not be found.\n";
			} 
			catch (IOException ioe) {
				ErrorMessage += "The file " + fileName + " could not be found\n";
			}
	}
	
	public void parseConditions(String info) {
		Weather weather = new Weather();
		
		ArrayList<String> tokens = new ArrayList<String>();
		StringTokenizer tokenizer = new StringTokenizer(info, "|");
		
		while(tokenizer.hasMoreTokens()) {
			tokens.add(tokenizer.nextToken());
		}
		
		for(int i = 0; i < tokens.size(); i++) {
			if(i == 0) {
				weather.setCity(tokens.get(i));
			}
			else if(i == 1) {
				weather.setState(tokens.get(i));
			}
			else if(i == 2) {
				weather.setCountry(tokens.get(i));
			}
			else if(i == 3) {
				weather.setLatitude(Double.parseDouble(tokens.get(i)));
			}
			else if(i == 4) {
				weather.setLongitude(Double.parseDouble(tokens.get(i)));
			}
			else if(i == 5) {
				weather.setSunriseTime(tokens.get(i));
			}
			else if(i == 6) {
				weather.setSunsetTime(tokens.get(i));
			}
			else if(i == 7) {
				weather.setCurrentTemperature(Integer.parseInt(tokens.get(i)));
			}
			else if(i == 8) {
				weather.setDayLow(Integer.parseInt(tokens.get(i)));
			}
			else if(i == 9) {
				weather.setDayHigh(Integer.parseInt(tokens.get(i)));
			}
			else if(i == 10) {
				weather.setHumidity(Integer.parseInt(tokens.get(i)));
			}
			else if(i == 11) {
				weather.setPressure(Float.parseFloat(tokens.get(i)));
			}
			else if(i == 12) {
				weather.setVisibility(Float.parseFloat(tokens.get(i)));
			}
			else if(i == 13) {
				weather.setWindspeed(Float.parseFloat(tokens.get(i)));
			}
			else if(i == 14) {
				weather.setWindDirection(Integer.parseInt(tokens.get(i)));
			}
			else {
				weather.getConditionDescription().add(tokens.get(i));
			}
		}
		
		cities.add(weather);
	}

	public boolean hasConditions(String fileName, String info) {
		ArrayList<String> tokens = new ArrayList<String>();
		StringTokenizer tokenizer = new StringTokenizer(info, "|");
		
		while(tokenizer.hasMoreTokens()) {
			tokens.add(tokenizer.nextToken());
		}
		
		if(tokens.size() >= 10) {
			for(int i = 0; i < tokens.size(); i++) {
				if(i == 0 && !(tokens.get(i) instanceof String)) {
					System.out.println("");
					return false;
				}
				else if(i == 1 && !(tokens.get(i) instanceof String)) {
					return false;
				}
				else if(i == 2 && !(tokens.get(i) instanceof String)) {
					return false;
				}
				else if(i == 3 && !this.isDouble(fileName, tokens.get(i))) {
					return false;
				}
				else if(i == 4 && !this.isDouble(fileName, tokens.get(i))) {
					return false;
				}
				else if(i == 5 && !(tokens.get(i) instanceof String)) {
					return false;
				}
				else if(i == 6 && !(tokens.get(i) instanceof String)) {
					return false;
				}
				else if(i == 7 && !this.isInteger(fileName, tokens.get(i))) {
					return false;
				}
				else if(i == 8 && !this.isInteger(fileName, tokens.get(i))) {
					return false;
				}
				else if(i == 9 && !this.isInteger(fileName, tokens.get(i))) {
					return false;
				}
				else if(i == 10 && !this.isInteger(fileName, tokens.get(i))) {
					return false;
				}
				else if(i == 11 && !this.isFloat(fileName, tokens.get(i))) {
					return false;
				}
				else if(i == 12 && !this.isFloat(fileName, tokens.get(i))) {
					return false;
				}
				else if(i == 13 && !this.isFloat(fileName, tokens.get(i))) {
					return false;
				}
				else if(i == 14 && !this.isInteger(fileName, tokens.get(i))) {
					return false;
				}
				else {
					continue;
				}
			}
		}
		else {
			ErrorMessage += "The file " + fileName + " is not formatted properly.";
			ErrorMessage += "There are not enough parameters on line '" + info + "'.\n";
			return false;
		}
		
		return true;
	}
	
	private boolean isInteger(String fileName, String input) {
		try {
			Integer.parseInt(input);
			return true;
		}
		catch (Exception e) {
			ErrorMessage += "The file " + fileName + " is not formatted properly.";
			ErrorMessage += "Unable to convert '" + input + "' to an int.\n";
			return false;
		}
	}
	private boolean isDouble(String fileName, String input) {
		try {
			Double.parseDouble(input);
			return true;
		}
		catch (Exception e) {
			ErrorMessage +="The file " + fileName + " is not formatted properly.";
			ErrorMessage +="Unable to convert '" + input + "' to a double.\n";
			return false;
		}
	}
	
	private boolean isFloat(String fileName, String input) {
		try {
			Float.parseFloat(input);
			return true;
		}
		catch (Exception e) {
			ErrorMessage += "The file " + fileName + " is not formatted properly.";
			ErrorMessage += "Unable to convert '" + input + "' to a float.\n";
			return false;
		}
	}
	
	public void menuOptions() {
		while(true) {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("\nFor what city would you like weather information? ");
				String select = br.readLine();
				
				if(select.toLowerCase().equals("exit")) {
					System.out.print("\nThank you for using my weather program.");
					break;
				}
				else if(select.toLowerCase().equals("all")) {
					System.out.println("\nI do have information about the weather in all cities.\n");
					this.chooseOption(cities);
				}
				else {
					ArrayList<Weather> weathers = new ArrayList<Weather>();
					
					for(int i = 0; i < cities.size(); i++) {
						if(cities.get(i).getCity().toLowerCase().equals(select.toLowerCase())) {
							weathers.add(cities.get(i));
						}
					}
					if(weathers.size() == 0) {
						System.out.println("\nUnable to find city " + select + ".");
					}
					else {
						System.out.println("\nI do have information about the weather in " + weathers.get(0).getCity() + ".\n");
						this.chooseOption(weathers);
					}
				}
			} 
			catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}

	private void chooseOption(ArrayList<Weather> weathers) {
		int option = 0;
		this.displayOptions();
		
		while(option != 9) {
			System.out.print("\nWhat information would you like to know? ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			try {
				option = Integer.parseInt(br.readLine());
				System.out.println("");
				
				if(option >= 1 && option <= 9) {
					for(int i = 0; i < weathers.size(); i++) {
						Weather w = weathers.get(i);
						
						if(option == 1) {
							System.out.println("The temperature in " + w.getCity() + " is " + w.getCurrentTemperature() + " degrees Fahrenheit.");
						}
						else if(option == 2) {
							System.out.println("The high temperature in " + w.getCity() + " is " + w.getDayHigh() + " degrees Fahrenheit.");
							System.out.println("The low temperature in " + w.getCity() + " is " + w.getDayLow() + " degrees Fahrenheit.");
						}
						else if(option == 3) {
							System.out.println("The humidity in " + w.getCity() + " is " + w.getHumidity() + "%.");
						}
						else if(option == 4) {
							System.out.println("The pressure in " + w.getCity() + " is " + w.getPressure() + " Inch Hg.");
						}
						else if(option == 5) {
							System.out.println("The visibility in " + w.getCity() + " is " + w.getVisibility() + " miles.");
						}
						else if(option == 6) {
							System.out.println("The wind speed in " + w.getCity() + " is " + w.getWindspeed() + " miles/hour.");
							System.out.println("The wind direction in " + w.getCity() + " is " + w.getWindDirection() + " degrees.");
						}
						else if(option == 7) {
							System.out.print(w.getCity() + " weather can be described as ");
							for(int j = 0; j < w.getConditionDescription().size(); j++) {
								if(j == w.getConditionDescription().size() - 1) {
									System.out.println("and " + w.getConditionDescription().get(j) + ".");
								}
								else {
									System.out.print(w.getConditionDescription().get(j) + ", ");
								}
							}
						}
						else if(option == 8) {
							System.out.println("The temperature in " + w.getCity() + " is " + w.getCurrentTemperature() + " degrees Fahrenheit.");
							System.out.println("The high temperature in " + w.getCity() + " is " + w.getDayHigh() + " degrees Fahrenheit.");
							System.out.println("The low temperature in " + w.getCity() + " is " + w.getDayLow() + " degrees Fahrenheit.");
							System.out.println("The humidity in " + w.getCity() + " is " + w.getHumidity() + "%.");
							System.out.println("The pressure in " + w.getCity() + " is " + w.getPressure() + " Inch Hg.");
							System.out.println("The visibility in " + w.getCity() + " is " + w.getVisibility() + " miles.");
							System.out.println("The wind speed in " + w.getCity() + " is " + w.getWindspeed() + " miles/hour.");
							System.out.println("The wind direction in " + w.getCity() + " is " + w.getWindDirection() + " degrees.");
							System.out.print(w.getCity() + " weather can be described as ");
							for(int j = 0; j < w.getConditionDescription().size(); j++) {
								if(j == w.getConditionDescription().size() - 1) {
									System.out.println("and " + w.getConditionDescription().get(j) + ".");
								}
								else {
									System.out.print(w.getConditionDescription().get(j) + ", ");
								}
							}
						}
						else {
							continue;
						}
					}
				}
				else {
					System.out.println("That is not a valid option.");
				}
			} 
			catch (NumberFormatException nfe) {
				System.out.println("That is not a valid option.");
			} 
			catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}

	private void displayOptions() {
		System.out.println("\t1) Temperature");
		System.out.println("\t2) High and low temperature today");
		System.out.println("\t3) Humidity");
		System.out.println("\t4) Pressure");
		System.out.println("\t5) Visibility");
		System.out.println("\t6) Wind speed and direction");
		System.out.println("\t7) Descriptions of weather conditions");
		System.out.println("\t8) Everything");
		System.out.println("\t9) Enter a different city");
	}

	public static void main(String[] args) {
		WeatherReader w = new WeatherReader();
		System.out.println(w.isLegal);
		System.out.println(w.ErrorMessage);
		//w.menuOptions();
	}

	public ArrayList<Weather> getCities() {
		return cities;
	}
	public Weather findCity(String city) {
		for(int i = 0; i <cities.size(); i++) {
			if(cities.get(i).getCity().contentEquals(city)) {
				return cities.get(i);
			}
		}
		return null;
	}
	public Weather findCity(double latitude, double longitude) {
			for(int i = 0; i <cities.size(); i++) {
				if(cities.get(i).getLatitude()==latitude && cities.get(i).getLongitude()==longitude) {
					return cities.get(i);
				}
			}
			return null;
	}
}
