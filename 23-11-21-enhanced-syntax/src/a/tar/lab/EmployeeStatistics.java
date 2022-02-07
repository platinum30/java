package a.tar.lab;

import java.util.List;

public class EmployeeStatistics {
	public static double averageSalary(List<Employee> emps) {
		double sum = 0;
		for (Employee emp : emps) {
			sum += emp.getSalary();
		}
		double avg = sum / emps.size();
		return avg;
	}

	public static int numOfEmployees(List<Employee> emps) {
		return emps.size();
	}

	public static int numOfEmployees(List<Employee> emps, String department) {
		int c = 0;
		for (Employee emp : emps) {
			if (emp.getDepartment().equals(department)) {
				c++;
			}
		}
		return c;
	}

	public static void print(List<Employee> emps) {
		System.out.println("======Employees======");
		for (Employee employee : emps) {
			System.out.println(employee);
		}
		System.out.println("=====================");
	}
}
