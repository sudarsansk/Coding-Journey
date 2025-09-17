package java_stream.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JavaStreamMedium {

	public static void main(String[] args) {
		
		//1. Group By and Count
		//2. Flatten Nested Collections
		//3. Find Top N Elements
		//4. Partitioning
		//5. Create a comma-separated string of employee names from a specific department.
		//6. Distinct and Sort
		
		List<Employee> employees = Arrays.asList(
				new Employee("Sudarsan", "ECE", 35000),
				new Employee("Mathi", "Mech", 60000),
				new Employee("Sreni", "Mech", 50000),
				new Employee("Sabari", "IT", 135000));
		
		func_1_3(employees);
		func_2_4();
		func_5();
		func_6(employees);
		
		
		
	}

	private static void func_6(List<Employee> employees) {
		Map<String, List<String>> result = employees.stream().collect(Collectors.groupingBy((Employee::getDepartment), Collectors.mapping(Employee::getName, Collectors.toList())));
		System.out.println(result); //{ECE=[Sudarsan], Mech=[Mathi, Sreni], IT=[Sabari]}
		
		String itEmployees = employees.stream()
	            .filter(emp -> "Mech".equals(emp.getDepartment()))  // Filter IT department
	            .map(Employee::getName)                           // Get only names
	            .collect(Collectors.joining(", "));
		System.out.println(itEmployees); //Mathi, Sreni
		
		//For all Department
		Map<String, String> departmentEmployees = employees.stream()
	            .collect(Collectors.groupingBy(
	                Employee::getDepartment,
	                Collectors.mapping(
	                    Employee::getName,
	                    Collectors.joining(", ")
	                )
	            ));
	        
	    departmentEmployees.forEach((dept, names) -> 
	            System.out.println(dept + ": " + names));
	    //ECE: Sudarsan
	    //Mech: Mathi, Sreni
	    //IT: Sabari
	}

	private static void func_5() {
		List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 3);

		List<Integer> result = numbers.stream().distinct().sorted().collect(Collectors.toList()); //[1, 2, 3, 4, 5, 6, 9]
		Collections.reverse(result); //[9, 6, 5, 4, 3, 2, 1]
		System.out.println(result); 
	}

	private static void func_2_4() {
		List<List<Integer>> nested = Arrays.asList(Arrays.asList(1,2,3), Arrays.asList(4,5,6), Arrays.asList(7,8,9));
		
		//Using FlatMap
		List<Integer> flattern = nested.stream().flatMap(List::stream).collect(Collectors.toList());
		
		//Without using FlatMap
		nested.stream().map(e -> new ArrayList<>(e)).reduce(new ArrayList<>(), (a, b) -> { 
			a.addAll(b);
			return a;
		});
		
		Map<Boolean, List<Integer>> result = flattern.stream().collect(Collectors.groupingBy(n -> n%2 == 0));
		System.out.println(result);
		
		Map<Boolean, List<Integer>> result2 = flattern.stream().collect(Collectors.partitioningBy(n-> n%2 == 0));
		System.out.println(result2); //{false=[1, 3, 5, 7, 9], true=[2, 4, 6, 8]}
	}

	private static void func_1_3(List<Employee> employees) {
		Map<String, Long> output = employees.stream().collect(Collectors.groupingBy((Employee::getDepartment), Collectors.counting()));
		System.out.println(output); //{ECE=1, Mech=2, IT=1}

		
		List<Integer> result = employees.stream().map(e -> e.getSalary()).sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());
		System.out.println(result); //[135000, 60000, 50000]
		
		//Direct Sort Logic
		List<Employee> result2 = employees.stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed()).limit(3).collect(Collectors.toList());
		System.out.println(result2.toString());
	}

}
