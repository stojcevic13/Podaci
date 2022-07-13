package baze_projekat.sv412020;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import baze_projekat.sv412020.Base.Tables;
import baze_projekat.sv412020.reports.Report;
import rs.ac.uns.ftn.db.jdbc.connection.ConnectionUtil_Basic;

public class Main {
	static Scanner sc = new Scanner(System.in);
	
	static CRUD crud = new CRUD();
	static Queries queries = new Queries();
	static Reports reports = new Reports();

	public static void main(String[] args) {

		//Report.createTables();
		//Report.populateData();
		
		showMainMenu();
		
		//Report.dropTables();

		sc.close();

	}

	private static void showMainMenu() {
		writeMainOptions();
		int option = Utility.inputNumber(1, 4);
		executeMainOption(option);
	}
	
	private static void executeMainOption(int option) {
		switch (option) {
		case 1:
			crud.showCRUDMenu();
			break;
		case 2:
			queries.showQueriesMenu();
			break;
		case 3:
			reports.showReportsMenu();
			break;
		case 4:
			Utility.exitApp();
//			Base.dropTables();
//			System.out.println("Tables are dropped, you have exited the application.");
//			System.exit(0);
			break;
		default:
			System.out.println("Invalid option!");
			break;
		}
		
	}

	private static void writeMainOptions() {
		System.out.println("1 - CRUD operations");
		System.out.println("2 - Queries");
		System.out.println("3 - Reports");
		System.out.println("4 - Exit");
	}

	private static void createAndFillTables() {
		createTables();
		fillTables();
	}
	
	private static void createTables() {
		createServis();
		createProizvodjac();
		createUgovor();
		createMasina();
	}

