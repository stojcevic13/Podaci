package rs.ac.uns.ftn.siit.op.yaml.vjezba.ex3;

public class Person {

	private String given;
	private String family;
	private Address address;
	
	public Person() {
		
	}

	public Person(String given, String family, Address address) {
		this();
		this.given = given;
		this.family = family;
		this.address = address;
	}

	public String getGiven() {
		return given;
	}

	public void setGiven(String given) {
		this.given = given;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((family == null) ? 0 : family.hashCode());
		result = prime * result + ((given == null) ? 0 : given.hashCode());
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
		Person other = (Person) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (family == null) {
			if (other.family != null)
				return false;
		} else if (!family.equals(other.family))
			return false;
		if (given == null) {
			if (other.given != null)
				return false;
		} else if (!given.equals(other.given))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [given=" + given + ", family=" + family + ", address=" + address + "]";
	}
	
	
}
