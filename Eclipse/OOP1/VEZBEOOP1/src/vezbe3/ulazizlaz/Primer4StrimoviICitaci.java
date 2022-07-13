package vezbe3.ulazizlaz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Primer4StrimoviICitaci {

	public static void main(String[] args) {

		System.out.println("Nacin 1:");
		//citanje teksta sa strimom
		InputStreamReader inStream = new InputStreamReader(System.in);
		
		char [] charBuff = new char [100];
		int brojKaraktera = 0;
		try {
			System.out.print("Unesi tekst: ");
			brojKaraktera =  inStream.read(charBuff);
		} catch(IOException e) {
			e.printStackTrace();
		}
		System.out.print("Tekst je: ");
		for(int i = 0; i < brojKaraktera; i++) {
			System.out.print(charBuff[i]);
		}
		
		System.out.println("\nNacin 2: ");
		//citanje teksta sa Citacem
		BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		try {
			System.out.print("Unesi tekst: ");
			s = inReader.readLine();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Tekst je: " + s);

		try {
			inStream.close();
			inReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Program izvrsen");
		
	}

}
