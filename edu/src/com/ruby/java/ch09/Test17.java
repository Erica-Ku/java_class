package com.ruby.java.ch09;

import java.util.Calendar;
import java.util.Date;

public class Test17 {

	public static void main(String[] args) throws InterruptedException {
		//Date d = new Date();
		//System.out.println(d);
		
		//Calendar c = Calendar.getInstance();
		
		/*System.out.println(c.get(Calendar.YEAR));
		System.out.println(c.get(Calendar.MONTH) + 1);
		System.out.println(c.get(Calendar.DAY_OF_MONTH));
		System.out.println(c.get(Calendar.HOUR));
		System.out.println(c.get(Calendar.MINUTE));*/
		
		for(int i = 0; i < 10; i++) {
			Calendar c = Calendar.getInstance();
			Date d = new Date();
			System.out.print(c.get(Calendar.YEAR) + "년");
			System.out.print(c.get(Calendar.MONTH) + 1 + "월");
			System.out.print(c.get(Calendar.DAY_OF_MONTH) + "일");
			System.out.print(c.get(Calendar.HOUR) + "시");
			System.out.print(c.get(Calendar.MINUTE) + "분");
			System.out.println(c.get(Calendar.SECOND) + "초");
			Thread.sleep(1000);
		}
	}
}