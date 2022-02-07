package exercise;

public class Printer {
	public static void main(String[] args) {
		String part1 = "there will be ";
		int visitors = 5;
		String part2 = " people for dinner";
		
		System.out.println(part1 + visitors+2 + part2);// will print 52 visitors
		System.out.println(part1 + (visitors+2) + part2);//will print 7 visitors
		
	}

}
