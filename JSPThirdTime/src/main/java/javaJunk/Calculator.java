package javaJunk;

public class Calculator {

	public int sqrt(int num) {
		return num * num;
	}

	public static void main(String[] args) {
		try {
			int num = 1000 % 0;
		} catch (ArithmeticException e) {
			System.out.println("There are some Arithmetic exceptions");
		}

		System.out.println("I am done with Exceptions");
	}

}
