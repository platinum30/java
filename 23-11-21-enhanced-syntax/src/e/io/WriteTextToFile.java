package e.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteTextToFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("c:/tzah/temp/letter.txt");
		try (FileWriter out = new FileWriter(file)) {
			out.write("Hellow Java IO");
			System.out.println("text written");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
