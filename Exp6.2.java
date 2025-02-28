import java.util.*;
import java.util.stream.Collectors;

class Student {
    String name;
    double marks;

    // Constructor
    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    // Display method
    public void display() {
        System.out.println(name + " - " + marks);
    }
}

public class StudentFilterSort {
    public static void main(String[] args) {
        // Step 1: Create List of Students
        List<Student> students = Arrays.asList(
                new Student("Alice", 80),
                new Student("Bob", 72),
                new Student("Charlie", 90),
                new Student("David", 65),
                new Student("Eve", 85),
                new Student("Frank", 65)
        );

        // Step 2: Filter, Sort, and Collect Students with Marks > 75
        List<Student> filteredAndSortedStudents = students.stream()
                .filter(s -> s.marks > 75)  // Filter students who scored above 75%
                .sorted(Comparator.comparingDouble((Student s) -> -s.marks)  // Sort by marks descending
                        .thenComparing(s -> s.name)) // Sort by name if marks are the same
                .collect(Collectors.toList());

        // Step 3: Display Results
        if (filteredAndSortedStudents.isEmpty()) {
            System.out.println("No students scored above 75%.");
        } else {
            filteredAndSortedStudents.forEach(Student::display);
        }
    }
}
//Madhavi kumawat_22BCS12660
