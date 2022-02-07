package a;

public class Exercise7_02 {

	public static void main(String[] args) {
		int[] arr = new int[50];
		int biger = 0;
		int bigerIndex = 0;
		
		
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*101);
			//System.out.println(arr[i]);
			while(arr[i] > biger) {
				biger = arr[i];
				bigerIndex = i;
			}
		}
		System.out.println("biggest number in arr is: " + biger);
		System.out.println("biggest number index is: " + bigerIndex);

	}

}
