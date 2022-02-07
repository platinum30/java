package generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class CollectionsDemo {

	public static void main(String[] args) {
		// LIST
		List<String> list1 = new ArrayList<>();// Random access - by index
		List<String> list2 = new LinkedList<>();// good for add and remove
		list1.add("Math");
		list1.add("English");
		list1.add("Java");
		list1.add("Php");
		System.out.println(list1);
		System.out.println(list1.get(3));
		System.out.println(list1.size());
		System.out.println("=====================");

		// SET
		Set<String> set1 = new HashSet<>();
		set1.add("Math");
		set1.add("English");
		set1.add("Java");
		set1.add("Java");
		set1.add("Php");
		set1.add("History");
		set1.add("Algebra");
		System.out.println(set1);
		System.out.println(set1.size());
		System.out.println("=====================");
		// Set that ordered by Hash
		Set<String> set2 = new HashSet<String>(set1);
		System.out.println(set2);// number of element on list

		// Set that ordered by insert order - ordered
		Set<String> set3 = new LinkedHashSet<String>(set1);

		// Set that ordered by ABC
		Set<String> set4 = new TreeSet<String>(set1);
		// MAP
		System.out.println("===================");
		Map<String, String> dictionary = new HashMap<String, String>();
		dictionary.put("dog", "a nice animal that barks");
		dictionary.put("java", "an oop programing language");
		dictionary.put("table", "a furniture to put things on");
		String Java = dictionary.get("java");
		System.out.println(Java);

		System.out.println("enter key");
		Scanner sc = new Scanner(System.in);
		String key = sc.nextLine();

		System.out.println("enter word");
		String value = sc.nextLine();

		dictionary.put(key, value);

		System.out.println(dictionary.get(key));
		sc.close();
	}

}
