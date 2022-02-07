package a;

import java.util.Arrays;

public class UniqueArray {
	public static void main(String[] args) {
		int[] arr = new int[10];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 11);
		}

		System.out.println(Arrays.toString(arr));

		int[] uniqueArr = new int[10];
		for (int i = 0; i < uniqueArr.length; i++) {
			uniqueArr[i] = -1;
		}
		System.out.println(Arrays.toString(uniqueArr));

		int uniqueC = 0;
		for (int i : arr) {
			if (isUnique(i, uniqueArr) == true) {
				uniqueC++;
				for (int j = 0; j < uniqueArr.length; j++) {
					if (uniqueArr[j] < 0) {
						uniqueArr[j] = i;
						break;
					}
				}
			}
		}

		System.out.println(Arrays.toString(uniqueArr));

		int[] finalArr = new int[uniqueC];
		for (int i = 0; i < finalArr.length; i++) {
			finalArr[i] = -1;
		}
		for (int i : uniqueArr) {
			if (i != (-1)) {
				for (int j = 0; j < finalArr.length; j++) {
					if (finalArr[j] == -1) {
						finalArr[j] = i;
						break;
					}
				}
			}
		}

		System.out.println(Arrays.toString(finalArr));
	}

	/**
	 * the function check if value exist in array
	 * 
	 * @param value     - value to check
	 * @param uniqueArr - the array
	 * @return
	 */
	public static boolean isUnique(int value, int[] uniqueArr) {
		for (int i = 0; i < uniqueArr.length; i++) {
			if (value == uniqueArr[i]) {
				return false;
			}
		}
		return true;
	}
}
