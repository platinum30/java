package test01FlowCharts;

import java.util.Scanner;

public class SevenBoom {
	public static int small;
	public static int big;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		if(a>b || a==b) {
			big = a;
			small = b;
		}else {
			big = b;
			small = a;
		}
		sevenBoom();
		
	}
	
	public static void sevenBoom() {
		for (int i = small; i <=big; i++) {
			if(i%7 == 0) {
				System.out.println("BOOM" + " , ");
				continue;
			}
			int x = i;
			while(x != 0) {
				//System.out.println(x%10);
				if(x%10 == 7) {
					System.out.print("BOOM" + " , ");
					break;
				}else {
					x = (int)(x/10);
				}
			}
			if(x == 0) {
				System.out.print(i + " , ");
			}
			
		}
	}

}
