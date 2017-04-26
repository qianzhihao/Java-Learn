package intro2Java.chap14;

public class House implements Cloneable, Comparable{
	private int id;
	private double area;
	private java.util.Date whenBuilt;
	
	public House(int id, double area) {
		this.id = id;
		this.area = area;
		whenBuilt = new java.util.Date();
	}
	
	public int getId() {
		return id;
	}
	
	public double getArea() {
		return area;
	}
	
	public java.util.Date getWhenBuilt() {
		return whenBuilt;
	}
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public int compareTo(Object o) {
		if (area > ((House)o).area)
			return 1;
		else if (area < ((House)o).area)
			return -1;
		else
			return 0;
	}
}