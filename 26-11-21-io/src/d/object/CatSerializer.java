package d.object;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CatSerializer {

	public static void main(String[] args) {
		Cat cat = new Cat(123, "Mizi", 8, "Red");
		try (ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(new File("files/cat.obj"))))) {

			out.writeObject(cat);
			System.out.println(cat);
			System.out.println("saved to file:");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
