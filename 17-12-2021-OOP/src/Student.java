import java.util.Arrays;

public class Student extends Person {
	private final int MAX_GRADES = 6;
	private Grade[] grades = new Grade[MAX_GRADES];

	public Student() {
		super();
		FillGrades();
	}

	public Student(Grade[] grades) {
		super();
		this.grades = grades;
	}

	public Grade[] getGrades() {
		return grades;
	}

	public void setGrades(Grade[] grades) {
		this.grades = grades;
	}

	public void FillGrades() {
		for (int i = 0; i < grades.length; i++) {
			while (grades[i] == null) {
				AddGrade();
			}
		}
	}

	public boolean AddGrade() {
		int randScore = getRandomScore();
		Grade newGrade = new Grade(Proffesion.getRandProffesion(), randScore);
		boolean found = false;
		boolean added = false;
		for (Grade grade : grades) {
			if (grade != null) {
				if (grade.getProfession() == newGrade.getProfession()) {
					found = true;
					break;
				}
			}
		}
		if (!found) {
			for (int i = 0; i < grades.length; i++) {
				if (grades[i] == null) {
					grades[i] = newGrade;
					added = true;
					break;
				}
			}
		}

		return added;

	}

	public static int getRandomScore() {
		int rand = (int) (Math.random() * 61 + 40);
		return rand;
	}

	@Override
	public String toString() {
		String student;
		student = "Name: " + this.name + "Age: " + this.age;
		student += "\n" + "Student Grades: [" + Arrays.toString(grades) + "]";
		return student;
	}

	public int getGradesAvg() {
		int avg = 0;
		int sum = 0;
		for (int i = 0; i < grades.length; i++) {
			sum += grades[i].getScore();
		}
		avg = sum / grades.length;
		return avg;
	}

	/**
	 * func get subject name, and return student score for the given subject, if
	 * score not found, func return -1
	 * 
	 * @param subject
	 * @return
	 */
	public int getStudentSubjectScore(String subject) {
		int score = -1;
		for (Grade grade : grades) {
			if (grade.getProfession().equals(subject)) {
				score = grade.getScore();
			}
		}
		return score;
	}
}
