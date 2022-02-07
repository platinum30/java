package a;

import java.util.LinkedHashMap;
import java.util.Map;

public class tar6map {
	public static void main(String[] args) {
		Map<Character, Integer> abcMap = new LinkedHashMap<Character, Integer>();
		abcMap.put('A', 65);
		abcMap.put('B', 66);
		abcMap.put('C', 67);
		System.out.println(abcMap);

		Map<Integer, String> daysMap = new LinkedHashMap<Integer, String>();
		daysMap.put(1, "Sunday");
		daysMap.put(2, "Monday");
		daysMap.put(3, "Tuesday");
		System.out.println(daysMap);

		Map<Integer, String> numsMap = new LinkedHashMap<Integer, String>();
		numsMap.put(1, "one");
		numsMap.put(2, "two");
		numsMap.put(3, "three");
		numsMap.put(4, "four");
		numsMap.put(5, "five");
		System.out.println(numsMap);
		System.out.println("==================");
		System.out.println(numsMap.keySet());
		System.out.println(numsMap.values());
	}

}
