package weatherReader;

import java.util.Comparator;

public class SortbyA_Z implements Comparator<Weather>
{
	public int compare(Weather a, Weather b) 
    { 
        return a.getCity().charAt(0) - b.getCity().charAt(0); 
    } 
}
