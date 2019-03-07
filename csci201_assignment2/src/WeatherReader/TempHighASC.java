package WeatherReader;

import java.util.Comparator;

public class TempHighASC implements Comparator<Weather>
{
	public int compare(Weather a, Weather b) 
    { 
        return a.getDayHigh() - b.getDayHigh();
    } 
	
}
