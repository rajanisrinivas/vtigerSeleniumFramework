package com.crm.generic.webdriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandomNum() {
		Random r=new Random();
		int num=r.nextInt(5000);
		return num;
	}
	
	public String getSystemDateInyyyyMMdd() {
		Date dateObj=new Date();
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
		String date = s.format(dateObj);
		return date;
	}
	
	public String getRequiredDateyyyyMMdd(int days) {
		/*Date date = new Date(); // creates object of Date with current date, time and timezone details
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
		s.format(date);
		Calendar cal = s.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		Date dateObj = cal.getTime();
		String requiredDate = s.format(dateObj);
		*/
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // creates format for date

        Calendar calndr = Calendar.getInstance();
        calndr.add(Calendar.DAY_OF_MONTH, 30);
        String requiredDate = dateFormat.format(calndr.getTime());
        return requiredDate;
	}
}
