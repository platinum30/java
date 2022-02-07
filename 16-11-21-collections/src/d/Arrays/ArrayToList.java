package d.Arrays;

import java.util.Arrays;
import java.util.List;

public class ArrayToList {
	public static void main(String[] args) {
		Integer[] arr = { 3, 5, 7, 1, 4, 9, 0 };
		System.out.println(Arrays.toString(arr));
		System.out.println("=============");
		List<Integer> list = Arrays.asList(arr);
		System.out.println(list);
	}

}
