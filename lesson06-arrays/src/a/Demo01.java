package a;

public class Demo01 {
	public static void main(String[] args) {
		int[][] matrix = new int[3][10];
		matrix[2][4] = 100;
		System.out.println(matrix[0][0]);
		System.out.println(matrix[2][9]);
		System.out.println(matrix[matrix.length-1][4]);
		System.out.println("matrix length: " + matrix.length);
		System.out.println("arr in element id 2 of matrix length: " + matrix[2].length);
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = (int)(Math.random()*11);
				System.out.print(matrix[i][j] + ", ");
			}
			System.out.println();
		}
		
		
		
		
		
	}
}
