package baze_projekat.sv412020;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import baze_projekat.sv412020.Base.Tables;
import rs.ac.uns.ftn.db.jdbc.connection.ConnectionUtil_Basic;

public class CRUD {
	
	static Scanner sc = new Scanner(System.in);
	
	
	public CRUD() {}

	public void showCRUDMenu() {
		while (true) {
			writeCRUDOptions();
			int option = Utility.inputNumber(1, 5);

			try {
				executeCRUDOption(option);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void executeCRUDOption(int option) throws SQLException {
		switch (option) {
		case 1:
			insertRow();
			break;
		case 2:
			updateRow();
			break;
		case 3:
			deleteRow();
			break;
		case 4:
			Utility.exitApp();
			break;
		default:
			System.out.println("Invalid option!");
			break;
		}
	}

	private void deleteRow() throws SQLException {
		Tables table = Base.inputTable();
		String[] keyData = inputKey(table);
		String key = keyData[0], keyName = keyData[1];

		String command = "delete from " + table.toString() + " where " + keyName + "=?";
		String command2 = "delete from proizvodjac where idproiz=90";

		try (Connection connection = ConnectionUtil_Basic.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(command);) {
			preparedStatement.setInt(1, Integer.parseInt(key));

			preparedStatement.executeUpdate();
			System.out.println("Deleted row!");
		}
	}

	private String[] inputKey(Tables table) {
		String[] keyData = new String[2];
		if (table.equals(Tables.proizvodjac)) {
			System.out.print("Idproiz: ");
			keyData[1] = "idproiz";
		}
		else if (table.equals(Tables.servis)) {
			System.out.print("Idser: ");
			keyData[1] = "idser";
		}	
		else if (table.equals(Tables.ugovor)) {
			System.out.print("Idug: ");
			keyData[1] = "idug";
		}
		else {
			System.out.print("Idmas: ");
			keyData[1] = "idmas";
		}
		
		keyData[0] = sc.nextLine();
		
		return keyData;
	}

	private void updateRow() throws SQLException {
		Tables table = Base.inputTable();
		String[] values = getValues(table);
		update(table, values);
	}

	private void update(Tables table, String[] values) throws SQLException {	
		String command = getUpdateCommand(table, values);
		
		try (Connection connection = ConnectionUtil_Basic.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(command);) {
			for (int i = 0; i < values.length; i++) {
				if (Utility.getType(values[i]).equals("int"))
					preparedStatement.setInt(i+1, Integer.parseInt(values[i]));
				else
					preparedStatement.setString(i+1, values[i]);
			}
			preparedStatement.setInt(values.length+1, Integer.parseInt(values[0]));

			preparedStatement.executeUpdate();
			System.out.println("Updated row.\n");
		}
		
	}

	private String getUpdateCommand(Tables table, String[] values) {
		String command = "";
		
		if (table.equals(Tables.proizvodjac))
			command = "update proizvodjac set idproiz=?, nazproiz=?, brrad=? where idproiz=?";
		if (table.equals(Tables.servis))
			command = "update servis set idser=?, nazser=?, grad=? where idser=?";
		if (table.equals(Tables.ugovor))
			command = "update ugovor set idug=?, idproiz=?, idser=?, uslovi=? where idug=?";
		if (table.equals(Tables.masina))
			command = "update masina set idmas=?, nazmas=?, proiz=? where idmas=?";
		
		return command;
	}

	private void insertRow() throws SQLException {
		Tables table = Base.inputTable();
		String[] values = getValues(table);
		insertIn(table, values);
	}

	private void insertIn(Tables table, String[] values) throws SQLException {
		String tableValues = "(";
		for (int i = 0; i < values.length; i++) {
			String valtype = Utility.getType(values[i]);
			if (valtype == "int")
				tableValues += values[i];
			else
				tableValues += "'" + values[i] + "'";
			if (i != values.length-1)
				tableValues += ", ";
		}
		tableValues += ")";
		String tableAttributes = getAttributes(table);
		
		String command = "insert into " + table.toString() + " " + tableAttributes + " values " + tableValues;
		Base.executeSimple(command);
	}

	private String getAttributes(Tables table) {
		if (table.equals(Tables.proizvodjac))
			return "(idproiz, nazproiz, brrad)";
		else if (table.equals(Tables.servis))
			return "(idser, nazser, grad)";
		else if (table.equals(Tables.ugovor))
			return "(idug, idser, idproiz, uslovi)";
		else
			return "(idmas, nazmas, proiz)";
	}

	private String[] getValues(Tables table) {
		if (table.equals(Tables.proizvodjac))
			return inputProizvodjacValues();
		else if (table.equals(Tables.servis))
			return inputServisValues();
		else if (table.equals(Tables.servis))
			return inputUgovorValues();
		else
			return inputMasinaValues();
	}	


	private String[] inputMasinaValues() {
		String[] values = new String[3];
		
		System.out.print("Idmas: ");
		values[0] = sc.nextLine();
		System.out.print("Nazmas: ");
		values[1] = sc.nextLine();
		System.out.print("Proiz: ");
		values[2] = sc.nextLine();
		
		return values;
	}

	private String[] inputUgovorValues() {
		String[] values = new String[6];
		
		System.out.print("Idug: ");
		values[0] = sc.nextLine();
		System.out.print("Idser: ");
		values[1] = sc.nextLine();
		System.out.print("Idproiz: ");
		values[2] = sc.nextLine();
		System.out.print("Datskl: ");
		values[3] = sc.nextLine();
		System.out.print("Trajanje: ");
		values[4] = sc.nextLine();
		System.out.print("Uslovi: ");
		values[5] = sc.nextLine();
		
		return values;
	}

	private String[] inputServisValues() {
		String[] values = new String[3];
		
		System.out.print("Idser: ");
		values[0] = sc.nextLine();
		System.out.print("Nazser: ");
		values[1] = sc.nextLine();
		System.out.print("Grad: ");
		values[2] = sc.nextLine();
		
		return values;
	}

	private String[] inputProizvodjacValues() {
		String[] values = new String[3];
		
		System.out.print("Idproiz: ");
		values[0] = sc.nextLine();
		System.out.print("Nazproiz: ");
		values[1] = sc.nextLine();
		System.out.print("brrad: ");
		values[2] = sc.nextLine();
		
		return values;
	}

	

	private void writeCRUDOptions() {
		System.out.println("1 - Insert new row");
		System.out.println("2 - Update existing row");
		System.out.println("3 - Delete existing row");
		System.out.println("4 - Previous page");
		System.out.println("5 - Exit app");
	}

}
