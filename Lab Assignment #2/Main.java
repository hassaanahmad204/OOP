package school.Main;
import school.Person.*;
import school.Principal.*;
import school.Teacher.*;
import school.Student.*;
import school.ClassRoom.*;
import school.School.*;

//Main class to show the funtionality
public class Main {
    public static void main(String[] args) {
        Principal principal = new Principal("Dr. Smith", 50, 20);
        School school = new School("Greenwood High", "123 Main St", principal);

        Teacher teacher1 = new Teacher("Alice Brown", 35, "Math", 101);
        Teacher teacher2 = new Teacher("Bob White", 40, "Science", 102);
        
        ClassRoom class1 = new ClassRoom("Grade 10", "G10", teacher1);
        ClassRoom class2 = new ClassRoom("Grade 11", "G11", teacher2);

        school.addClassRoom(class1);
        school.addClassRoom(class2);

        // Enroll students
        class1.enrollStudent(new Student("John Doe", 16, 1));
        class1.enrollStudent(new Student("Jane Smith", 16, 2));
        class1.enrollStudent(new Student("Alice Johnson", 16, 3));
        class1.enrollStudent(new Student("Bob Brown", 16, 4));
        class1.enrollStudent(new Student("Charlie Davis", 16, 5));
        class1.enrollStudent(new Student("Extra Student", 16, 6)); // Should fail

        // Compare students and teachers
        Student s1 = new Student("Test Student", 15, 100);
        Student s2 = new Student("Test Student", 15, 100);
        System.out.println("Are students equal? " + s1.equals(s2));

        Teacher t1 = new Teacher("Duplicate Teacher", 30, "History", 200);
        Teacher t2 = new Teacher("Duplicate Teacher", 30, "History", 200);
        System.out.println("Are teachers equal? " + t1.equals(t2));

        System.out.println(school);
    }
}