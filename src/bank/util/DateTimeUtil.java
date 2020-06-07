package bank.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
/**
 * 
 * @author Hariom Yadav 
 *
 */

public class DateTimeUtil {
	
	/**
	 * order date = Current date and time
	 * @return Date and time
	 */
	public static String orderDateTime() {
		LocalDateTime myDateObj = LocalDateTime.now();  
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");  
	    
	    String formattedDate = myDateObj.format(myFormatObj); 
	    
	    return formattedDate;
	}
	
}
