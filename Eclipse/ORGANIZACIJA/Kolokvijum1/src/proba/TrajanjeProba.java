package proba;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TrajanjeProba {

	public static void main(String[] args) {
		
		String s1 = "12:00";
		String s2 = "12:42";
		LocalTime time1 = LocalTime.parse(s1, DateTimeFormatter.ofPattern("HH:mm"));
		LocalTime time2 = LocalTime.parse(s2, DateTimeFormatter.ofPattern("HH:mm"));
		System.out.println(time1);
		System.out.println(time2);
		int a1 = (int) ChronoUnit.MINUTES.between(time1, time2);
		int a2 = (int) Duration.between(time1, time2).toMinutes();
		System.out.println(a1);
		System.out.println(a2);
		
		
		
		String s3 = "21.12.2012.";
		String s4 = "23.12.2012.";
		LocalDate date1 = LocalDate.parse(s3, DateTimeFormatter.ofPattern("dd.MM.yyyy."));
		LocalDate date2 = LocalDate.parse(s4, DateTimeFormatter.ofPattern("dd.MM.yyyy."));
//		int b1 = (int) Duration.between(date1, date2).toDays();
		int b2 = (int) ChronoUnit.DAYS.between(date1, date2);
//		System.out.println(b1);
		System.out.println(b2);

		
	}

}
