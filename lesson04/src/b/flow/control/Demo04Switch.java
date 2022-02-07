package b.flow.control;

public class Demo04Switch {
	public static void main(String[] args) {
		int grade = (int)(Math.random()*16); //rand 0-10 inclusive
		 System.out.println(grade);
		 
		 switch(grade) {//switch key can get byte, short, int, string, enum
		 case 0:
		 case 1:
		 case 2:
		 case 3:
		 case 4:
		 case 5:
			 System.out.println("fail");
			 break;
		 case 6:
			 System.out.println("pass");
			 break;
		 case 7:
		 case 8:
			 System.out.println("good");
			 break;
		 case 9:
		 case 10:
			 System.out.println("great");
			 break;
			default:
				System.out.println(grade + " is not a valid grade");
		 }
	}
}
