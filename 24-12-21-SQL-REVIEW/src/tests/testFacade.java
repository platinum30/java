package tests;

import java.time.LocalDate;

import app.core.beans.Student;
import app.core.exceptions.UniversityException;
import app.core.facades.UniversityFacade;

public class testFacade {
	public static void main(String[] args) {
		UniversityFacade uFacade = new UniversityFacade();

		try {
			Student st = new Student(3, "David", false);
			Student st2 = uFacade.getStudent(3);
			Student st3 = new Student(3, "David", LocalDate.of(2020, 12, 1), false);
			Student st4 = new Student("Monika", LocalDate.of(2020, 12, 1), false);
			// uFacade.adddStudent(st4);
			// uFacade.deActiveStudent(3);
			if (uFacade.deleteStudent(1)) {
				System.out.println("student deleted");
			}
			// uFacade.updateStudent(st3);

		} catch (UniversityException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}

	}
}
