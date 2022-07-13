package vezbe6.primer1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/*
 * Primeri definisanja datuma uz pomoc razlicitih klasa
 */
public class Datum {

	public static void main(String[] args) {

		LocalDate currentLocalDate = LocalDate.now();
		System.out.println("Trenutni datum: " + currentLocalDate);

		LocalDate someLocalDate = LocalDate.of(2013, 10, 1);
		System.out.println("Datum2: " + someLocalDate);
		someLocalDate = someLocalDate.withYear(2015).withMonth(5);
		System.out.println("Pojedinacna izmena datuma: " + someLocalDate);

		LocalDate parseLocalDate = LocalDate.parse("17-07-2017", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		System.out.println("Parsiranje datuma: " + parseLocalDate);

		parseLocalDate = parseLocalDate.plusDays(1).minusYears(5);
		System.out.println("Pojedinacna izmena datuma (dodavanjem, oduzimanjem) i formatiranje: "
				+ parseLocalDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));

		LocalTime currentLocalTime = LocalTime.now();
		System.out.println("Trenutno vrijeme: " + currentLocalTime);

		//LocalTime parseLocalTime = LocalTime.parse("12:44");
		LocalTime parseLocalTime = LocalTime.parse("12:44:25");
		System.out.println("Parsiranje vremena: " + parseLocalTime);

		LocalDateTime currentLocalDateTime = LocalDateTime.now();
		System.out.println("Trenutni datum i vreme: " + currentLocalDateTime);

		LocalDateTime someLocalDateTime = LocalDateTime.of(2015, Month.OCTOBER, 11, 11, 11);

		someLocalDateTime = someLocalDateTime.withYear(2015).withMonth(11).withDayOfMonth(11);
		System.out.println("Pojedinacna izmena datuma i vremena: " + someLocalDateTime);

		LocalDateTime parseLocalDateTime = LocalDateTime.parse("17.07.2017 17.33",
				DateTimeFormatter.ofPattern("dd.MM.yyyy HH.mm"));
		System.out.println("Parsiranje datuma i vremena: " + parseLocalDateTime);

		parseLocalDateTime = parseLocalDateTime.plusDays(1).minusYears(5).plusHours(10);
		System.out.println("Pojedinacna izmena datuma i vremena (dodavanjem, oduzimanjem) i formatiranje: "
				+ parseLocalDateTime.format(DateTimeFormatter.ofPattern("<dd.MM.yyyy HH:mm>")));

		ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault());
		System.out.println("Datum i vreme sa sistemskom zonom: " + zonedDateTime);

		// Pogledati dostupne zone: 
		System.out.println(ZoneId.getAvailableZoneIds());
		System.out.println("Datum i vreme sa odabranom zonom: "
				+ ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("America/Barbados")));
	}

}
