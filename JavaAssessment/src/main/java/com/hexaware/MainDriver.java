package com.hexaware;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.hexaware.models.Employee;

public class MainDriver {

	public static void main(String[] args) {
		
		List<Employee> empList = new ArrayList<>();
		
		empList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		empList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		empList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		empList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		empList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		empList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		empList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		empList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		empList.add(new Employee(277, "Anuj", 31, "Male", "Product Development", 2012, 35700.0));
		
		//Count the number of employees in each department
		System.out.println("Count of employees in each department:");
		Map<String, Long> employeeCountByDepartment =
		         empList.stream().collect(Collectors.groupingBy(Employee::getDepartment, TreeMap::new, Collectors.counting()));
		
		employeeCountByDepartment.forEach((department, count) -> System.out.println(department + " has " + count + " employee(s)"));
		
		//List down the names of all employees in each department
		System.out.printf("%nList of all employees in each department:%n");
		Map<String, List<Employee>> employeeNamesByDepartment =
		         empList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		
		employeeNamesByDepartment.forEach((department, employeesInDepartment) -> 
		         {
		        	System.out.printf("%n--------------------------------------%n");
		            System.out.println(department);
		            System.out.println("--------------------------------------");
		            employeesInDepartment.forEach(employee -> System.out.println(employee.getName()));
		         }
		      );
	}

}
