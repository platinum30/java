package c.data;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Demo02Read {

	public static void main(String[] args) {
		File dir = new File("files");
		File file = new File(dir, "primitives.data");
		try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(file)))) {
			long val1 = in.readLong();
			byte val2 = in.readByte();
			String str = in.readUTF();
			double d = in.readDouble();
			boolean b = in.readBoolean();

			System.out.println(val1 + " | " + val2 + " | " + str + " | " + d + " | " + b);
			System.out.println("data readed from " + file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
