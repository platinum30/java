package d.object;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class CatReader {

	public static void main(String[] args) {
		// Cat cat = new Cat(123, "Mizi", 8, "Red");
		try (ObjectInputStream out = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream(new File("files/cat.obj"))))) {
			Cat cat = (Cat) out.readObject();
			System.out.println(cat);
			System.out.println("Readed");

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
