package vjezba.task01;

import com.opencsv.bean.CsvBindByPosition;

public class TackaBean {
	// 0 1 2 	3
	// x,y,z,distance
	
	@CsvBindByPosition(position = 0, required = true)
	private double x;
	@CsvBindByPosition(position = 1, required = true)
	private double y;
	@CsvBindByPosition(position = 2, required = true)
	private double z;
	@CsvBindByPosition(position = 3, required = false)
	private double distance;
	
	
	public TackaBean() {
		
	}
	
	public TackaBean(double x, double y, double z, double distance) {
		this();
		this.x = x;
		this.y = y;
		this.z = z;
		this.distance = distance;
	}


	



	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(distance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(z);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		TackaBean other = (TackaBean) obj;
		if (Double.doubleToLongBits(distance) != Double.doubleToLongBits(other.distance))
			return false;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		if (Double.doubleToLongBits(z) != Double.doubleToLongBits(other.z))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TackaBean [x=" + x + ", y=" + y + ", z=" + z + ", distance=" + distance + "]";
	}
	
	
	

	public void calculateDistance() {
		this.distance = Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
	}
	

}
