package by.ansgar.helper.util;

import java.util.Calendar;

public class Date {

	static Calendar calendar = Calendar.getInstance();

	public static int year = calendar.get(Calendar.YEAR);
	public static int month = calendar.get(Calendar.MONTH);
	public static int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
	public static int hour = calendar.get(Calendar.HOUR_OF_DAY);
	public static int min = calendar.get(Calendar.MINUTE);

}
