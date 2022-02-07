package a;

public class Demo03 {

	public static void main(String[] args) {
		
		//matrix with all arrays with the same length
		int[][] matrix = new int[5][3];
		
		//2d array - inner arrays may be with different length
		int[][] arr = new int[5][];
		
		arr[0] = new int[5];
		arr[1] = new int[4];
		arr[2] = new int[10];
		arr[3] = new int[1];
		arr[4] = new int[8];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

		

	}

}
