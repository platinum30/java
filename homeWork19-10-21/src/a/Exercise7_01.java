package a;

public class Exercise7_01 {

	public static void main(String[] args) {
		int[] arr = new int[10];
		int avg = 0;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*101);
			//System.out.println(arr[i]);
			sum += arr[i];
		}
		avg = sum / arr.length;
		System.out.println("the ar sum is: " + sum);
		
		System.out.println("the ar avg is: " + avg);
		

	}

}
