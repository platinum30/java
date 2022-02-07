package a;

import java.util.ArrayList;
import java.util.List;

public class tar2 {
	public static void main(String[] args) {
		List<Integer> listInt = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			int rand = (int) (Math.random() * 61 + 20);
			listInt.add(rand);
		}

		System.out.println(listInt);
		System.out.println("the list size is: " + listInt.size());
		System.out.println("the first element is: " + listInt.get(0));
		System.out.println("the 10th element is: " + listInt.get(9));
		System.out.println("the last element is: " + listInt.get(listInt.size() - 1));

		boolean contains = listInt.contains(25);
		if (contains) {
			System.out.println("found on index " + listInt.indexOf(25));
		}
	}
}
