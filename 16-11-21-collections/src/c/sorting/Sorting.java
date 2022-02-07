package c.sorting;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Sorting {
	public static void main(String[] args) {
		{

			List<Integer> list = new ArrayList<>();
			list.add(1);
			list.add(6);
			list.add(7);
			list.add(9);
			list.add(10);
			list.add(5);
			System.out.println(list);
			list.sort(null);
			System.out.println(list);

		}
		System.out.println("===========================");
		{
			List<String> list = new ArrayList<>();
			list.add("alla");
			list.add("hello");
			list.add("bye");
			list.add("person");
			list.add("car");
			System.out.println(list);
			list.sort(null);
			System.out.println(list);
		}
		System.out.println("===========================");
		{
			List<LocalDate> list = new ArrayList<>();
			list.add(LocalDate.of(2021, 11, 16));
			list.add(LocalDate.of(2000, 11, 16));
			list.add(LocalDate.of(2022, 11, 16));
			list.add(LocalDate.of(1988, 11, 16));

			System.out.println(list);
			list.sort(null);
			System.out.println(list);
		}

		System.out.println("===========================");
		{
			List<Person> list = new ArrayList<>();
			list.add(new Person(201, "aaa", 25));
			list.add(new Person(7, "bbb", 51));
			list.add(new Person(307, "ccc", 12));

			System.out.println(list);
			list.sort(null);
			System.out.println(list);
			System.out.println("===============name sorting==========");
			list.sort(new PersonNameComperator());
			System.out.println(list);

			System.out.println("===============age sorting==========");
			list.sort(new PersonAgeComperator());
			System.out.println(list);

			System.out.println("========call method print=========");
			print(list);
		}

	}

	static void print(Collection<?> collection) {// print all elements on collections
		System.out.println("============");
		for (Object e : collection) {
			System.out.println(e);
		}
		System.out.println("============");
	}
}
