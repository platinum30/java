package a;

import java.util.Iterator;

public class Exercise7_04 {
	public static void main(String[] args) {
		
		int[] arr = new int[10];
		int[] arr2 = new int[10];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*11);
		}
		
		int counter = arr.length -1;
		for (int i = 0; i < arr.length; i++) {
			if (counter >= 0) {
				arr2[counter] = arr[i];
				counter--;
			}
		}
		System.out.println("the array is: ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println();
		System.out.println("the reverse array is: ");
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + ", ");
		}
		
		/*
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*11);
			System.out.print(arr[i] + ", ");
		}
		System.out.println();
		System.out.println("_________");
		for (int i = 0; i < arr.length/2; i++) {
			int temp = arr[i];
			arr[i] = arr[(arr.length-i-1)] = temp;
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		*/
	}
}
