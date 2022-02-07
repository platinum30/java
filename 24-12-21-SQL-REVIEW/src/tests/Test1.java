package tests;

import java.time.LocalDate;

import app.core.beans.Student;
import app.core.dao.StudentDao;
import app.core.exceptions.UniversityException;

public class Test1 {
	static StudentDao studentDao = new StudentDao();

	public static void main(String[] args) {
		// addStudent();
		try {
			// find(100);
			// update(1);
			findAll();
			delete(5);
		} catch (UniversityException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}

	public static void addStudent() {
		try {
			int id = studentDao.create(new Student("Dana", LocalDate.of(2018, 2, 14), true));
			System.out.println("Student created" + id);
		} catch (UniversityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void find(int id) throws UniversityException {
		System.out.println(studentDao.findById(id));
	}

	public static void update(int id) throws UniversityException {
		Student student = new Student(id, "AAA", LocalDate.of(1991, 5, 27), false);
		studentDao.update(student);
	}

	public static void findAll() throws UniversityException {
		for (Student st : studentDao.findAll()) {
			System.out.println(st);
		}
	}

	public static void delete(int id) throws UniversityException {
		if (studentDao.delete(id)) {
			System.out.println("user - " + id + " was deleted");
		} else {
			System.out.println("delete failed: user " + id + " not found");

		}
	}

}
