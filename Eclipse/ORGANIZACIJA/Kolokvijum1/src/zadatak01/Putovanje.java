package zadatak01;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.opencsv.bean.CsvBindByPosition;

public class Putovanje {
	//	sifra  grad1	grad2	datum	  vrijeme  dolazimo  peron  cijena  koliko 	
	
	@CsvBindByPosition(position = 0, required = true)
	private String sifra;
	@CsvBindByPosition(position = 1, required = true)
	private String mjestoPolaska;
	@CsvBindByPosition(position = 2, required = true)
	private String mjestoDolaska;
	@CsvBindByPosition(position = 3, required = true)
	private String datumPolaska;
	@CsvBindByPosition(position = 4, required = true)
	private String vrijemePolaska;
	@CsvBindByPosition(position = 5, required = true)
	private String vrijemeDolaska;
	@CsvBindByPosition(position = 6, required = true)
	private int peron;
	@CsvBindByPosition(position = 7, required = true)
	private double cijena;
	@CsvBindByPosition(position = 8, required = true)
	private int prodatihKarata;
	
	
	public Putovanje() {
		
	}


	public Putovanje(String sifra, String mjestoPolaska, String mjestoDolaska, String datumPolaska,
			String vrijemePolaska, String vrijemeDolaska, int peron, double cijena, int prodatihKarata) {
		this();
		this.sifra = sifra;
		this.mjestoPolaska = mjestoPolaska;
		this.mjestoDolaska = mjestoDolaska;
		this.datumPolaska = datumPolaska;
		this.vrijemePolaska = vrijemePolaska;
		this.vrijemeDolaska = vrijemeDolaska;
		this.peron = peron;
		this.cijena = cijena;
		this.prodatihKarata = prodatihKarata;
	}


	public String getSifra() {
		return sifra;
	}


	public void setSifra(String sifra) {
		this.sifra = sifra;
	}


	public String getMjestoPolaska() {
		return mjestoPolaska;
	}


	public void setMjestoPolaska(String mjestoPolaska) {
		this.mjestoPolaska = mjestoPolaska;
	}


	public String getMjestoDolaska() {
		return mjestoDolaska;
	}


	public void setMjestoDolaska(String mjestoDolaska) {
		this.mjestoDolaska = mjestoDolaska;
	}


	public String getDatumPolaska() {
		return datumPolaska;
	}


	public void setDatumPolaska(String datumPolaska) {
		this.datumPolaska = datumPolaska;
	}


	public String getVrijemePolaska() {
		return vrijemePolaska;
	}


	public void setVrijemePolaska(String vrijemePolaska) {
		this.vrijemePolaska = vrijemePolaska;
	}


	public String getVrijemeDolaska() {
		return vrijemeDolaska;
	}


	public void setVrijemeDolaska(String vrijemeDolaska) {
		this.vrijemeDolaska = vrijemeDolaska;
	}


	public int getPeron() {
		return peron;
	}


	public void setPeron(int peron) {
		this.peron = peron;
	}


	public double getCijena() {
		return cijena;
	}


	public void setCijena(double cijena) {
		this.cijena = cijena;
	}


	public int getProdatihKarata() {
		return prodatihKarata;
	}


	public void setProdatihKarata(int prodatihKarata) {
		this.prodatihKarata = prodatihKarata;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cijena);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((datumPolaska == null) ? 0 : datumPolaska.hashCode());
		result = prime * result + ((mjestoDolaska == null) ? 0 : mjestoDolaska.hashCode());
		result = prime * result + ((mjestoPolaska == null) ? 0 : mjestoPolaska.hashCode());
		result = prime * result + peron;
		result = prime * result + prodatihKarata;
		result = prime * result + ((sifra == null) ? 0 : sifra.hashCode());
		result = prime * result + ((vrijemeDolaska == null) ? 0 : vrijemeDolaska.hashCode());
		result = prime * result + ((vrijemePolaska == null) ? 0 : vrijemePolaska.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Putovanje other = (Putovanje) obj;
		if (Double.doubleToLongBits(cijena) != Double.doubleToLongBits(other.cijena))
			return false;
		if (datumPolaska == null) {
			if (other.datumPolaska != null)
				return false;
		} else if (!datumPolaska.equals(other.datumPolaska))
			return false;
		if (mjestoDolaska == null) {
			if (other.mjestoDolaska != null)
				return false;
		} else if (!mjestoDolaska.equals(other.mjestoDolaska))
			return false;
		if (mjestoPolaska == null) {
			if (other.mjestoPolaska != null)
				return false;
		} else if (!mjestoPolaska.equals(other.mjestoPolaska))
			return false;
		if (peron != other.peron)
			return false;
		if (prodatihKarata != other.prodatihKarata)
			return false;
		if (sifra == null) {
			if (other.sifra != null)
				return false;
		} else if (!sifra.equals(other.sifra))
			return false;
		if (vrijemeDolaska == null) {
			if (other.vrijemeDolaska != null)
				return false;
		} else if (!vrijemeDolaska.equals(other.vrijemeDolaska))
			return false;
		if (vrijemePolaska == null) {
			if (other.vrijemePolaska != null)
				return false;
		} else if (!vrijemePolaska.equals(other.vrijemePolaska))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Putovanje [sifra=" + sifra + ", mjestoPolaska=" + mjestoPolaska + ", mjestoDolaska=" + mjestoDolaska
				+ ", datumPolaska=" + datumPolaska + ", vrijemePolaska=" + vrijemePolaska + ", vrijemeDolaska="
				+ vrijemeDolaska + ", peron=" + peron + ", cijena=" + cijena + ", prodatihKarata=" + prodatihKarata
				+ "]";
	}


	public int getTrajanje() {
		LocalTime polazak = LocalTime.parse(this.vrijemePolaska, DateTimeFormatter.ofPattern("HH:mm"));
		LocalTime dolazak = LocalTime.parse(this.vrijemeDolaska, DateTimeFormatter.ofPattern("HH:mm"));
		return (int) Duration.between(polazak, dolazak).toMinutes();
	}
	
	public LocalDateTime dateTimePolaska() {
		return LocalDateTime.parse(datumPolaska + " - " + vrijemePolaska, DateTimeFormatter.ofPattern("dd.MM.yyyy - HH:mm"));
	}
	
	public LocalDateTime dateTimeDolaska() {
		return LocalDateTime.parse(datumPolaska + " - " + vrijemeDolaska, DateTimeFormatter.ofPattern("dd.MM.yyyy - HH:mm"));
	}
	

}
