/**
 * @author USER
 *
 */
public class ClassRoom {
	private String name;
	private Teacher theacher;
	private final int MAX_STUDENTS = 15;
	private Student[] students = new Student[MAX_STUDENTS];

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Teacher getTheacher() {
		return theacher;
	}

	public void setTheacher(Teacher theacher) {
		this.theacher = theacher;
	}

	public Student[] getStudents() {
		return students;
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}

	public ClassRoom(String name) {
		Teacher teacher = new Teacher();
		fillClassRoom();
		this.name = name;
		this.theacher = teacher;
	}

	public void fillClassRoom() {
		for (int i = 0; i < students.length; i++) {
			Student student = new Student();
			students[i] = student;
		}
	}

	@Override
	public String toString() {
		return "ClassRoom [name=" + name + ", theacher=" + theacher + ", students=" + students.length + "]" + "\n";
	}

	/**
	 * func return class avg
	 * 
	 * @return
	 */
	public int getClassAvg() {
		int avg = 0;
		int sum = 0;

		for (int i = 0; i < students.length; i++) {
			sum += students[i].getGradesAvg();
		}
		avg = sum / students.length;
		return avg;
	}

	/**
	 * func get subject name and return AVG of all class, for the given subject if
	 * subject scores not found, func will return -1
	 * 
	 * @param subject
	 * @return
	 */
	public int getClassSubjectAVG(String subject) {
		int avg = -1;
		int sum = 0;
		int c = 0;
		for (Student student : students) {
			int studentScore = student.getStudentSubjectScore(subject);
			if (studentScore != -1) {
				sum += studentScore;
				c++;
			}

		}
		if (c > 0) {
			avg = sum / c;
		}
		return avg;
	}

	/**
	 * func return class name, and quantity of young student(age=20-30), and there
	 * grades AVG
	 */
	public void getYoungStudents() {
		int c = 0;
		int sum = 0;
		int avg = 0;
		for (Student student : students) {
			if (student.getAge() >= 20 && student.getAge() <= 30) {
				sum += student.getGradesAvg();
				c++;
			}
		}
		if (c > 0) {
			avg = sum / c;
			System.out.println(
					"Class name: " + this.name + " | Young Quantity: " + c + " | Avg of young students: " + avg);
		} else {
			System.out.println("Class name: " + this.name + " | Young Quantity: " + c);
		}

	}

	/**
	 * func return class name, and quantity of "old" student(age>=31), and there
	 * grades AVG
	 */
	public void getOldStudents() {
		int c = 0;
		int sum = 0;
		int avg = 0;
		for (Student student : students) {
			if (student.getAge() >= 31) {
				sum += student.getGradesAvg();
				c++;
			}
		}
		if (c > 0) {
			avg = sum / c;
			System.out.println(
					"Class name: " + this.name + " | \"Old\" Quantity: " + c + " | Avg of \"old\" students: " + avg);
		} else {
			System.out.println("Class name: " + this.name + " | \"Old\" Quantity: " + c);
		}

	}
}
