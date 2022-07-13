package classes.persons;

public class Student extends Person {
	
	private String email;
	private double average;
	
	
	public Student() {
		
	}

	public Student(String firstname, String lastname, int age, String email, double average) {
		super(firstname, lastname, age);
		this.email = email;
		this.average = average;
	}
	
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(average);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (Double.doubleToLongBits(average) != Double.doubleToLongBits(other.average))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	
	
	@Override
	public String toString() {
		return "Student [" + super.toString() + "email=" + email + ", average=" + average + "]";
	}

	
	
	

}
