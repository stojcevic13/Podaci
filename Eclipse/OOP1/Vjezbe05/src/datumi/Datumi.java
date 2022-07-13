package datumi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

public class Datumi {

	public static void main(String[] args) {
		
		LocalDate sad = LocalDate.now();
		System.out.println(sad);
		
		LocalDate datum = LocalDate.of(2013, 7, 24);
		System.out.println(datum);
		datum = datum.withDayOfMonth(13);
		System.out.println(datum);
		
		LocalDate datum2 = LocalDate.parse("17.07.2021", DateTimeFormatter.ofPattern("dd.MM.yyyy"));
		System.out.println(datum2);
		datum2 = datum2.plusDays(1).minusMonths(1);
		System.out.println(datum2);
		System.out.println(datum2.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
		
		LocalDate datum3 = LocalDate.of(2021, 11, 15);
		System.out.println(datum3.format(DateTimeFormatter.ofPattern("dd.MM.yyyy.")));
		
		LocalTime vrijeme = LocalTime.parse("15-23", DateTimeFormatter.ofPattern("HH-mm"));
		System.out.println(vrijeme);
		System.out.println(vrijeme.format(DateTimeFormatter.ofPattern("HH;mm")));
		
	
	}

}
