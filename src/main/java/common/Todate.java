package common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Todate {
	
	public static Date toDate(String date,String format
			){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date1=null;
		try {
			date1 = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date1 ;
	}

}
