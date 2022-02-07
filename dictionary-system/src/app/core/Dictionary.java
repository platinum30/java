package app.core;

import java.util.Map;
import java.util.TreeMap;

public class Dictionary {

	public static void main(String[] args) {
		Map<String, String> map = new TreeMap<>();
		map.put("aaa", "bbb");
		System.out.println(map);
		map.remove("aaa");
		System.out.println(map);
	}

	public void addEntry(String entry, String definition) {
		if (entry == null || entry.length() == 0) {
			// throw new DictionaryExeptions("addEntry faild - ");
		}

	}

}
