package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class addDays {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		System.out.println("Enter the  date:");
		String d=s.nextLine();
		System.out.println("Enter the  no of days needs to be added:");
		int n=s.nextInt();
		System.out.println(addDay(d,n));
		
	}
	
	public static String addDay(String date,int n) throws ParseException
	{
		SimpleDateFormat format=new SimpleDateFormat("MM/dd/yyyy");
		Date d=format.parse(date);
		Calendar c=Calendar.getInstance();
		c.setTime(d);
		c.add(Calendar.DAY_OF_MONTH,n);
		String newDate=format.format(c.getTime());
		return newDate;
	}

}
