package tools;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Tools {
	
	public static String formatDateToDisplay(Calendar cal) {
		if(cal != null){
			return cal.toInstant().toString();
		}
		return null;
	}
	
	public static String formatDateToDisplay(Date date) {
		if(date != null){
			return date.toInstant().toString();
		}
		return null;
	}
	
	public static String formatDateToDisplay(Instant instant) {
		if(instant != null){
			return instant.toString();
		}
		return null;
	}
	
	public static String formatDateToDisplay(ZonedDateTime zdt) {
		if(zdt != null){
			return zdt.format(DateTimeFormatter.ISO_INSTANT);
		}
		return null;
	}
	
	public static ZonedDateTime parseInstantToZonedDateTime(Instant ins) {
		return ZonedDateTime.ofInstant(ins, ZoneId.systemDefault());
	}
	
	public static ZonedDateTime parseCalendarToZonedDateTime(Calendar cal) {
		return ZonedDateTime.ofInstant(cal.toInstant(), cal.getTimeZone().toZoneId());
	}
	
	public static ZonedDateTime parseDateToZonedDateTime(Date date) {
		return ZonedDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
	}
}
