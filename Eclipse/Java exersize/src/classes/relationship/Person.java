package classes.relationship;

public abstract class Person {
	
	private String firstname;
	private String lastname;
	private int age;
	private int height;
	private double weight;
	
	
	public Person() {
		
	}

	public Person(String firstname, String lastname, int age, int height, double weight) {
		this();
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "firstname=" + firstname + ", lastname=" + lastname + ", age=" + age + ", height=" + height
				+ ", weight=" + weight;
	}
	
	
	
	
	
	

}
