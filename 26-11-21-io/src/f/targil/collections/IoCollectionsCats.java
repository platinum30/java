package f.targil.collections;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import d.object.Cat;

public class IoCollectionsCats {
	public static void main(String[] args) {
		File file = new File("files/catlist.txt");

		try (PrintWriter out = new PrintWriter(new FileWriter(file))) {
			List<Cat> catList = new ArrayList<>();
			for (int i = 0; i < 25; i++) {
				catList.add(getRandomCat(i));
			}
			out.println(catList);
		} catch (IOException e) {
			e.getStackTrace();
		}

	}

	public static enum Color {
		RED, ORANGE, YELLOW, BLACK, WHITE;
	}

	public static Cat getRandomCat(int i) {
		String[] names = { "mizi", "vova", "toolik", "yosef" };
		Cat cat = new Cat();
		cat.setId(i);
		cat.setName(names[(int) (Math.random() * names.length)]);
		cat.setColor(Color.values()[(int) (Math.random() * Color.values().length)].toString());
		int randWeight = (int) (Math.random() * 11) + 5;
		cat.setWight(randWeight);
		return cat;
	}
}
