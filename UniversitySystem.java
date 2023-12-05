import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private String schedule;
    private List<String> enrolledStudents;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }

    public List<String> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void enrollStudent(String studentID) {
        if (enrolledStudents.size() < capacity) {
            enrolledStudents.add(studentID);
            System.out.println("Student " + studentID + " enrolled in course " + courseCode);
        } else {
            System.out.println("Course is already at full capacity. Cannot enroll in course " + courseCode);
        }
    }

    public void removeStudent(String studentID) {
        if (enrolledStudents.remove(studentID)) {
            System.out.println("Student " + studentID + " removed from course " + courseCode);
        } else {
            System.out.println("Student " + studentID + " is not enrolled in course " + courseCode);
        }
    }

    @Override
    public String toString() {
        return "Course Code: " + courseCode + "\nTitle: " + title + "\nDescription: " + description +
                "\nCapacity: " + capacity + "\nSchedule: " + schedule + "\nEnrolled Students: " + enrolledStudents.size();
    }
}

class Student {
    private String studentID;
    private String name;
    private List<String> registeredCourses;

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public List<String> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerForCourse(Course course) {
        if (!registeredCourses.contains(course.getCourseCode())) {
            registeredCourses.add(course.getCourseCode());
            course.enrollStudent(studentID);
        } else {
            System.out.println("Student " + studentID + " is already registered for course " + course.getCourseCode());
        }
    }

    public void dropCourse(Course course) {
        if (registeredCourses.contains(course.getCourseCode())) {
            registeredCourses.remove(course.getCourseCode());
            course.removeStudent(studentID);
        } else {
            System.out.println("Student " + studentID + " is not registered for course " + course.getCourseCode());
        }
    }

    @Override
    public String toString() {
        return "Student ID: " + studentID + "\nName: " + name + "\nRegistered Courses: " + registeredCourses.size();
    }
}

public class UniversitySystem {
    public static void main(String[] args) {
       
        Course course1 = new Course("CSCI101", "Introduction to Computer Science", "Fundamentals of programming", 30, "Mon/Wed 10:00 AM - 11:30 AM");
        Course course2 = new Course("MATH201", "Calculus I", "Limits, derivatives, and integrals", 25, "Tue/Thu 1:00 PM - 2:30 PM");
        Course course3 = new Course("PHYS301", "Physics Mechanics", "Classical mechanics principles", 20, "Mon/Wed/Fri 2:00 PM - 3:30 PM");

        
        Student student1 = new Student("S001", "John Doe");
        Student student2 = new Student("S002", "Jane Smith");

        
        System.out.println("Available Courses:");
        System.out.println("1. " + course1.getTitle());
        System.out.println("2. " + course2.getTitle());
        System.out.println("3. " + course3.getTitle());

        
        student1.registerForCourse(course1);
        student1.registerForCourse(course2);
        student2.registerForCourse(course2);

        
        System.out.println("\nCourse Details:");
        System.out.println(course1);
        System.out.println("\n" + course2);
        System.out.println("\n" + course3);

        
        System.out.println("\nStudent Details:");
        System.out.println(student1);
        System.out.println("\n" + student2);

        
        student1.dropCourse(course2);

        
        System.out.println("\nUpdated Course Details:");
        System.out.println(course1);
        System.out.println("\n" + course2);
        System.out.println("\n" + course3);

        System.out.println("\nUpdated Student Details:");
        System.out.println(student1);
        System.out.println("\n" + student2);
    }
}
