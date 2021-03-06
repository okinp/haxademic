package com.haxademic.core.text;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import com.haxademic.core.app.P;

public class StringFormatter {

	public static String timeFromSeconds( int seconds, boolean showHours ) {
		int h = (int) Math.floor(seconds / 3600f);
		int m = (int) Math.floor(seconds % 3600f / 60f);
		int s = (int) Math.floor(seconds % 3600f % 60);
		String hStr = (h < 10 ? "0" : "") + h;
		String mStr = (m < 10 ? "0" : "") + m;
		String sStr = (s < 10 ? "0" : "") + s;
		if( showHours == true ) {
			return hStr + ':' + mStr + ':' +sStr;
		} else {
			return mStr + ':' +sStr;
		}
	};

	public static String formatTimeFromSeconds( int seconds ) {
		int minutes = P.floor( seconds / 60f );
		int secondsOnly = seconds % 60;
		String secondsText = ( secondsOnly < 10 ) ? "0"+secondsOnly : ""+secondsOnly;
		String minutesText = ( minutes < 10 ) ? "0"+minutes : ""+minutes;
		return minutesText+":"+secondsText;
	}
	
	public static String timeFromMilliseconds( int millies, boolean showHours ) {
		return StringFormatter.timeFromSeconds( (int) Math.round( millies * 0.001f ), showHours );
	}
	
	public static String formattedDecimal(String number) {
		double amount = Double.parseDouble(number);
		DecimalFormat formatter = new DecimalFormat("#,###.00");
		return formatter.format(amount);
	}
	
	public static String formattedInteger(int number) {
		return NumberFormat.getInstance().format(number);
	}
}
