package b;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Demo01Buffer {
	public static void main(String[] args) {
//		File file = new File("letter.txt");
//		try (BufferedWriter out = new BufferedWriter(new FileWriter(file));) {
//			out.write("this is my text");
//			System.out.println("end");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		File file = new File("letter.txt");

		try (BufferedReader in = new BufferedReader(new FileReader(file))) {
			String line = in.readLine();
			while (line != null) {
				System.out.println(line);
				line = in.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
