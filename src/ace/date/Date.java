/* Joda Ace by Javier Santo Domingo (j-a-s-d@coderesearchlabs.com) */

package ace.date;

import ace.Ace;
import ace.SemanticVersion;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Joda Ace class.
 */
public class Date extends Ace {

	/**
	 * Joda Ace version.
	 */
	public static final SemanticVersion JODA_ACE_VERSION = SemanticVersion.fromString("1.1.0");

	/**
	 * Date time zone used.
	 */
	public static DateTimeZone TIME_ZONE = null;

	/**
	 * Constant used to print a date in the 'yyyy-MM-dd' format.
	 */
	public static final String FORMAT_YMD = "yyyy-MM-dd";

	/**
	 * Constant used to print a date time in the 'yyyy-MM-dd HH:mm' format.
	 */
	public static final String FORMAT_YMD_HM = "yyyy-MM-dd HH:mm";

	/**
	 * Constant used to print a date time in the 'yyyy-MM-dd HH:mm:ss' format.
	 */
	public static final String FORMAT_YMD_HMS = "yyyy-MM-dd HH:mm:ss";

	/**
	 * Constant used to print a date time in the 'yyyy-MM-dd HH:mm:ss.SSS' format.
	 */
	public static final String FORMAT_YMD_HMS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";

	Date() {}

	/**
	 * Gets a date time instance for the current moment.
	 * 
	 * @return the resulting date time instance
	 */
	public static DateTime now() {
		return new DateTime(TIME_ZONE);
	}

	/**
	 * Makes a date time instance for the specified milliseconds value.
	 * 
	 * @param milliseconds
	 * @return the resulting date time instance
	 */
	public static DateTime make(final long milliseconds) {
		return new DateTime(milliseconds, TIME_ZONE);
	}

	/**
	 * Makes a date time formatter instance for the specified literal format.
	 * 
	 * @param literalFormat
	 * @return the resulting date time formatter instance
	 */
	public static DateTimeFormatter makeFormatter(final String literalFormat) {
		return DateTimeFormat.forPattern(literalFormat);
	}

	/**
	 * Formats as string the date time value of specified date time instance with the specified date time formatter instance.
	 * 
	 * @param date
	 * @param formatter
	 * @return the resulting formatted string
	 */
	public static String format(final DateTime date, final DateTimeFormatter formatter) {
		return formatter.print(date);
	}

	/**
	 * Formats as string the date time value of specified date time instance with the specified literal format string.
	 * 
	 * @param date
	 * @param literalFormat
	 * @return the resulting formatted string
	 */
	public static String format(final DateTime date, final String literalFormat) {
		return format(date, makeFormatter(literalFormat));
	}

	/**
	 * Formats the current date time with the specified literal format string.
	 * 
	 * @param literalFormat
	 * @return the resulting formatted string
	 */
	public static String formatNow(final String literalFormat) {
		return formatNow(makeFormatter(literalFormat));
	}

	/**
	 * Formats the current date time with the specified date time formatter instance.
	 * 
	 * @param formatter
	 * @return the resulting formatted string
	 */
	public static String formatNow(final DateTimeFormatter formatter) {
		return format(new DateTime(TIME_ZONE), formatter);
	}

	/**
	 * Parses the specified string with the specified literal format.
	 * 
	 * @param literalFormat
	 * @param value
	 * @return the resulting date time instance
	 */
	public static DateTime parse(final String literalFormat, final String value) {
		return makeFormatter(literalFormat).parseDateTime(value);
	}

	/**
	 * Parses the specified string with the specified formatter.
	 * 
	 * @param formatter
	 * @param value
	 * @return the resulting date time instance
	 */
	public static DateTime parse(final DateTimeFormatter formatter, final String value) {
		return formatter.parseDateTime(value);
	}

}

