package a;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class tar7maps {
	public static void main(String[] args) {
		Map<String, String> things = new LinkedHashMap<String, String>();
		things.put("dog", "an animal that barks");
		things.put("car", "a vehicle");
		things.put("java", "an oop programing lang");
		System.out.println(things.keySet());
		System.out.println("please eneter a word: ");
		Scanner sc = new Scanner(System.in);
		System.out.println(things.get(sc.nextLine()));// get element value from map by scanner input
		sc.close();

	}
}
