import java.util.*;

class EnrollmentSystem {
	
    // Lists to store students and courses managed by the system
    private List<Student> students;
    private List<Course> courses;

    // Constructor initializes empty lists for students and courses when the system is created
    public EnrollmentSystem() {
        this.students = new ArrayList<>(); // Initialize an ArrayList to store Student objects
        this.courses = new ArrayList<>(); // Initialize an ArrayList to store Course objects
    }

    // Method to enroll a student in a course
    public void enrollStudentInCourse(Student student, Course course) {
    	
        // Check if the course has available capacity for enrollment
        if (course.getEnrolledStudents().size() < course.getCapacity()) {
        	
            // Enroll the student in the course and update the student's enrolled courses
            course.enrollStudent(student);
            student.enrollInCourse(course);
            System.out.println(student.getFirstName() + " enrolled in " + course.getCourseName());
        } else {
            System.out.println("Course is full. Cannot enroll " + student.getFirstName());
        }
    }

    // Method to display the courses enrolled by a student
    public void displayStudentCourses(int studentId) {
        Student student = getStudentById(studentId);
        if (student != null) {
            System.out.println(student.getFirstName() + "'s Enrolled Courses:");
            
            // Retrieve the list of courses in which the given student is currently enrolled
            for (Course course : student.getCoursesEnrolled()) {
                System.out.println(course.getCourseName());
            }
        } else {
            System.out.println("Student with ID " + studentId + " not found.");
        }
    }

    // Method to display the students enrolled in a course
    public void displayCourseStudents(int courseId) {
        Course course = getCourseById(courseId);
        if (course != null) {
            System.out.println(course.getCourseName() + "'s Enrolled Students:");
            
            // Retrieve the list of students enrolled in the given course
            for (Student student : course.getEnrolledStudents()) {
                System.out.println(student.getFirstName() + " " + student.getLastName());
            }
        } else {
            System.out.println("Course with ID " + courseId + " not found.");
        }
    }

    // Method to remove a student from a course
    public void removeStudentFromCourse(int studentId, int courseId) {
        Student student = getStudentById(studentId);
        Course course = getCourseById(courseId);

        if (student != null && course != null) {
        	
            // Unenroll the student from the course and remove the student from the course's enrolled students
            student.unenrollFromCourse(course);
            course.removeEnrolledStudent(student);
            System.out.println(student.getFirstName() + " removed from " + course.getCourseName());
        } else {
            System.out.println("Student or Course not found.");
        }
    }

    // Method to remove a course and unenroll all students from that course
    public void removeCourse(int courseId) {
        Course course = getCourseById(courseId);

        if (course != null) {
        	
            // Unenroll all students from the course before removing it
            for (Student student : course.getEnrolledStudents()) {
                student.unenrollFromCourse(course);
            }
            courses.remove(course);
            System.out.println("Course " + course.getCourseName() + " removed.");
        } else {
            System.out.println("Course not found.");
        }
    }

    // Helper method to retrieve a student by ID
    private Student getStudentById(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        return null;
    }

    // Helper method to retrieve a course by ID
    private Course getCourseById(int courseId) {
        for (Course course : courses) {
            if (course.getCourseId() == courseId) {
                return course;
            }
        }
        return null;
    }
}

