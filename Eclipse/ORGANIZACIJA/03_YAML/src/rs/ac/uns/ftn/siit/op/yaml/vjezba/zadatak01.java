package rs.ac.uns.ftn.siit.op.yaml.vjezba;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import rs.ac.uns.ftn.siit.op.yaml.vjezba.ex3.Address;
import rs.ac.uns.ftn.siit.op.yaml.vjezba.ex3.Invoice;

public class zadatak01 {
	
	static Scanner sc = new Scanner(System.in);
	
	static final String YAML_INPUT_FILE = "resources/invoice.yaml";
	static final String YAML_OUTPUT_FILE = "resources/invoice.yaml"; 
	
	static Invoice invoice;

	public static void main(String[] args) {
		
		loadData(YAML_INPUT_FILE);
		
		Address newAddress = inputAddress();
		invoice.getBillTo().setAddress(newAddress);
		
		saveData(YAML_OUTPUT_FILE);
		System.out.println("\nPodaci su uspjesno sacuvani.");
	}

	private static void saveData(String yamlOutputFile) {
		
		DumperOptions dumperOptions = new DumperOptions();
		dumperOptions.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
		dumperOptions.setIndent(4);
		Yaml yaml = new Yaml(dumperOptions);
		
		try {
			yaml.dump(invoice, new FileWriter("resources/invoice_mod.yaml"));
		} catch (IOException e) {
			System.out.println("Desila se greska!");
		}
		
		
	}

	private static void loadData(String yamlInputFile) {
		
		try(InputStream input = new FileInputStream(new File(yamlInputFile))) {
			
			Yaml yaml = new Yaml(new Constructor(Invoice.class));
			invoice = (Invoice) yaml.load(input);

			
		} catch (FileNotFoundException e) {
			System.out.println("Fajl nije pronadjen!");
		} catch (IOException e) {
			System.out.println("Desila se greska!");
		}
		
	}

	private static Address inputAddress() {
		
		System.out.println("Unesite podatke o novoj adresi klijenta.");
		
		System.out.print("Lines: ");
		String lines = sc.nextLine();
		System.out.print("City: ");
		String city = sc.nextLine();
		System.out.print("State: ");
		String state = sc.nextLine();
		System.out.print("Postal: ");
		int postal = sc.nextInt();
		
		sc.close();
		
		return new Address(lines, city, state, postal);
	}
	
}
