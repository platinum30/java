package e.io;

import java.io.File;
import java.io.IOException;

public class CreateFilesAndDirs {

	public static void main(String[] args) throws IOException {
		File dir = new File("c:/tzah/temp");
		File file = new File(dir, "letter.txt");

		if (dir.exists()) {
			System.out.println("directory " + dir + " exist");
			if (file.exists()) {
				System.out.println("file " + file + " exist");
			} else {
				System.out.println("file " + file + " is not exist");
				System.out.println("creating file " + file);
				file.createNewFile();// create the file

			}
		} else {
			System.out.println("directory " + dir + " is not exist");
			System.out.println("creating directory " + dir);
			dir.mkdir();// mkdir make the directory | mkdirs will make all dirs

		}

	}

}
