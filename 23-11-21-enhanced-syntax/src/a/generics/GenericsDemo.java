package a.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsDemo {
	public static void main(String[] args) {
		List<Orange> list1 = new ArrayList<>();
		list1.add(new Orange());
		list1.add(new BloodOrange());
		System.out.println(list1);
		m1(list1);
		System.out.println(list1);
		System.out.println(list1.size());

		List<BloodOrange> list2 = new ArrayList<>();
		list2.add(new BloodOrange());
		m2(list2);
		List<Orange> list3 = new ArrayList<>();
		list3.add(new Orange());
		list3.add(new BloodOrange());
		m3(list3);
	}

	// pros - get and add
	// cons - the method will accept only list of Oranges(List<Orange>)
	public static void m1(List<Orange> list) {
		// get an orange from the list
		if (!list.isEmpty()) {
			Orange orange = list.get(0);
			System.out.println(orange);
		}
		// 2. add orange to the list
		list.add(new Orange());
		list.add(new BloodOrange());
	}

	public static void m2(List<?> list) {
		// get an orange from the list
		if (!list.isEmpty()) {
			Object orange = list.get(0);
			System.out.println(orange);
		}
	}

	public static void m3(List<? extends Orange> list) {// can get list of oranges or blood oranges
		// get an orange from the list
		if (!list.isEmpty()) {
			Orange orange = list.get(0);
			System.out.println(orange);
		}
	}

}
