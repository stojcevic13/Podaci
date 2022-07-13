package rs.ac.uns.ftn.siit.op.yaml.vjezba.ex3;

public class Address {
	
	private String lines;
	private String city;
	private String state;
	private int postal;
	
	
	public Address() {
		
	}


	public Address(String lines, String city, String state, int postal) {
		this();
		this.lines = lines;
		this.city = city;
		this.state = state;
		this.postal = postal;
	}


	public String getLines() {
		return lines;
	}


	public void setLines(String lines) {
		this.lines = lines;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public int getPostal() {
		return postal;
	}


	public void setPostal(int postal) {
		this.postal = postal;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((lines == null) ? 0 : lines.hashCode());
		result = prime * result + postal;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		Address other = (Address) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (lines == null) {
			if (other.lines != null)
				return false;
		} else if (!lines.equals(other.lines))
			return false;
		if (postal != other.postal)
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Address [lines=" + lines + ", city=" + city + ", state=" + state + ", postal=" + postal + "]";
	}
	
	
	
}
