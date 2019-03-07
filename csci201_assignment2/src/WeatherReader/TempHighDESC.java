package WeatherReader;

import java.util.Comparator;

public class TempHighDESC implements Comparator<Weather>
{
	public int compare(Weather a, Weather b) 
    { 
        return b.getDayHigh() - a.getDayHigh();
    } 
	
}
