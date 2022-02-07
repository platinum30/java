package e.append;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import d.object.Cat;

public class TexToFilePrinter {

	public static void main(String[] args) {
		File file = new File("files/file1.txt");
		boolean append = false;

		try (PrintWriter out = new PrintWriter(new FileWriter(file, append))) {
			out.println("this is first line");
			out.println(5);
			out.println(LocalDate.now());
			out.println(new Cat(101, "Yosef", 8, "yellow"));
			out.println("=====prices=====");
			for (int i = 0; i < 10; i++) {
				double price = Math.random() * 101;
				out.println(String.format("price: %10.2f", price));
			}
			out.println("=====================");
			System.out.println("done");

		} catch (IOException e) {

		}

	}

}
