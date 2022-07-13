package baze_projekat.sv412020;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import rs.ac.uns.ftn.db.jdbc.connection.ConnectionUtil_Basic;

public class Reports {

	public Reports() {
		
	}

	public void showReportsMenu() {
		report1();
		
	}

	private void report1() {
		String query = "select r.idr, r.nazivr, sum(komp.cena*konf.komada)"
				+ " from racunar r, konfiguracija konf, komponenta komp"
				+ " where r.idr=konf.idr and konf.idk=komp.idk"
				+ " group by r.idr, r.nazivr"
				+ " order by r.nazivr";

		try (Connection connection = ConnectionUtil_Basic.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (!resultSet.isBeforeFirst()) {
					System.out.println("No rows selected!");
				} else {
					System.out.printf("%-14s %-14s %-14s %-9s\n", "NAZSER", "NAZPROIZ", "USLOVI", "UGOVORA");
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
	
}
