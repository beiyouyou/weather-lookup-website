package weatherReader;

import java.util.Comparator;

public class TempLowASC implements Comparator<Weather>
{
	public int compare(Weather a, Weather b) 
    { 
        return a.getDayLow() - b.getDayLow();
    } 
	
}