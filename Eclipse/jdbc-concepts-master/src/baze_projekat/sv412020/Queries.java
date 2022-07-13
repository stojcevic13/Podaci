package baze_projekat.sv412020;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import rs.ac.uns.ftn.db.jdbc.connection.ConnectionUtil_Basic;

public class Queries {

	public Queries() {
		
	}

	public void showQueriesMenu() {
		writeQueries();
		int option = Utility.inputNumber(1, 4);
		executeQueryOption(option);
		
	}

	private void executeQueryOption(int option) {
		if (option == 1) {
			allMachines();
		} else if (option == 2) {
			agreementDetails();
		} else if (option == 3) {
			servicesAtLeast();
		} else if (option == 4) {
			transactions();
		} else if (option == 5) {
			
		} else {
			Utility.exitApp();
		}
	}

	private void transactions() {
		// TODO Auto-generated method stub
		
	}

	private void servicesAtLeast() {
		String query = "select s.idser, s.nazser, s.grad, count(u.idug)"
				+ " from servis s, proizvodjac p, ugovor u"
				+ " where s.idser=u.idser and p.idproiz=u.idproiz"
				+ " group by s.idser, s.nazser, s.grad"
				+ " having count(u.idug) >= ?";
		
		System.out.print("n=");
		int n = Integer.parseInt(Main.sc.nextLine());
		try (Connection connection = ConnectionUtil_Basic.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			preparedStatement.setInt(1, n);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (!resultSet.isBeforeFirst()) {
					System.out.println("No rows selected!");
				} else {
					System.out.printf("%-14s %-14s %-14s %-9s\n", "IDSER", "NAZSER", "GRAD", "UGOVORA");
					while (resultSet.next()) {
						System.out.printf("%-14s %-14s %-14s %-9s\n", resultSet.getString(1),
								resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4));
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void agreementDetails() {
		String query = "select s.nazser, p.nazproiz, u.uslovi"
				+ " from servis s, proizvodjac p, ugovor u"
				+ " where s.idser=u.idser and p.idproiz=u.idproiz";
		try (Connection connection = ConnectionUtil_Basic.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (!resultSet.isBeforeFirst()) {
					System.out.println("No rows selected!");
				} else {
					System.out.printf("%-14s %-14s %-14s\n", "NAZSER", "NAZPROIZ", "USLOVI");
					while (resultSet.next()) {
						System.out.printf("%-14s %-14s %-14s\n", resultSet.getString(1),
								resultSet.getString(2), resultSet.getString(3));
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void allMachines() {
		String query = "select nazproiz, nazproiz, nazproiz from masina";
		//select * from masina where nazproiz like 'm%' order by nazproiz
		try (Connection connection = ConnectionUtil_Basic.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (!resultSet.isBeforeFirst()) {
					System.out.println("No rows selected!");
				} else {
					System.out.printf("%-4s %-14s %-4s\n", "IDMAS", "NAZMAS", "PROIZ");
					while (resultSet.next()) {
						System.out.printf("%-4s %-14s %-4s\n", resultSet.getString(1),
								resultSet.getString(2), resultSet.getString(3));
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void writeQueries() {
		System.out.println("1 - All machines begin on 'm' order by name");
		System.out.println("2 - All details about agreement");
		System.out.println("3 - Services that have at least n agreements");
		System.out.println("4 - Transactions");
		System.out.println("5 - Previous page");
		System.out.println("6 - Exit app");
	}
	
}
