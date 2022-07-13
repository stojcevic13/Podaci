package baze_projekat.sv412020;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import rs.ac.uns.ftn.db.jdbc.connection.ConnectionUtil_Basic;

public class Base {
	
	public enum Tables {
		proizvodjac,
		servis,
		ugovor,
		masina
	}
	
	public static void dropTables() {
		try {
			executeSimple("drop table " + Tables.proizvodjac);
			executeSimple("drop table " + Tables.servis);
			executeSimple("drop table " + Tables.ugovor);
			executeSimple("drop table " + Tables.masina);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static final boolean executeSimple(String command) throws SQLException {
		try (Connection connection = ConnectionUtil_Basic.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(command);) {
			
			return preparedStatement.execute(command);
		}
	}

	public static Tables inputTable() {
		writeTables();
		int option = Utility.inputNumber(1,  4);
		return Tables.values()[option-1];
	}

	private static void writeTables() {
		System.out.println("1 - proizvodjac");
		System.out.println("2 - servis");
		System.out.println("3 - ugovor");
		System.out.println("4 - masina");
	}
	
	
	public static void main(String[] args) {
		System.out.println(inputTable());
	}
}