	private static void createMasina() {
		String command = "CREATE TABLE masina\r\n"
				+ "	(\r\n"
				+ "	 Idmas integer not null,\r\n"
				+ "	 Nazproiz varchar(20),\r\n"
				+ "     proiz integer not null,\r\n"
				+ "     \r\n"
				+ "	 CONSTRAINT masina_PK PRIMARY KEY (Idmas),\r\n"
				+ "	 CONSTRAINT masina_FK FOREIGN KEY (proiz) REFERENCES proizvodjac(Idproiz)\r\n"
				+ ");";
		try {
			executeSimple(command);
			System.out.println("Successfully created table masina!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void createUgovor() {
		String command = "CREATE TABLE ugovor\r\n"
				+ "	(\r\n"
				+ "     Idug integer NOT NULL,\r\n"
				+ "	 Idser integer NOT NULL,\r\n"
				+ "	 Idproiz integer NOT NULL,\r\n"
				+ "     uslovi varchar(200),\r\n"
				+ "	 CONSTRAINT ugovor_PK PRIMARY KEY (idug),\r\n"
				+ "	 CONSTRAINT ugovor_ser_FK FOREIGN KEY (Idser) REFERENCES servis(Idser),\r\n"
				+ "	 CONSTRAINT ugovor_proiz_FK FOREIGN KEY (Idproiz) REFERENCES proizvodjac(Idproiz)\r\n"
				+ ");";
		try {
			executeSimple(command);
			System.out.println("Successfully created table ugovor!");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void createProizvodjac() {
		String command = "CREATE TABLE proizvodjac\r\n"
				+ "	(\r\n"
				+ "	 Idproiz integer not null,\r\n"
				+ "	 Nazproiz varchar(20),\r\n"
				+ "     Brrad integer not null,\r\n"
				+ "     \r\n"
				+ "	 CONSTRAINT proizvodjac_PK PRIMARY KEY (Idproiz),\r\n"
				+ "     CONSTRAINT proizvodjac_UK UNIQUE (Nazproiz)\r\n"
				+ ");";
		try {
			executeSimple(command);
			System.out.println("Successfully created table proizvodjac!");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void createServis() {
		String command = "CREATE TABLE servis(\r\n"
				+ "	 Idser integer NOT NULL,\r\n"
				+ "	 Nazser varchar(20) NOT NULL,\r\n"
				+ "	 Grad varchar(20) NOT NULL,\r\n"
				+ "     \r\n"
				+ "	 CONSTRAINT servis_PK PRIMARY KEY (Idser),\r\n"
				+ "     CONSTRAINT servis_UK UNIQUE (Nazser)\r\n"
				+ ");";
		
		try {
			executeSimple(command);
			System.out.println("Successfully created table Servis!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static void fillTables() {
		try {
			fillProizvodjac();
			fillServis();
			fillUgovor();
			fillMasina();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	private static void fillMasina() throws SQLException {
		List<String> masine = new ArrayList<String>();
		for (int i = 1; i < 10; i++) {
			String command = String.format("insert into masina values (%d, 'masina%d', %d);", i, i, i);
			Base.executeSimple(command);
		}
		masine.add("insert into masina values (31, 'masina31', 1);");
	}

	private static void fillUgovor() throws SQLException {
		List<String> ugovori = new ArrayList<String>();
		for (int i = 1; i < 40; i+=4) {
			String command1 = String.format("insert into ugovor values (%d, '%d', %d, uslovi%d);", i, i%10, i%10, i);
			String command2 = String.format("insert into ugovor values (%d, '%d', %d, uslovi%d);", i+1, i%10, (i+1)%10, i+1);
			String command3 = String.format("insert into ugovor values (%d, '%d', %d, uslovi%d);", i+2, i%10, (i+2)%10, i+2);
			String command4 = String.format("insert into ugovor values (%d, '%d', %d, uslovi%d);", i+3, i%10, (i+3)%10, i+3);
			Base.executeSimple(command1);
			Base.executeSimple(command2);
			Base.executeSimple(command3);
			Base.executeSimple(command4);
		}
	}

	private static void fillServis() throws SQLException {
		for (int i = 1; i < 10; i++) {
			String city = (i % 4 == 0) ? "Beograd" : "Brcko";
			String command = String.format("insert into servis values (%d, 'servis%d', %s);", i, i, city);
			Base.executeSimple(command);
		}
	}

	private static void fillProizvodjac() throws SQLException {
		for (int i = 1; i < 10; i++) {
			String command = String.format("insert into proizvodjac values (%d, 'proizvodjac%d', %d);", i, i, i*5);
			Base.executeSimple(command);
		}
	}

	private static void handleMenu() {
		String response = null;
		do {
			System.out.println("\nChoose and option:");
			System.out.println("1 - Select all rows from table");
			System.out.println("2 - Select row from table by primary key");
			System.out.println("3 - Insert row into table");
			System.out.println("4 - Modify existing row from table");
			System.out.println("5 - Delete existing row from table");
			System.out.println("6 - Drop table");
			System.out.println("X - Exit");

			response = sc.nextLine();

			try {
				switch (response) {
				case "1":
					selectAll();
					break;
				case "2":
					selectBySprAndSfp();
					break;
				case "3":
					insertRow();
					break;
				case "4":
					modifyRow();
					break;
				case "5":
					deleteRow();
					break;
				case "6":
					dropTableFazeProjekta();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		} while (!response.equalsIgnoreCase("X"));

	}

	private static void selectAll() throws SQLException {
		String query = "select * from masina";

		try (Connection connection = ConnectionUtil_Basic.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			System.out.printf("%-4s %-4s %-6s %-20s %-21s\n", "SPR", "SFP", "RUKFP", "NAFP", "DATP");

			while (resultSet.next()) {
				System.out.printf("%-4s %-4s %-6s %-20s %-21s\n", resultSet.getString(1), resultSet.getString(2),
						resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
			}

		}
	}

	private static void selectBySprAndSfp() throws SQLException {
		System.out.print("Table name: ");
		String table = sc.nextLine();

		String query = "select * from " + table + " where spr = ? and sfp = ?";

		try (Connection connection = ConnectionUtil_Basic.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {

			System.out.println("SPR: ");
			preparedStatement.setInt(1, Integer.parseInt(sc.nextLine()));
			System.out.println("SFP: ");
			preparedStatement.setInt(2, Integer.parseInt(sc.nextLine()));

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (!resultSet.isBeforeFirst()) {
					System.out.println("No rows selected!");

				} else {
					System.out.printf("%-4s %-4s %-6s %-20s %-21s\n", "SPR", "SFP", "RUKFP", "NAFP", "DATP");
					while (resultSet.next()) {
						System.out.printf("%-4s %-4s %-6s %-20s %-21s\n", resultSet.getString(1),
								resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),
								resultSet.getString(5));
					}
				}
			}
		}

	}

	private static void insertRow() throws SQLException {
		System.out.print("Table name: ");
		String table = sc.nextLine();
		
		System.out.println("SPR: ");
		String spr = sc.nextLine();
		System.out.println("SFP: ");
		String sfp = sc.nextLine();
		System.out.println("RUKFP: ");
		String rukfp = sc.nextLine();
		System.out.println("NAFP: ");
		String nafp = sc.nextLine();
		System.out.println("DATP: ");
		String datp = sc.nextLine();

		String command = "insert into faze_projekta (spr, sfp, rukfp, nafp, datp) values (?, ?, ?, ?, to_date(?, 'dd.MM.yyyy.'))";

		try (Connection connection = ConnectionUtil_Basic.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(command);) {
			preparedStatement.setInt(1, Integer.parseInt(spr));
			preparedStatement.setInt(2, Integer.parseInt(sfp));
			preparedStatement.setInt(3, Integer.parseInt(rukfp));
			preparedStatement.setString(4, nafp);
			preparedStatement.setString(5, datp);

			preparedStatement.executeUpdate();

			System.out.println("Row sucessfully inserted");

		}

	}

	private static void deleteRow() throws SQLException {
		System.out.print("Table name: ");
		String table = sc.nextLine();
		
		System.out.println("SPR: ");
		String spr = sc.nextLine();
		System.out.println("SFP: ");
		String sfp = sc.nextLine();

		String command = "delete from proizvodjac where idproiz=91";

		try (Connection connection = ConnectionUtil_Basic.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(command);) {
			preparedStatement.setInt(1, Integer.parseInt(spr));
			preparedStatement.setInt(2, Integer.parseInt(sfp));

			System.out.printf("%d row(s) affected by delete!", preparedStatement.executeUpdate());
		}
	}

	private static void modifyRow() throws SQLException {
		System.out.print("Table name: ");
		String table = sc.nextLine();
		
		String command = "update faze_projekta set rukfp=?, nafp=?, datp=to_date(?, 'dd.MM.yyyy.') where spr=? and sfp=?";

		System.out.println("SPR: ");
		String spr = sc.nextLine();
		System.out.println("SFP: ");
		String sfp = sc.nextLine();
		System.out.println("RUKFP: ");
		String rukfp = sc.nextLine();
		System.out.println("NAFP: ");
		String nafp = sc.nextLine();
		System.out.println("DATP: ");
		String datp = sc.nextLine();

		try (Connection connection = ConnectionUtil_Basic.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(command);) {
			preparedStatement.setInt(1, Integer.parseInt(rukfp));
			preparedStatement.setString(2, nafp);
			preparedStatement.setString(3, datp);
			preparedStatement.setInt(4, Integer.parseInt(spr));
			preparedStatement.setInt(5, Integer.parseInt(sfp));

			System.out.printf("%d row(s) affected by update!", preparedStatement.executeUpdate());

		}
	}

	private static final boolean executeSimple(String command) throws SQLException {
		try (Connection connection = ConnectionUtil_Basic.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(command);) {

			return preparedStatement.execute(command);
		}
	}

	private static void createTableFazeProjekta() {
		String command = "create table faze_projekta (spr int, sfp int, rukfp int, nafp varchar2(10), datp date,"
				+ "constraint fp_pk primary key (spr, sfp), constraint fp_fk foreign key (rukfp) references radnik(mbr))";
		try {
			executeSimple(command);
			System.out.println("Successfully created table Faze_projekta!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void dropTableFazeProjekta() throws SQLException {
		String command = "drop table faze_projekta";

		executeSimple(command);
		System.out.println("Table Faze_Projekta successfully dropped!");

	}
}
