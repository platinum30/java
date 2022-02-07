package a;

public class App1 {

	public static void main(String[] args) {

		//integer
		int x = 5;
		//decimal
		double y = 5.3;
		//boolean
		boolean areYouHappy = true;
		System.out.println(areYouHappy);
		//string
		String str="text";
		System.out.println(str);
		
		// create an object of type product
		Product product = new Product();
		product.name = "shirt";
		product.price = 25;
		System.out.println(product.name);
		
	}

}
