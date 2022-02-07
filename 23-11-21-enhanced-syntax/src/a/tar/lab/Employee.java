package a.tar.lab;

public class Employee {
	private String name;
	private double salary;
	private String department;

	// CTOR
	public Employee() {

	}

	public Employee(String name, double salary, String department) {
		super();
		this.name = name;
		this.salary = salary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", department=" + department + "]";
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
