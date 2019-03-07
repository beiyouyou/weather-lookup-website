package BackEnd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import WeatherReader.Weather;

public class weatherRequest {

    //private static final String USER_AGENT = "Beiyou;
	private static String key = "&appid=baf89635cc3f943d9c2632e0758b6511";
	private String url = "http://api.openweathermap.org/data/2.5/weather?";
	public static Weather getByCor(String lat, String lon) throws Exception {
		String url = "http://api.openweathermap.org/data/2.5/weather?" + "lat=" +lat+ "&lon="+lon + key;
				
				URL obj = new URL(url);
				HttpURLConnection con = (HttpURLConnection) obj.openConnection();

				con.setRequestMethod("GET");
				System.out.println("\nSending 'GET' request to URL : " + url);

				BufferedReader in = new BufferedReader(
				        new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
				System.out.println(response.toString());
				
				JSONParser parser = new JSONParser();
				JSONObject json = (JSONObject) parser.parse(response.toString());
				JSONObject coordinates = (JSONObject)json.get("coord");
				double Long = (double)coordinates.get("lon");
				double Lat = (double)coordinates.get("lat");
				JSONArray weather2 = (JSONArray)json.get("weather");
				Iterator<JSONObject> i = weather2.iterator();
				JSONObject weather = i.next();
				JSONObject info = (JSONObject)json.get("main");
				int temp = (int)(((double)info.get("temp") - 273.15)* 1.8 + 32.00);
				String description = (String) weather.get("description");
				int tempLow =(int)(((double)info.get("temp_min") - 273.15)* 1.8 + 32.00);
				int tempHigh = (int)(((double)info.get("temp_max") - 273.15)* 1.8 + 32.00);
				int humidity = (int)((long)info.get("humidity"));
				String name = (String)json.get("name");
				JSONObject sys = (JSONObject)json.get("sys");
				JSONObject wind = (JSONObject)json.get("wind");
				float windspeed;
				try {windspeed = (float)((double)wind.get("speed"));}
				catch(Exception e) {
					windspeed = (float)((long)wind.get("speed"));}
				int winddir;
				try {winddir = (int)((double)wind.get("deg"));}
				catch(Exception e) {
					winddir = (int)((long)wind.get("deg"));}
				String country = (String)sys.get("country");
				String sunrise = String.valueOf(sys.get("sunrise"));
				String sunset = String.valueOf(sys.get("sunset"));
				System.out.println(Long + Lat + description + " temp:" + temp + " templow:" + tempLow + 
						" temphigh:" + tempHigh + "sunrise:" + sunrise + "sunset:" + sunset + "city&country" + name +
						country + " wind" + windspeed +" humidity" + humidity);
				//parse string into json object;
				Weather w = new Weather(name, country, Lat, Long, sunrise,
						sunset, temp, tempLow, tempHigh, humidity,
						windspeed, winddir);
				return w;
				
		    }
	public static Weather getByName(String name) throws Exception {
	String url = "http://api.openweathermap.org/data/2.5/weather?" + "q=" +name + key;
			
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			con.setRequestMethod("GET");
			System.out.println("\nSending 'GET' request to URL : " + url);

			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			System.out.println(response.toString());
			
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(response.toString());
			JSONObject coordinates = (JSONObject)json.get("coord");
			double Long = (double)coordinates.get("lon");
			double Lat = (double)coordinates.get("lat");
			JSONArray weather2 = (JSONArray)json.get("weather");
			Iterator<JSONObject> i = weather2.iterator();
			JSONObject weather = i.next();
			JSONObject info = (JSONObject)json.get("main");
			int temp = (int)(((double)info.get("temp") - 273.15)* 1.8 + 32.00);
			String description = (String) weather.get("description");
			int tempLow =(int)(((double)info.get("temp_min") - 273.15)* 1.8 + 32.00);
			int tempHigh = (int)(((double)info.get("temp_max") - 273.15)* 1.8 + 32.00);
			int humidity = (int)((long)info.get("humidity"));
			String name2 = (String)json.get("name");
			JSONObject sys = (JSONObject)json.get("sys");
			JSONObject wind = (JSONObject)json.get("wind");
			float windspeed;
			try {windspeed = (float)((double)wind.get("speed"));}
			catch(Exception e) {
				windspeed = (float)((long)wind.get("speed"));}
			int winddir;
			try {winddir = (int)((double)wind.get("deg"));}
			catch(Exception e) {
				winddir = (int)((long)wind.get("deg"));}
			String country = (String)sys.get("country");
			String sunrise = String.valueOf(sys.get("sunrise"));
			String sunset = String.valueOf(sys.get("sunset"));
			System.out.println(Long + Lat + description + " temp:" + temp + " templow:" + tempLow + 
					" temphigh:" + tempHigh + "sunrise:" + sunrise + "sunset:" + sunset + "city&country" + name2 +
					country + " wind" + windspeed +" humidity" + humidity);
			//parse string into json object;
			Weather w = new Weather(name2, country, Lat, Long, sunrise,
					sunset, temp, tempLow, tempHigh, humidity,
					windspeed, winddir);
			return w;
			
	    }
}
