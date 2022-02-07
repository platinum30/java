import java.util.Arrays;

public class Test2 {
	public static void main(String args[]) {
		String s = "abc";
		promotiation(s);
	}

	public static void promotiation(String str) {
		int length = str.length();
		System.out.println(length);
		char[] arr = new char[length];
		String aa = "";
		for (int i = 0; i <= length - 1; i++) {
			arr[i] = str.charAt(i);
			aa = aa + i;
		}
		int tempInt = Integer.parseInt(aa);
		System.out.println("a:" + tempInt % 10);
		while (tempInt != 0) {

			for (int i = 0; i < arr.length; i++) {
				// System.out.println();
			}
		}
		int a = Integer.parseInt(aa);
		System.out.println(a);
		System.out.println(aa);
		System.out.println(Arrays.toString(arr));
	}
}
