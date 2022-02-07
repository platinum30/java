package a;

public class Page7Exercise5 {
	public static void main(String[] args) {
		int num1 = (int)(Math.random()*101);
		int num2 = (int)(Math.random()*101);
		System.out.println("num1: " + num1 +"||" + "num2: " + num2);
		
		if(num1 > num2) {
			System.out.println("the bigger number is num1 - " + num1);
		}else {
			System.out.println("the bigger number is num2 - " + num2);		
		}
		
		System.out.println("//////////////////////////");
		
		if(num1 > 50) {
			System.out.println("num1 is Big!");
		}else if(num1 < 50) {
			System.out.println("num1 is Small!");
		}else if(num1 == 50) {
			System.out.println("Bingo!  - num1 equals to 50");
		}
		
	
	}

}
