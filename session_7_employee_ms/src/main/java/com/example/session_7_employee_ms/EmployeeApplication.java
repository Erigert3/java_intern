package com.example.session_7_employee_ms;

import com.example.session_7_employee_ms.entity.Employee;
import com.example.session_7_employee_ms.repository.EmployeeRepository;
import com.example.session_7_employee_ms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(EmployeeService employeeService) {
		return args -> {
			Scanner scanner = new Scanner(System.in);
			while (true) {
				System.out.println("\n===== Employee Management =====");
				System.out.println("1 - Find employees by department");
				System.out.println("2 - Find employees with salary greater than");
				System.out.println("3 - Find employees whose last name contains");
				System.out.println("4 - Find employees hired after a date");
				System.out.println("5 - Execute native salary query");
				System.out.println("6 - Show first page (5 employees)");
				System.out.println("7 - Show employees sorted by salary (descending)");
				System.out.println("0 - Exit");
				System.out.print("Choose an option: ");

				int option = Integer.parseInt(scanner.nextLine());
				switch (option) {
					case 1 -> {
						System.out.print("Department: ");
						String department = scanner.nextLine();
						List<Employee> employees = employeeService.getEmployeesByDepartment(department);
						for(Employee e : employees){
							System.out.println(e.toString() + "\n");
						}

					}
					case 2 -> {
						System.out.print("Minimum salary: ");
						BigDecimal salary = new BigDecimal(scanner.nextLine());
						List<Employee> employees = employeeService.getEmployeesBySalaryGreaterThan(salary);
						for (Employee e : employees) {
							System.out.println(e.toString() + "\n");
						}
					}
					case 3 -> {
						System.out.print("Last name contains: ");
						String text = scanner.nextLine();
						List<Employee> employees = employeeService.getEmployeesByLastNameContaining(text);
						for(Employee e : employees) {
							System.out.println(e.toString() + "\n");
						}
					}
					case 4 -> {
						System.out.print("Hire date (yyyy-MM-dd): ");
						LocalDate hireDate = LocalDate.parse(scanner.nextLine());
						List<Employee> employees = employeeService.getEmployeesByHiredAfter(hireDate);
						for(Employee e : employees) {
							System.out.println(e.toString() + "\n");
						}
					}
					case 5 -> {
						System.out.print("Minimum salary: ");
						BigDecimal salary = new BigDecimal(scanner.nextLine());
						List<Employee> employees = employeeService.getEmployeesBySalaryGreaterThanGiven(salary);
						for(Employee e : employees) {
							System.out.println(e.toString() + "\n");
						}
					}
					case 6 -> {
						System.out.println("First page of Employees: ");
						Page<Employee> employees = employeeService.getFirstPageOfEmployees();
						for(Employee e : employees) {
							System.out.println(e.toString() + "\n");
						}
					}
					case 7 -> {
						System.out.println("Employees ordered by salary in descending order: ");
						List<Employee> employees = employeeService.getAllEmployeesSortedBySalaryDescending();
						for(Employee e : employees) {
							System.out.println(e.toString() + "\n");
						}
					}
					case 0 -> {
						System.out.println("Goodbye!");
						return;
					}
					default -> System.out.println("Invalid option.");
				}
			}
		};
	}
}
