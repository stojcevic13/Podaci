package baze_projekat.sv412020.reports;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import rs.ac.uns.ftn.db.jdbc.connection.ConnectionUtil_Basic;
import baze_projekat.sv412020.*;
//import rs.ac.uns.ftn.db.jdbc.report.dto.ExtendedComputer;
//import rs.ac.uns.ftn.db.jdbc.report.util.ReportUtil;

public class Report {

	private static String tablesFile = "tables.sql";
	private static String dataFile = "data.sql";
	private static String dropTablesFile = "drop_tables.sql";

	public static void main(String[] args) {
		ReportUtil.baseResourcePath = "resources/computer_configuration/";

		//createTables();

		//populateData();
		
		generateReport();
		System.out.println("\n\n---------------------------------------------------------------------------------------\n\n");
		generateReport1();

		//dropTables();

	}

	public static void createTables() {
		try {
			ReportUtil.baseResourcePath = "resources/computer_configuration/";
			String[] commands = ReportUtil.getCommandsFromFile(tablesFile);
			ReportUtil.executeCommands(commands);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void populateData() {
		try (Connection connection = ConnectionUtil_Basic.getConnection();
				Statement statement = connection.createStatement()) {
			ReportUtil.baseResourcePath = "resources/computer_configuration/";
			connection.setAutoCommit(false);
			String[] commands = ReportUtil.getCommandsFromFile(dataFile);

			try {
				for (String command : commands) {
					statement.execute(command);
				}
				connection.commit();
			} catch (SQLException e) {
				connection.rollback();
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	public static void generateReport() {
		final String getServisi = "select idser, nazser from servis order by nazser";
		//final String getExtendedComponents = "select kp.nazivk, kp.tip, kp.proizvodjac, kp.cena*kf.komada ukupna_cena_za_komponentu from komponenta kp left outer join konfiguracija kf on kp.idk = kf.idk where kf.idr = ? order by ukupna_cena_za_komponentu desc";
		final String getExtendedProizvodjaci = "select p.nazproiz, p.brrad radnika from proizvodjac p, ugovor u where u.idproiz=p.idproiz and u.idser=? order by radnika desc";

		List<ExtendedServis> extendedServisi = new ArrayList<>();

		try (Connection connection = ConnectionUtil_Basic.getConnection();
				PreparedStatement psServisi = connection.prepareStatement(getServisi);
				PreparedStatement psExtendedProizvodjaci = connection.prepareStatement(getExtendedProizvodjaci);) {
			
			ResultSet rsServisi = psServisi.executeQuery();

			if (!rsServisi.isBeforeFirst()) {
				System.out.println("No matching servis items!");
				return;
			}

			while (rsServisi.next()) {
				int servisId = rsServisi.getInt("idser");
				String servisName = rsServisi.getString("nazser");
				
				ExtendedServis extendedServis = new ExtendedServis(servisId, servisName);
				extendedServisi.add(extendedServis);

				psExtendedProizvodjaci.setInt(1, servisId);
				ResultSet rsExtendedProizvodjac = psExtendedProizvodjaci.executeQuery();

				if (!rsExtendedProizvodjac.isBeforeFirst()) {
					continue;
				}

				int ukupnoRadnika = 0;
				int brProizvodjaca = 0;

				while (rsExtendedProizvodjac.next()) {
					String componentName = rsExtendedProizvodjac.getString(1);
					int brRadnika = rsExtendedProizvodjac.getInt(2);
					extendedServis.getExtendedComponents().add(new ExtendedProizvodjac(componentName, brRadnika));

					ukupnoRadnika += brRadnika;
					brProizvodjaca += 1;
				}

				extendedServis.setAvgRadnika(ukupnoRadnika*1.0/brProizvodjaca);
			}

			System.out.println(extendedServisi);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void generateReport1() {
		final String getMasine = "select idmas, nazproiz, proiz from masina order by nazproiz";
		//final String getExtendedComponents = "select kp.nazivk, kp.tip, kp.proizvodjac, kp.cena*kf.komada ukupna_cena_za_komponentu from komponenta kp left outer join konfiguracija kf on kp.idk = kf.idk where kf.idr = ? order by ukupna_cena_za_komponentu desc";
		final String getExtendedUgovori = "select p.nazproiz, s.nazser, u.uslovi from proizvodjac p, servis s, ugovor u where p.idproiz=u.idproiz and u.idser=s.idser and p.idproiz=?";

		List<ExtendedMasina> extendedMasine = new ArrayList<>();

		try (Connection connection = ConnectionUtil_Basic.getConnection();
				PreparedStatement psMasine = connection.prepareStatement(getMasine);
				PreparedStatement psExtendedUgovori = connection.prepareStatement(getExtendedUgovori);) {
			
			ResultSet rsMasine = psMasine.executeQuery();

			if (!rsMasine.isBeforeFirst()) {
				System.out.println("No matching servis items!");
				return;
			}

			while (rsMasine.next()) {
				int masinaId = rsMasine.getInt("idmas");
				String masinaName = rsMasine.getString("nazproiz");
				int proizId = rsMasine.getInt("proiz");
				
				ExtendedMasina extendedMasina = new ExtendedMasina(masinaId, masinaName);
				extendedMasine.add(extendedMasina);

				psExtendedUgovori.setInt(1, proizId);
				ResultSet rsExtendedUgovor = psExtendedUgovori.executeQuery();

				if (!rsExtendedUgovor.isBeforeFirst()) {
					continue;
				}

				int brUgovora = 0;

				while (rsExtendedUgovor.next()) {
					String proizName = rsExtendedUgovor.getString(1);
					String serName = rsExtendedUgovor.getString(2);
					String uslovi = rsExtendedUgovor.getString(3);
					extendedMasina.getExtendedUgovori().add(new ExtendedUgovor(proizName, serName, uslovi));

					brUgovora += 1;
				}

				extendedMasina.setBrUgovora(brUgovora);
			}

			System.out.println(extendedMasine);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void dropTables() {
		try {
			ReportUtil.baseResourcePath = "resources/computer_configuration/";
			String[] commands = ReportUtil.getCommandsFromFile(dropTablesFile);
			ReportUtil.executeCommands(commands);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
