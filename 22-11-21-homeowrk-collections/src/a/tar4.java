package a;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class tar4 {
	public static void main(String[] args) {
		Set<String> nameSet = new HashSet<>();
		nameSet.add("David");
		nameSet.add("Avi");
		nameSet.add("Moshe");
		Iterator<String> it = nameSet.iterator();
		for (int i = 0; it.hasNext(); i++) {
			if (i == 2) {
				System.out.println(it.next());
				break;
			}
		}
	}
}
