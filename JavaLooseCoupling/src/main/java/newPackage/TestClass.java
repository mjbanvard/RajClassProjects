package newPackage;

public class TestClass {

	public static void main(String[] args) {

		SumForNumber s = new GetInstance().getSumInstance();
		int total = s.add(2, 4);
		System.out.println(total);
	}

}
