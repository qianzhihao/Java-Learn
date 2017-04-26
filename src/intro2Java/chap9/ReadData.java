package intro2Java.chap9;

import java.util.Scanner;

public class ReadData {

	public static void main(String[] args) throws Exception {
		java.io.File file =  new java.io.File("scores.txt");
		
		Scanner input = new Scanner(file);
		
		while (input.hasNext()) {
			String firstName = input.next();
			String mi = input.next();
			String lastName = input.next();
			int score = input.nextInt();
			System.out.println(firstName + " " + mi + " " + lastName + " " + score);
		}
		
		input.close();

	}

}