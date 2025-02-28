import java.util.*;
import java.util.stream.Collectors;

class Employee {
    String name;
    int age;
    double salary;

    // Constructor
    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // Display method
    public void display() {
        System.out.println("Name: " + name + ", Age: " + age + ", Salary: " + salary);
    }
}

public class EmployeeSorter {
    public static void main(String[] args) {
        // Step 1: Initialize Employee List
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 30, 50000));
        employees.add(new Employee("Bob", 25, 60000));
        employees.add(new Employee("Charlie", 35, 55000));

        // Additional test cases
        employees.add(new Employee("Alex", 28, 45000));
        employees.add(new Employee("Alex", 32, 47000));
        employees.add(new Employee("Alex", 25, 46000));
        employees.add(new Employee("David", 29, 50000));
        employees.add(new Employee("Eve", 31, 50000));
        employees.add(new Employee("Frank", 27, 50000));

        // Step 2: Sorting using Lambda and Streams

        // Sort by Name (Alphabetical Order)
        List<Employee> sortedByName = employees.stream()
                .sorted(Comparator.comparing(e -> e.name))
                .collect(Collectors.toList());

        // Sort by Age (Ascending Order)
        List<Employee> sortedByAge = employees.stream()
                .sorted(Comparator.comparingInt(e -> e.age))
                .collect(Collectors.toList());

        // Sort by Salary (Descending Order)
        List<Employee> sortedBySalary = employees.stream()
                .sorted(Comparator.comparingDouble(e -> -e.salary)) // Negative for descending order
                .collect(Collectors.toList());

        // Step 3: Displaying Sorted Lists
        System.out.println("Sorted by Name:");
        sortedByName.forEach(Employee::display);

        System.out.println("\nSorted by Age:");
        sortedByAge.forEach(Employee::display);

        System.out.println("\nSorted by Salary:");
        sortedBySalary.forEach(Employee::display);
    }
}
//Madhavi kumawat_22BCS12660
