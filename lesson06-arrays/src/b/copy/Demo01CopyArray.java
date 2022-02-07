package b.copy;

import java.util.Arrays;

public class Demo01CopyArray {

	public static void main(String[] args) {
		int[] arr = { 2, 4, 6 };
		System.out.println(Arrays.toString(arr));

		int[] arrTemp = new int[arr.length + 5];

		System.arraycopy(arr, 0, arrTemp, 0, arr.length);// copy elements from source arr to destination
		System.out.println(Arrays.toString(arrTemp));
		System.arraycopy(arr, 1, arrTemp, 3, arr.length - 1);// copy JUST FIRST 2 ELEMENTS
		System.out.println(Arrays.toString(arrTemp));

	}

}
