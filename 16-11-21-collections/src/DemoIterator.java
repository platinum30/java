import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DemoIterator {
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			int t = (int) (Math.random() * 11);
			list1.add(t);
		}

		// list elements sum
		int sum = 0;
		for (int i = 0; i < list1.size(); i++) {
			sum += list1.get(i);
		}
		System.out.println(list1);
		System.out.println("list sum is:" + sum);

		// REMOVE ALL ODD ELEMENTS
		Iterator<Integer> it = list1.iterator();
		///////////// Iterator methods/////////////
		// next method get the next element
		// hasNext method - is there next element?
		// remove - remove the current element

		while (it.hasNext()) {
			if (it.next() % 2 != 0) {
				it.remove();
			}
		}

		System.out.println("list without odd numbers");
		System.out.println(list1);

		////////////////////// SET//////////////////
		Set<Integer> set1 = new HashSet<>();
		while (set1.size() != 10) {
			int t = (int) (Math.random() * 11);
			set1.add(t);
		}
		System.out.println("===========Set==========");
		System.out.println(set1);

		/// iterator////
		Iterator<Integer> setIter = set1.iterator();
		while (setIter.hasNext()) {
			if (setIter.next() % 2 != 0) {
				setIter.remove();
			}
		}
		System.out.println("===========no odd numbers Set==========");
		System.out.println(set1);
	}
}
