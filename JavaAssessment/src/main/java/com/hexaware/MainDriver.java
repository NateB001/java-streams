package com.hexaware;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.Comparator;

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
		
		List<Integer> intList1 = new ArrayList<>();
		
		intList1.add(5);
		intList1.add(13);
		intList1.add(4);
		intList1.add(21);
		intList1.add(13);
		intList1.add(27);
		intList1.add(2);
		intList1.add(59);
		intList1.add(59);
		intList1.add(34);
		
		//List out the duplicates
		Set<Integer> elementSet = new HashSet<>();

		System.out.printf("%nList of all duplicates:%n");
		intList1.stream().filter(n -> !elementSet.add(n)).collect(Collectors.toSet()).forEach(System.out::println);
		
		List<Integer> intList2 = new ArrayList<>();
		
		intList2.add(4);
		intList2.add(5);
		intList2.add(7);
		intList2.add(8);
		intList2.add(99);
		intList2.add(100);
		intList2.add(101);
		intList2.add(33);
		intList2.add(32);
		intList2.add(4);
		intList2.add(4);
		
		//Remove all duplicates without Set
		List<Integer> listWithoutDuplicates = intList2.stream().distinct().collect(Collectors.toList());
		
		System.out.printf("%nList with all duplicates removed:%n");
		System.out.println(listWithoutDuplicates);
		
		List<Integer> intList3 = new ArrayList<>();
		
		intList3.add(3);
		intList3.add(90);
		intList3.add(350);
		intList3.add(5);
		
		//Get the max value of list
		Integer maxValue = intList3.stream().max(Comparator.comparing(Integer::valueOf)).get();
		System.out.printf("%nMax value of list:%n");
		System.out.println(maxValue);
		
		List<Integer> intList4 = new ArrayList<>();
		
		intList4.add(6);
		intList4.add(8);
		intList4.add(3);
		intList4.add(5);
		intList4.add(1);
		intList4.add(9);
		
		//Get max and min values of list
		System.out.printf("%nMax and values of list:%n");
		
		//max
		maxValue = intList4.stream().max(Comparator.comparing(Integer::valueOf)).get();
		//min
		Integer minValue = intList4.stream().min(Comparator.comparing(Integer::valueOf)).get();
		
		System.out.println("Max: " + maxValue);
		System.out.println("Min: " + minValue);
	}

}
