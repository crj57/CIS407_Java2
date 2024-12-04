package courseProject;
import java.util.Date;
import java.text.SimpleDateFormat;

public class DataEntry {
	 
	
	public static boolean checkStringNoLimit(String entry) {
		//will return false if blank
		if (entry.length() != 0) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public static boolean checkStringWithLimit(String entry, int minLength, int maxLength) {
		//will return false if blank or longer than maxLength
		if (entry.length() >= minLength && entry.length() <= maxLength) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkStringNumeric(String entry) {
		//will return false if error is thrown when parsing 
		try {
			Double.parseDouble(entry);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
		
	}
	
	public static boolean checkInteger(int entry) {
		if (entry >= 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkIntegerWithLimit(int entry, int start, int finish) {
		if (entry >= start && entry <= finish) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean checkDouble(Double entry) {
		if (entry != null && entry >= 0) {
			return true;
		} else {
			return false;
		}
	}
	public static boolean checkDoubleWithLimit(double entry, double low, double high) {
		//will return false if integer is less than low parameter or more than high
		if (entry >= low && entry <= high) {
			return true;
		} else {
			return false;
		}	
	}
	public static boolean checkDate(String entry) {
		//will return true if string is able to be parsed into Date 
		SimpleDateFormat parser = new SimpleDateFormat("MM/dd/yyyy");
		try {
			Date date = parser.parse(entry);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	

}
