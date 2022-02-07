package c.data;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo01 {

	public static void main(String[] args) {
		// 1. long

		// 2. byte

		// 3.String

		// 4. double

		// 5. boolean

		// insert to files /primitives.data
		File dir = new File("files");
		File file = new File(dir, "primitives.data");
		dir.mkdirs();
		try (DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
			out.writeLong(1500);// write long will catch 64bit in the file
			out.writeByte(22);// will catch 8 bit
			out.writeUTF("this is a message");// string
			out.writeDouble(2.2);
			out.writeBoolean(true);

			System.out.println("data written to " + file);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
