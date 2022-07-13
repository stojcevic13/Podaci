package baze_projekat.sv412020;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Utility {

	public static void main(String[] args) {

	}

	public static int inputNumber(int lowerLimit, int upperLimit) {
		//Scanner sc2 = new Scanner(System.in);
		while (true) {
			try {
				System.out.print(">>> ");
				
				int number = Integer.parseInt(Main.sc.nextLine());
				if (number < lowerLimit || number > upperLimit) {
					System.out.printf("Number must be between %d and %d!\n", lowerLimit, upperLimit);
					continue;
				}
				//sc2.close();
				return number;
			} catch (NumberFormatException e) {
				System.out.println("You must enter a number!");
			}
		}
	}

	public static void exitApp() {
		System.exit(0);

	}

	public static String getType(String value) {
		try {
			Integer.parseInt(value);
			return "int";
		} catch (NumberFormatException e) {
			return "string";
		}
	}

}
