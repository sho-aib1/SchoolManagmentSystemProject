package Main;

public class addition {
	public static void main(String[] args) {
		int a = 10;
		int b = 25;
		int c = 0;
		System.out.println(getaddition(a, b, c));
	}

	private static int getaddition(int a, int b, int c) {
		c = a + b;
		return c;
	}

}
