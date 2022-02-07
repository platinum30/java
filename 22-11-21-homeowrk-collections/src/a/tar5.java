package a;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class tar5 {
	public static void main(String[] args) {
		Set<Integer> intSet = new LinkedHashSet<>();
		while (intSet.size() < 10) {
			int r = (int) (Math.random() * 11);
			intSet.add(r);
		}
		Iterator<Integer> it = intSet.iterator();
		System.out.println(intSet);
		while (it.hasNext()) {// remove all even numbers from the set
			if (it.next() % 2 == 0) {
				it.remove();
			}
		}
		System.out.println(intSet);
	}
}
