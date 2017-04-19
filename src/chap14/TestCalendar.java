package chap14;

import java.util.*;

public class TestCalendar {

	public static void main(String[] args) {

		Calendar calendar = new GregorianCalendar();
		System.out.println("Current time is " + new Date());
		System.out.println("YEAR:\t" + calendar.get(Calendar.YEAR));
		System.out.println("MONTH:\t" + calendar.get(Calendar.MONTH));
		System.out.println("DATE:\t" + calendar.get(Calendar.DATE));
		System.out.println("HOUR:\t" + calendar.get(Calendar.HOUR));
		System.out.println("HOUR_OF_DAY:\t" + calendar.get(Calendar.HOUR_OF_DAY));
		System.out.println("MINUTE:\t" + calendar.get(Calendar.MINUTE));
		System.out.println("SECOND:\t" + calendar.get(Calendar.SECOND));
		System.out.println("DAY_OF_WEEK:\t" + calendar.get(Calendar.DAY_OF_WEEK));
		System.out.println("DAY_OF_MONTH:\t" + calendar.get(Calendar.DAY_OF_MONTH));
		System.out.println("DAY_OF_YEAR:\t" + calendar.get(Calendar.DAY_OF_YEAR));
		System.out.println("AM_PM:\t" + calendar.get(Calendar.AM_PM));
		
		Calendar calendar1 = new GregorianCalendar(2001, 9, 11);
		System.out.println("September 11, 2001 is a " +
				dayNameOfWeek(calendar1.get(Calendar.DAY_OF_WEEK)));

	}

	public static String dayNameOfWeek(int dayOfWeek) {
		switch (dayOfWeek) {
		case 1:
			return "SUNDAY";
		case 2:
			return "MONDAY";
		case 3:
			return "TUESDAY";
		case 4:
			return "WEDNESDAY";
		case 5:
			return "THURSDAY";
		case 6:
			return "FRIDAY";
		case 7:
			return "SATURDAY";

		default:
			return null;
		}
	}

}
