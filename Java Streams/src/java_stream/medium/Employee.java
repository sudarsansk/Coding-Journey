package java_stream.medium;

public class Employee {

	String name;
	String department;
	int salary;
	
	public Employee(String name, String department, int salary) {
		this.name = name;
		this.department = department;
		this.salary = salary;
	}
	
	public String getDepartment() {
		return this.department;
	}
	
	public int getSalary() {
		return this.salary;
	}
	
	public String getName() {
		return this.name;
	}
}
