package chap5;

public class Increment {
	public static void main(String[] args){
		int x = 1;
		System.out.println("Before the call, x is " + x);
		Increment(x);
		System.out.println("After the call, x is " + x);
	}

	public static void Increment(int n) {
		// TODO Auto-generated method stub
		n++;
		System.out.println("n inside the method is " + n);
	}
}
