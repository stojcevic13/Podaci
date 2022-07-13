package zadatak05;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Utility {
	
	@SuppressWarnings("resource")
	public static int inputNumber(String message) {
		Scanner sc = new Scanner(System.in);
		int number;
		while (true) {
			System.out.print(message);
			try {
				number = sc.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("Pogresan unos! Pokusajte ponovo.\n");
				sc.next();
			}
		}
		return number;
	}

	
	public static LocalDate getLocalDate(String dateStr) {
		return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd.MM.yyyy."));
	}	

	
	public static void main(String[] args) {
		int a = inputNumber("a: ");
		System.out.println(a);
		int b = inputNumber("b: ");
		System.out.println(b);
	}
	
	
	
}
