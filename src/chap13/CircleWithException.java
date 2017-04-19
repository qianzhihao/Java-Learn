package chap13;

public class CircleWithException {

	
	private double radius;
	
	private static int numberOfObjects = 0;
	
	public CircleWithException() {
		this(1.0);
	}
	
	public CircleWithException(double newRadius) {
		setRadius(newRadius);
		numberOfObjects++;
	}

	public double getRaduis() {
		return radius;
	}
	
	private void setRadius(double newRadius) throws IllegalArgumentException {

		if (newRadius >= 0)
			radius = newRadius;
		else
			throw new IllegalArgumentException("Radius cannot be negative");
	}

	public static int getNumberOfObjects() {
		return numberOfObjects;
	}
	
	public double findArea() {
		return radius * radius * 3.14159;
	}
}
