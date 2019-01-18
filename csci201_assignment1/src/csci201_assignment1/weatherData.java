package csci201_assignment1;

public class weatherData {

	private String city;
	private int currentTemperature;
	private int dayLow;
	private int dayHigh;
	private int humidity;
	private float pressure;
	private float visibility;
	private float windspeed;
	private int windDirection;
	private String conditionDescription;
	


	public weatherData(String city, int currentTemperature, int dayLow, int dayHigh, int humidity, float pressure,
			float visibility, float windspeed, int windDirection, String conditionDescription) {
		this.city = city;
		this.currentTemperature = currentTemperature;
		this.dayLow = dayLow;
		this.dayHigh = dayHigh;
		this.humidity = humidity;
		this.pressure = pressure;
		this.visibility = visibility;
		this.windspeed = windspeed;
		this.windDirection = windDirection;
		this.conditionDescription = conditionDescription;
	}

	@Override
	public String toString() {
		return "weatherData [city=" + city + ", currentTemperature=" + currentTemperature + ", dayLow=" + dayLow
				+ ", dayHigh=" + dayHigh + ", humidity=" + humidity + ", pressure=" + pressure + ", visibility="
				+ visibility + ", windspeed=" + windspeed + ", windDirection=" + windDirection
				+ ", conditionDescription=" + conditionDescription + "]";
	}
	public void printCurTem(){
		System.out.println("The temperature in " + city + " is " + Integer.toString(currentTemperature)
		+ " degree Fahrenheit. \n");
	}
	public void printDayLowHigh() {
		System.out.println("The high temperature in " + city + " is " + Integer.toString(dayHigh)
		+ " degree Fahrenheit. \nThe low temperature in "+ city + " is " + Integer.toString(dayLow)
		+ " degree Fahrenheit.\n" );
	}
	public void printHumidity() {
		System.out.println("The humidity in " + city + " is " + Integer.toString(humidity)
		+ "%.\n");
	}
	public void printPressure() {
		System.out.println("The pressure in " + city + " is " + Float.toString(pressure)
		+ " Inch Hg\n");
	}
	public void printVisibility() {
		System.out.println("The visibility in " + city + " is " + Float.toString(visibility)
		+ "%\n");
	}
	public void printWind() {
		System.out.println("The wind speed in " + city + " is " + Float.toString(windspeed)
		+ " miles/hour. \nThe wind direction in "+ city + " is " + Integer.toString(windDirection)
		+ " degrees\n." );
	}
	public void printWeatherDescription() {
		System.out.println(city + " weather can be described as " + conditionDescription +".\n");
		return;
	}
	public void printAll() {
		printCurTem();
		printDayLowHigh();
		printHumidity();
		printPressure();
		printVisibility();
		printWind();
		printWeatherDescription();
		return;
	}
	public String conditionDescription() {
		return toString();
	}

	public String getCity() {
		return city;
	}

	public int getCurrentTemperature() {
		return currentTemperature;
	}

	public int getDayLow() {
		return dayLow;
	}

	public int getDayHigh() {
		return dayHigh;
	}

	public int getHumidity() {
		return humidity;
	}

	public float getPressure() {
		return pressure;
	}

	public float getVisibility() {
		return visibility;
	}

	public float getWindspeed() {
		return windspeed;
	}

	public int getWindDirection() {
		return windDirection;
	}

	public String getConditionDescription() {
		return conditionDescription;
	}
	
}
