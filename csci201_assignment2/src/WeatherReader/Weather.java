package WeatherReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Weather {
	@Override
	public String toString() {
		return "Weather [city=" + city + ", country=" + country + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", sunriseTime=" + sunriseTime + ", sunsetTime=" + sunsetTime + ", currentTemperature="
				+ currentTemperature + ", dayLow=" + dayLow + ", dayHigh=" + dayHigh + ", humidity=" + humidity
				+ ", windspeed=" + windspeed + ", windDirection=" + windDirection + "]";
	}
	private String city;
	private String state;
	private String country;
	private double latitude;
	private double longitude;
	private String sunriseTime;
	private String sunsetTime;
	private int currentTemperature;
	private int dayLow;
	private int dayHigh;
	private int humidity;
	private float pressure;
	public Weather(String city, String country, double latitude, double longitude, String sunriseTime,
			String sunsetTime, int currentTemperature, int dayLow, int dayHigh, int humidity,
			float windspeed, int windDirection) {
		super();
		this.city = city;
		this.country = country;
		this.latitude = latitude;
		this.longitude = longitude;
		this.sunriseTime = sunriseTime;
		this.sunsetTime = sunsetTime;
		this.currentTemperature = currentTemperature;
		this.dayLow = dayLow;
		this.dayHigh = dayHigh;
		this.humidity = humidity;
		this.windspeed = windspeed;
		this.windDirection = windDirection;
	}
	private float visibility;
	private float windspeed;
	private int windDirection;
	private ArrayList<String> conditionDescription = new ArrayList<String>();
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getSunriseTime() {
		return sunriseTime;
	}
	public void setSunriseTime(String sunriseTime) {
		this.sunriseTime = sunriseTime;
	}
	public String getSunsetTime() {
		return sunsetTime;
	}
	public void setSunsetTime(String sunsetTime) {
		this.sunsetTime = sunsetTime;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getCurrentTemperature() {
		return currentTemperature;
	}
	public void setCurrentTemperature(int currentTemperature) {
		this.currentTemperature = currentTemperature;
	}
	public int getDayLow() {
		return dayLow;
	}
	public void setDayLow(int dayLow) {
		this.dayLow = dayLow;
	}
	public int getDayHigh() {
		return dayHigh;
	}
	public void setDayHigh(int dayHigh) {
		this.dayHigh = dayHigh;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	public float getPressure() {
		return pressure;
	}
	public void setPressure(float pressure) {
		this.pressure = pressure;
	}
	public float getVisibility() {
		return visibility;
	}
	public void setVisibility(float visibility) {
		this.visibility = visibility;
	}
	public float getWindspeed() {
		return windspeed;
	}
	public void setWindspeed(float windspeed) {
		this.windspeed = windspeed;
	}
	public int getWindDirection() {
		return windDirection;
	}
	public void setWindDirection(int windDirection) {
		this.windDirection = windDirection;
	}
	public ArrayList<String> getConditionDescription() {
		return conditionDescription;
	}
}

