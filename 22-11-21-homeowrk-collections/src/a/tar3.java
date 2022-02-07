package a;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class tar3 {

	public static void main(String[] args) {
		List<Integer> listInt = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			int r = (int) (Math.random() * 6 + 5);
			listInt.add(r);
		}

		System.out.println(listInt);

		Set<Integer> setInt = new HashSet<>();
		for (Integer integer : listInt) {
			setInt.add(integer);
		}
		System.out.println(setInt);
	}

}
