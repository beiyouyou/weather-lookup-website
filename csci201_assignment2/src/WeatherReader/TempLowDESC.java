package WeatherReader;

import java.util.Comparator;

public class TempLowDESC implements Comparator<Weather>
{
	public int compare(Weather a, Weather b) 
    { 
        return b.getDayLow() - a.getDayLow();
    } 
	
}
