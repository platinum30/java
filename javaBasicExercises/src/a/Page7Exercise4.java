package a;

public class Page7Exercise4 {
	public static void main(String[] args) {
		int num1 = (int)(Math.random()*101);//define random num1
		int num2 = (int)(Math.random()*101);//define random num2
		System.out.println("Number 1 is:" + num1);//print num1
		System.out.println("Number 2 is:" + num2);// print num2
		int sum = num1+num2;//define the sum variable
		System.out.println("the sum is:" + sum);//print the sum
		
		System.out.println("the avarage is: " + (sum/2));
		
		System.out.println("the remainder of num1(when dividing in 10) is: " + (num1%10));
		System.out.println("the remainder of num2(when dividing in 10) is: " + (num2%10));
		
		System.out.println("the rectangle width is:" + num1 + "cm"  + "and the height is: " + num2 +"cm"+ " so its are is:" + (num1*num2) + "cm or" + (num1*num2/100D) +"m");
		
		
	}
}
