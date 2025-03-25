package school.Student;
import school.Person.*;

//Student class (child class)

public class Student extends Person {
    private int rollNumber;

    public Student(String name, int age, int rollNumber) {
        super(name, age);
        this.rollNumber = rollNumber;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    @Override
    public String toString() {
        return super.toString() + ", Roll Number: " + rollNumber;
    }

    @Override
    public boolean equals(Object obj) {
        Student student = (Student) obj;
        return this.rollNumber == student.rollNumber;
    }
}