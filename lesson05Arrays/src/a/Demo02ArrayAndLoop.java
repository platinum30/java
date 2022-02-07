package a;

public class Demo02ArrayAndLoop {

	public static void main(String[] args) {
		//create an array of ints
		int[] arr= new int[3];
		
		//populate the array with random numbers
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random()*101);
		}
		
		//iterate over the array elements and print each element
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
