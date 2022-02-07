package e.append;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TexToFile {

	public static void main(String[] args) {
		File file = new File("files/file1.txt");
		boolean append = true;
		try (BufferedWriter out = new BufferedWriter(new FileWriter(file, append))) {
			out.write("new line 1");
			out.newLine();
			out.write("new line 2");
			out.newLine();
			out.write("new line 3");
			out.newLine();

			System.out.println("text written to file " + file);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
