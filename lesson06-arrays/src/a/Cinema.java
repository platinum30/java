package a;

import java.util.Scanner;

/**
 * create a cinema
 * @author plati
 *
 */
public class Cinema {
		private char matrix[][];

		public Cinema(int rows, int seats) {
			matrix = new char[rows][seats];
			for (int row = 0; row < matrix.length; row++) {
				for (int seat = 0; seat < matrix[row].length; seat++) {
					matrix[row][seat] = 'O';
				}
			}
		}
		
		public void display() {
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					System.out.print(matrix[i][j] + "\t");
				}
				
				System.out.println();
			}
			System.out.println("===========================");
		}
		public static void main(String[] args) {

		}
		
		public boolean add(int row, int seat) {
			if(row <= matrix.length && seat <= matrix[0].length  ) {// check if the seat exist
				System.out.println("seat exist");
				if( matrix[row -1][seat - 1] == 'O'){// check if the seat is not taken
					System.out.println("seat is not taken");
					matrix[row -1][seat - 1] = 'X';
					return true;
				}else {
					return false;
				}

			}else {
				System.out.println("seat is not exist");
				return false;
			}
		}


		
		

}
