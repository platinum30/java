import java.util.ArrayList;
import java.util.List;

import a.tar.lab.Employee;
import a.tar.lab.EmployeeStatistics;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> emps = getRandomEmps(10);
		EmployeeStatistics.print(emps);

	}

	public static List<Employee> getRandomEmps(int size) {
		List<Employee> emps = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			String name = names[(int) (Math.random() * names.length)];
			double salary = (int) (Math.random() * 20_000);
			String department = departments[(int) (Math.random() * departments.length)];
			emps.add(new Employee(name, salary, department));
		}
		return emps;
	}

	private static String[] names = { "Dan", "Danna", "Rina", "Yossi", "Moshe" };
	private static String[] departments = { "Legal", "Sales", "Thechnical" };

}
