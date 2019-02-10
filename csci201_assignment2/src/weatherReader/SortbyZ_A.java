package weatherReader;

import java.util.Comparator;

public class SortbyZ_A implements Comparator<Weather>
{
	public int compare(Weather a, Weather b) 
    { 
        return b.getCity().charAt(0) - a.getCity().charAt(0); 
    } 
}