package test03;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Metode {

	public static String getDatStr(LocalDate datum) {
		return datum.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
	}
	
	public static LocalDate getDat(String datum) {
		return LocalDate.parse(datum, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
	}
	
	public static int razlikaDana(LocalDate prije, LocalDate posle) {
		return (int) ChronoUnit.DAYS.between(prije, posle);
	}
}
