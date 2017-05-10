package designMode.Builder;

public class Test {

	public static void main(String[] args) {
		ManBuilder manBuilder = new ManBuilder();
		Director director = new Director(manBuilder);
		director.constructPerson();
	}
}
