public class Main {
    public static void main(String[] args) {
        EnrollmentSystem enrollmentSystem = new EnrollmentSystem();

        Student student1 = new Student(1, "John", "Doe");
        Student student2 = new Student(2, "Jane", "Smith");

        Course course1 = new Course(101, "Mathematics", 2);
        Course course2 = new Course(102, "History", 3);

        enrollmentSystem.enrollStudentInCourse(student1, course1);
        enrollmentSystem.enrollStudentInCourse(student1, course2);
        enrollmentSystem.enrollStudentInCourse(student2, course2);

        enrollmentSystem.displayStudentCourses(1);
        enrollmentSystem.displayCourseStudents(102);

        enrollmentSystem.removeStudentFromCourse(1, 102);
        enrollmentSystem.removeCourse(101);
    }
}