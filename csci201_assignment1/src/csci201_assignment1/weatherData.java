package csci201_assignment1;

public class weatherData {
	private String city;
	private int currentTemperature;
	private int dayLow;
	private int dayHigh;
	private float pressure;
	private float visibility;
	private float windspeed;
	private int windDirection;
	
	public weatherData(String city, int currentTemperature, int dayLow, int dayHigh, float pressure, float visibility,
			float windspeed, int windDirection) {
		this.city = city;
		this.currentTemperature = currentTemperature;
		this.dayLow = dayLow;
		this.dayHigh = dayHigh;
		this.pressure = pressure;
		this.visibility = visibility;
		this.windspeed = windspeed;
		this.windDirection = windDirection;
	}

	public String conditionDescription() {
		
	}
}
