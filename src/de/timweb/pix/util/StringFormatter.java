package de.timweb.pix.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class StringFormatter {
	private final static int		FRACTION_DIGIT	= 2;

	private static DecimalFormat	df_standart		= new DecimalFormat("#0.00",
															DecimalFormatSymbols.getInstance(Locale.US));
	private static DecimalFormat	df_extra		= new DecimalFormat("#0.00",
															DecimalFormatSymbols.getInstance(Locale.US));

	public static String format(double value) {
		return df_standart.format(value);
	}

	public static String format(double value, int integerDigit, int fractionDigit) {
		df_extra.setMaximumFractionDigits(fractionDigit);
		df_extra.setMinimumFractionDigits(fractionDigit);

		df_extra.setMinimumIntegerDigits(integerDigit);
		return df_extra.format(value);
	}
}
