package application;

// Defines a Student with properties like name, ID, age, and year of study
public class Student {
    // Student properties
    private String name;
    private int id;
    private int age;
    private int yearOfStudy; // Added field to represent the year of study

    // Constructor: Initializes a new instance of the Student class
    public Student(String name, int id, int age, int yearOfStudy) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.yearOfStudy = yearOfStudy;
    }

    // Getter for name: Returns the student's name
    public String getName() {
        return name;
    }

    // Setter for name: Updates the student's name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for ID: Returns the student's ID
    public int getId() {
        return id;
    }

    // Setter for ID: Updates the student's ID
    public void setId(int id) {
        this.id = id;
    }

    // Getter for age: Returns the student's age
    public int getAge() {
        return age;
    }

    // Setter for age: Updates the student's age
    public void setAge(int age) {
        this.age = age;
    }

    // Getter for year of study: Returns the student's current year of study
    public int getYearOfStudy() {
        return yearOfStudy;
    }

    // Setter for year of study: Updates the student's current year of study
    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    // toString method: Returns a string representation of the student
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", yearOfStudy=" + yearOfStudy +
                '}';
    }
}
