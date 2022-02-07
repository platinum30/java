package d.Arrays;

import java.util.Arrays;
import java.util.List;

public class ListToArray {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(3, 5, 6, 10);
		System.out.println(list);

		System.out.println("========Array=========");
		Integer[] arr = list.toArray(new Integer[list.size()]);
		System.out.println(Arrays.toString(arr));

	}

}
