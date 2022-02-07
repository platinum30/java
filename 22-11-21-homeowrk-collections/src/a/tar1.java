package a;

import java.util.ArrayList;
import java.util.List;

public class tar1 {
	public static void main(String[] args) {
		List<Integer> listInt = new ArrayList<>();// creat an integer list
		// add 3 elements
		listInt.add(1);
		listInt.add(2);
		listInt.add(3);
		// print the list
		System.out.println(listInt);

		System.out.println("third element: " + listInt.get(2));// print the 3rd element
		int sum = 0;
		for (Integer i : listInt) {
			sum += i;
		}
		int avg = (sum / listInt.size());
		System.out.println("the sum is: " + sum);
		System.out.println("the avg is: " + avg);
	}
}
