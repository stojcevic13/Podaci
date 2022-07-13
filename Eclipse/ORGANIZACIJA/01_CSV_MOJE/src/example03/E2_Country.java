package example03;

import com.opencsv.bean.CsvBindByName;

public class E2_Country {
	
	@CsvBindByName(column = "CountryName", required = true)
	private String countryName;
	@CsvBindByName(column = "CapitalName", required = true)
	private String capitalName;
	
	public E2_Country() {
		
	}

	public E2_Country(String countryName, String capitalName) {
		this();
		this.countryName = countryName;
		this.capitalName = capitalName;
	}
	
	

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCapitalName() {
		return capitalName;
	}

	public void setCapitalName(String capitalName) {
		this.capitalName = capitalName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capitalName == null) ? 0 : capitalName.hashCode());
		result = prime * result + ((countryName == null) ? 0 : countryName.hashCode());
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
		E2_Country other = (E2_Country) obj;
		if (capitalName == null) {
			if (other.capitalName != null)
				return false;
		} else if (!capitalName.equals(other.capitalName))
			return false;
		if (countryName == null) {
			if (other.countryName != null)
				return false;
		} else if (!countryName.equals(other.countryName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "E2_Country [countryName=" + countryName + ", capitalName=" + capitalName + "]";
	}
	
	

}
