import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		System.out.println(Arrays.toString(arr));

		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i >= 3) {
				j++;
			}
		}
		System.out.println(arr[j]);

	}
}
