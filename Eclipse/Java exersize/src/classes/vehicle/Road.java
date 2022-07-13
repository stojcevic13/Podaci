package classes.vehicle;

public class Road {
	
	public void driving(Vehicle... vehicles) {
		for (Vehicle v : vehicles) {
			v.drive();
		}
	}

	public static void main(String[] args) {
		
		Road road = new Road();
		
		Car car1 = new Car();
		Car car2 = new Car();
		Bus bus1 = new Bus();
		Formula formula1 = new Formula();
		Formula formula2 = new Formula();
		
		road.driving(car1, bus1, formula1, car2, formula2);

	}

}
