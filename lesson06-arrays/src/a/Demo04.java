package a;

import java.util.Arrays;

public class Demo04 {
	public static void main(String[] args) {
		int[] arr = { 2, 4, 5 }; // create an array manually
		System.out.println(Arrays.toString(arr));// class that print an array

		int[][] arrDim = { { 1, 2, 3 }, { 10, 30 }, { 15, 21, 88, 71 } };// create an DIM ARRAY manually
		for (int j = 0; j < arrDim.length; j++) {
			System.out.println(Arrays.toString(arrDim[j]));
		}

	}
}
