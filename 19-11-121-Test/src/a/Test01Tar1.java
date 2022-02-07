package a;

import java.util.Arrays;

public class Test01Tar1 {
	public static void main(String[] args) {
		int[] nums1 = new int[15];
		int[] nums2 = new int[15];

		for (int i = 0, j = 0; i < nums1.length; i++, j++) {
			int rand1 = (int) (Math.random() * 10);
			int rand2 = (int) (Math.random() * 10);
			nums1[i] = rand1;
			nums2[i] = rand2;
		}

		System.out.println("nums1: " + Arrays.toString(nums1));
		System.out.println("================================");
		System.out.println("nums2: " + Arrays.toString(nums2));
		System.out.println("================================");

		if (biggestThreeDigits(nums1) > biggestThreeDigitsBack(nums1)) {
			System.out.println("the biggest 3 digits number in nums1 Array is:" + biggestThreeDigits(nums1));
		} else {
			System.out.println("the biggest 3 digits number in nums1 Array is:" + biggestThreeDigitsBack(nums1));
		}
		System.out.println("==============Distinct Array==============");

		System.out.println(Arrays.toString(distinctArr(nums1, nums2)));

		System.out.println("==============Long from Distinct==============");
		if (distinctLong(distinctArr(nums1, nums2)) > 0) {
			System.out.println(distinctLong(distinctArr(nums1, nums2)));
		} else {
			System.out.println("oops!, its look like there is no unique numbers on Distinct :(");
		}

	}

	public static long distinctLong(int[] distinct) {

		long num = 0;
		int temp = 1;
		for (int i : distinct) {
			if (i != -1) {
				num += i * temp;
				temp *= 10;
			}
		}

		return num;
	}

	/**
	 * the function get 2 arrays, and make unique array from them
	 * 
	 * @param nums1 - 1st array
	 * @param nums2 - 2nd array
	 * @return distinct - the unique array
	 */
	public static int[] distinctArr(int[] nums1, int[] nums2) {// make unique arr
		int[] distinct = new int[15];
		for (int i = 0; i < distinct.length; i++) {
			distinct[i] = -1;
		}

		boolean found = false;
		for (int i : nums1) {
			for (int j : nums2) {
				if (i == j) {
					found = true;
					break;
				}
			}
			for (int j : distinct) {
				if (i == j) {
					found = true;
					break;
				}
			}

			if (found == false) {// find cell in distinct to store the unique number
				for (int j = 0; j < distinct.length; j++) {
					if (distinct[j] == (-1)) {// if empty cell was found
						distinct[j] = i;
						break;
					}
				}
			}
			found = false;
		}

		for (int i : nums2) {
			for (int j : nums1) {
				if (i == j) {
					found = true;
					break;
				}
			}
			for (int j : distinct) {
				if (i == j) {
					found = true;
					break;
				}
			}

			if (found == false) {// find cell in distinct to store the unique number
				for (int j = 0; j < distinct.length; j++) {
					if (distinct[j] == (-1)) {// if empty cell was found
						distinct[j] = i;
						break;
					}
				}
			}
			found = false;
		}

		return distinct;
	}

/////////////////////////////////////////////////////////////////
	/**
	 * the function get an array, and return the biggest 3 digits number from 3
	 * close cells, the function runs from left to right
	 * 
	 * @param nums1 - the array
	 * @return int from the biggest 3 digits
	 */
	public static int biggestThreeDigits(int[] nums1) {// find biggest 3 digits numbers on arr from l to r
		// find the biggest number in nums1 array
		int biggest = 0;
		int biggest2 = 0;
		int biggest3 = 0;

		for (int i = 0; i < nums1.length; i++) {
			int j = i + 1;
			int k = i + 2;

			if (nums1[i] > biggest) {// reset biggest 2 if found bigger than biggest
				biggest2 = 0;
				biggest3 = 0;
			}
			if (nums1[i] >= biggest && j <= nums1.length && k <= nums1.length) {
				biggest = nums1[i];

				if (nums1[j] > biggest2) {// reset biggest 3 if found bigger than biggest2
					biggest3 = 0;
				}
				if (j <= nums1.length - 1 && nums1[j] >= biggest2) {
					biggest2 = nums1[j];
					if (k <= nums1.length - 1 && nums1[k] >= biggest3) {
						// System.out.println("nums1K : " + nums1[k]);
						biggest3 = nums1[k];
					}
				}
			}
		}

		int finalBiggest = (biggest * 100) + (biggest2 * 10) + biggest3;

		return finalBiggest;
	}

	/**
	 * the function get an array, and return the biggest 3 digits number from 3
	 * close cells, the function runs from right to left
	 * 
	 * @param nums1 - the array
	 * @return int from the biggest 3 digits
	 */
	public static int biggestThreeDigitsBack(int[] nums1) {// find biggest 3 digits numbers on arr from r to l
		// find the biggest number in nums1 array
		int biggest = 0;
		int biggest2 = 0;
		int biggest3 = 0;

		for (int i = nums1.length - 1; i >= 0; i--) {
			int j = i - 1;
			int k = i - 2;

			if (i > 0 && nums1[i] > biggest) {// reset biggest 2 if found bigger than biggest
				biggest2 = 0;
				biggest3 = 0;
			}
			if (i > 0 && nums1[i] >= biggest) {
				biggest = nums1[i];

				if (j > 0 && nums1[j] > biggest2) {// reset biggest 3 if found bigger than biggest2
					biggest3 = 0;
				}
				if (j > 0 && nums1[j] >= biggest2) {
					biggest2 = nums1[j];
					if (k > 0 && nums1[k] >= biggest3) {
						// System.out.println("nums1K : " + nums1[k]);
						biggest3 = nums1[k];
					}
				}
			}
		}

		int finalBiggest = (biggest * 100) + (biggest2 * 10) + biggest3;

		return finalBiggest;
	}
}
