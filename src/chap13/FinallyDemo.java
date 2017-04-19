package chap13;

public class FinallyDemo {

	public static void main(String[] args) {
		java.io.PrintWriter output = null;
		
		try {
			//create a file
			output = new java.io.PrintWriter("text.txt");
			
			//write formatted output to the file
			output.println("wlecome to java");
		} catch (java.io.IOException ex) {
			ex.printStackTrace();
		} finally {
			//close the file
			if (output != null) output.close();
		}
		
		System.out.println("End of program");
	}

}
