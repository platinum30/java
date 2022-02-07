package e.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadTextToFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("c:/tzah/temp/letter.txt");
		try (FileReader in = new FileReader(file)) {
			int ch = in.read();// read the first character
			while (ch != -1) {
				System.out.print((char) ch);
				ch = in.read();// read the sec character
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
