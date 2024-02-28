package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentManagement {
    private static final List<Student> students = new ArrayList<>();

    /**
     * Adds a new student to the list.
     * @param student The student to be added.
     */
    public static void addStudent(Student student) {
        // Check if a student with the same ID already exists
        if(findStudentById(student.getId()) != null) {
            System.out.println("Error: A student with ID " + student.getId() + " already exists.");
            return;
        }
        
        students.add(student);
        System.out.println("Student successfully added: " + student);
    }

    /**
     * Updates the information of a student based on their ID.
     * @param updatedStudent The student with updated information.
     */
    public static void updateStudent(Student updatedStudent) {
        Optional<Student> studentOptional = students.stream()
                .filter(student -> student.getId() == updatedStudent.getId())
                .findFirst();

        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setName(updatedStudent.getName());
            student.setAge(updatedStudent.getAge());
            student.setYearOfStudy(updatedStudent.getYearOfStudy());
            System.out.println("Student successfully updated: " + student);
        } else {
            System.out.println("Error: Student with ID " + updatedStudent.getId() + " not found.");
        }
    }

    /**
     * Displays information about a student based on their ID.
     * @param id The ID of the student to be viewed.
     */
    public static void viewStudent(int id) {
        Optional<Student> studentOptional = students.stream()
                .filter(student -> student.getId() == id)
                .findFirst();

        if (studentOptional.isPresent()) {
            System.out.println("Student details: " + studentOptional.get());
        } else {
            System.out.println("Error: Student with ID " + id + " not found.");
        }
    }

    /**
     * Helper method to print all students (optional).
     */
    public static void printAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students have been added yet.");
        } else {
            System.out.println("All students:");
            students.forEach(System.out::println);
        }
    }
    
    /**
     * Finds a student by their ID.
     * @param id The ID of the student to find.
     * @return The found student or null if not found.
     */
    public static Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null; // Return null if the student is not found
    }
    
    /**
     * Returns a new list containing all students.
     * @return A list of all students.
     */
    public static List<Student> getAllStudents() {
        return new ArrayList<>(students); // Returns a new list that contains all students
    }
}
