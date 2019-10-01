/* Joda Ace by Javier Santo Domingo (j-a-s-d@coderesearchlabs.com) */

package ace.date;

/**
 * Joda Ace class.
 */
import ace.Ace;
import ace.SemanticVersion;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Date extends Ace {

	/**
	 * Joda Ace version.
	 */
	public static final SemanticVersion JODA_ACE_VERSION = SemanticVersion.fromString("1.0.0");

	public static DateTimeZone TIME_ZONE = null;

	public static final String FORMAT_YMD = "yyyy-MM-dd";

	public static final String FORMAT_YMD_HM = "yyyy-MM-dd HH:mm";

	public static final String FORMAT_YMD_HMS = "yyyy-MM-dd HH:mm:ss";

	public static final String FORMAT_YMD_HMS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";

	Date() {}

	public static DateTime now() {
		return new DateTime(TIME_ZONE);
	}

	public static DateTime make(final long milliseconds) {
		return new DateTime(milliseconds, TIME_ZONE);
	}

	public static DateTimeFormatter makeFormatter(final String literalFormat) {
		return DateTimeFormat.forPattern(literalFormat);
	}

	public static String format(final DateTime date, final DateTimeFormatter formatter) {
		return formatter.print(date);
	}

	public static String format(final DateTime date, final String literalFormat) {
		return format(date, makeFormatter(literalFormat));
	}

	public static String formatNow(final String literalFormat) {
		return formatNow(makeFormatter(literalFormat));
	}

	public static String formatNow(final DateTimeFormatter formatter) {
		return format(new DateTime(TIME_ZONE), formatter);
	}

	public static DateTime parse(final String literalFormat, final String date) {
		return makeFormatter(literalFormat).parseDateTime(date);
	}

	public static DateTime parse(final DateTimeFormatter formatter, final String date) {
		return formatter.parseDateTime(date);
	}

}

