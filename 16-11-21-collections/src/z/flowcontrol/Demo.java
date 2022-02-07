package z.flowcontrol;

public class Demo {
	public static void main(String[] args) {
		String str1 = "aaa";
		String str2 = "aaa";// string pool - str1 and 2 are reference to same object
		String str3 = new String("aaa");// create new object from type string
		System.out.println(str1 == str2);
		System.out.println(str2 == str3);
		// check equality with method equals on objects and string(also object)
		System.out.println(str2.equals(str3));
	}

}
