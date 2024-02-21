import java.util.*;

public class Student {
	
    // Private instance variables to store studentId, firstName, lastName, and coursesEnrolled
    private int studentId;
    private String firstName;
    private String lastName;
    
    // The coursesEnrolled list will store the courses in which a student is enrolled
    // It is declared as a List of Course objects, indicating a one-to-many relationship between a student and courses
    private List<Course> coursesEnrolled;

    // Constructor to initialize a Student object with studentId, firstName, and lastName
    public Student(int studentId, String firstName, String lastName) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        
        // Initialize the coursesEnrolled list with a new ArrayList instance.
        // This ensures that the list is ready to store Course objects when a new Student object is created
        this.coursesEnrolled = new ArrayList<>();
    }

    // Getter method to retrieve the studentId of the student
    public int getStudentId() {
        return studentId;
    }

    // Getter method to retrieve the firstName of the student
    public String getFirstName() {
        return firstName;
    }

    // Getter method to retrieve the lastName of the student
    public String getLastName() {
        return lastName;
    }

    // Getter method to retrieve the list of courses in which the student is enrolled
    public List<Course> getCoursesEnrolled() {
        return coursesEnrolled;
    }

    // Method to enroll the student in a course
    public void enrollInCourse(Course course) {
        coursesEnrolled.add(course);
    }

    // Method to unenroll the student from a course
    public void unenrollFromCourse(Course course) {
        coursesEnrolled.remove(course);
    }
}

