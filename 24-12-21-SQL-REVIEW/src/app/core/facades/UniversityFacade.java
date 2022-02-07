package app.core.facades;

import app.core.beans.Student;
import app.core.dao.StudentDao;
import app.core.exceptions.UniversityException;

public class UniversityFacade {// all business logic will be here - by example, check if student is active
								// before delete
	private static StudentDao studentDao = new StudentDao();

	public int adddStudent(Student student) throws UniversityException {
		return studentDao.create(student);
	}

	public boolean deleteStudent(int studentId) throws UniversityException {
		Student st = studentDao.findById(studentId);
		if (st.isActive()) {
			throw new UniversityException("cannot delete active students");
		}
		return studentDao.delete(studentId);
	}

	public void deActiveStudent(int studentId) throws UniversityException {
		Student st = studentDao.findById(studentId);
		if (!st.isActive()) {
			throw new UniversityException("student already deActive");
		}
		st.setActive(false);
		studentDao.update(st);
		System.out.println("student " + st.getId() + " de activated successfully");
	}

	public void updateStudent(Student student) throws UniversityException {
		int id = student.getId();
		Student st = studentDao.findById(id);
		if (!student.getEnrollDate().equals(st.getEnrollDate())) {
			System.out.println("cannot update student Enroll date");
		} else {
			studentDao.update(student);
			System.out.println("student " + student.getId() + " updated successfully");
		}
	}

	public Student getStudent(int id) throws UniversityException {
		Student student = studentDao.findById(id);
		return student;
	}
}
