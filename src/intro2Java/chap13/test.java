package intro2Java.chap13;

public class test {
	public static void main(String[] args) {

		try {
			method();
			System.out.println("After the method call");
		} 
//		catch (ArithmeticException ex) {
//			System.out.println("ArithmeticException");
//		} 
		catch (RuntimeException ex) {
			System.out.println("RuntimeException in main");
		} 
		catch (Exception ex) {
			System.out.println("Exception");
		}
	}

	static void method() throws Exception {
		try {
			String s = "abc";
			System.out.println(s.charAt(3));
		} 
		catch (RuntimeException ex) {
			System.out.println("RuntimeException in method()");
		}
		catch (Exception ex) {
			System.out.println("Exception in method()");
		}
	}
}
