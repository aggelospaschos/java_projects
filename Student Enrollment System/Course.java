import java.util.*;

// Define a class named Course representing a course in a school
class Course {
    // Private instance variables to store courseId, courseName, capacity, and enrolledStudents
    private int courseId;
    private String courseName;
    private int capacity;
    // The enrolledStudents list will store the students enrolled in a particular course
    // It is declared as a List of Student objects, indicating a one-to-many relationship between a course and enrolled students
    private List<Student> enrolledStudents;

    // Constructor to initialize a Course object with courseId, courseName, and capacity
    public Course(int courseId, String courseName, int capacity) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.capacity = capacity;
        // Initialize the enrolledStudents list with a new ArrayList instance.
        // This ensures that the list is ready to store Student objects when a new Course object is created
        this.enrolledStudents = new ArrayList<>();
    }

    // Getter method to retrieve the courseId of the course
    public int getCourseId() {
        return courseId;
    }

    // Getter method to retrieve the courseName of the course
    public String getCourseName() {
        return courseName;
    }

    // Getter method to retrieve the capacity of the course
    public int getCapacity() {
        return capacity;
    }

    // Getter method to retrieve the list of enrolled students in the course
    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    // Method to enroll a student in the course
    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    // Method to remove a student from the list of enrolled students in the course
    public void removeEnrolledStudent(Student student) {
        enrolledStudents.remove(student);
    }
}
