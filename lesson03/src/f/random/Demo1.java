package f.random;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//will print double between 0 - 0.9999
		System.out.println(Math.random());
		
		//0-9.99999
		System.out.println(Math.random()*10);
		
		//0-10.9999
		System.out.println(Math.random()*11);
		
		//0-10
		System.out.println((int)(Math.random()*10));
		int r = (int)(Math.random()*10);
		
		//0-25
		System.out.println(Math.random() * 26);
		
		//0-3
		System.out.println(Math.random()*4);
		
		//10-20
		System.out.println(Math.random()*10+10);
		
		//-5  -  5
		System.out.println(Math.random()*10-5);
		
		//random between 
		int a = 100;
		int b = 102;
		int rnd = (int)(Math.random() *  (b-a+1)) + a;
		System.out.println(rnd);
		

	}

}
