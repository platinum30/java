import java.util.Arrays;

public class School {
	private final int MAX_CLASSES = 5;
	private ClassRoom[] classRoom = new ClassRoom[MAX_CLASSES];

	public School() {
		fillSchool();
	}

	public void fillSchool() {
		for (int i = 0; i < classRoom.length; i++) {
			ClassRoom class1 = new ClassRoom("Class " + (i + 1));
			classRoom[i] = class1;
		}
	}

	public ClassRoom[] getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(ClassRoom[] classRoom) {
		this.classRoom = classRoom;
	}

	@Override
	public String toString() {
		return "School [classRoom=" + Arrays.toString(classRoom) + "]";
	}

	public int getSchoolAvg() {
		int avg = 0;
		int sum = 0;
		for (int i = 0; i < classRoom.length; i++) {
			sum += classRoom[i].getClassAvg();
		}
		avg = sum / classRoom.length;
		return avg;
	}

	public void showClassesAvg() {
		for (ClassRoom classRoom2 : classRoom) {
			System.out.println("Class name:" + classRoom2.getName() + " | AVG: " + classRoom2.getClassAvg());
		}
	}

	/**
	 * func get subject name and return String with the subject name and the school
	 * avg for the given sbjuct
	 * 
	 * @param subject
	 * @return
	 */
	public String getSchoolSubjectAVG(String subject) {
		int avg = -1;
		int sum = 0;
		int c = 0;
		for (ClassRoom classRoom2 : classRoom) {
			int classScore = classRoom2.getClassSubjectAVG(subject);
			if (classScore > 0) {
				sum += classScore;
				c++;
			}
		}
		if (c > 0) {
			avg = sum / c;
		}
		return "School AVG for subject " + subject + " is: " + avg;
	}

}
