import java.util.Scanner;

public class SchoolStatistics {

	public static void main(String[] args) {
		School school = new School();
		ClassRoom[] classesArr = school.getClassRoom();

		System.out.println("School AVG is:" + school.getSchoolAvg());

		System.out.println("=======Classes=======");
		school.showClassesAvg();
		System.out.println("=====================\n");

		System.out.println("=======================School avg for specific subject=======================");
		System.out.println("###### Options: MATH, CHEMISTRY, GEOGRAPHY, LITERATHURE, PHYSICS, SPORTS #####");
		System.out.println("------------------------------------------------------------------------------");
		Scanner sc = new Scanner(System.in);
		System.out.println("please enter subject name");
		System.out.println(school.getSchoolSubjectAVG(sc.nextLine()));
		sc.close();
		System.out.println("##(NOTE: if resutls show -1, subject not exist or there is no grades for it)##");
		System.out.println("==============================================================================\n");

		System.out.println("#####################    BONUS     #####################\n\n");
		System.out.println("=======Class Young Students=======");
		for (ClassRoom classRoom : classesArr) {
			classRoom.getYoungStudents();
		}
		System.out.println("==================================\n");

		System.out.println("=======Class \"Old\" Students=======");
		for (ClassRoom classRoom : classesArr) {
			classRoom.getOldStudents();
		}
		System.out.println("==================================\n");
	}

}
