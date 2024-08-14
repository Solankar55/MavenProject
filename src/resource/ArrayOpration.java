package resource;

public class ArrayOpration {

	public static void main(String[] args) {

		int a[] = { 10, 15, 20, 16, 9 };
		int temp;
		int b[] = new int[a.length];
		for (int j = 0; j < a.length - 1; j++) {

			for (int i = 0; i < a.length - 1; i++) {
				if (a[i] > a[i + 1]) {
					temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
					b = a;

				}
			}
		}
		for (int c : b) {
			System.out.println(c);
		}
	}

}
