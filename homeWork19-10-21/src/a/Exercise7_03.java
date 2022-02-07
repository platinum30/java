package a;

public class Exercise7_03 {

	public static void main(String[] args) {
		int[] arr = new int[9];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*11);
		}
		
		int counter = 0;
		
		for (int i = 1; i < 10; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(arr[j] == i) {
					counter++;
					break;
				}
			}
		}
		
		int[] arr2 = new int[counter];
		for (int i = 0; i < arr2.length; i++) {//set all arr2 ints to 111
			arr2[i] = 111;
		}
		
		boolean found = false;
		for (int i = 0; i < arr.length; i++) {//runs on arr1 numbers
			
			for (int j = 0; j < arr2.length; j++) {//runs on arr2 numbers
				if(arr[i] == arr2[j]) {//
					found = true;
					break;
				}
			}
			
			if(found == false) {
				for (int j = 0; j < arr2.length; j++) {
					if(arr2[j] == 111) {
						arr2[j] = arr[i];
						break;
					}
				}
			}else {
				found = false;
			}
		}
		
		System.out.println("arr1:");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println();
		System.out.println("arr2:");
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + ", ");
		}
		
	}

}
