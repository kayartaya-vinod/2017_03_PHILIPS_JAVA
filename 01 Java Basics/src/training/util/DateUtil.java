package training.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtil {
	
	private static SimpleDateFormat df;
	
	static {
		df = new SimpleDateFormat("dd-MM-yyyy");
	}

	private DateUtil() {
	}

	public static Date parse(String date) {
		try {
			return df.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

	public static String format(Date date) {
		return df.format(date);
	}
}
