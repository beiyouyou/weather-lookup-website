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



	public String conditionDescription() {
		return toString();
	}
}
