package school.Teacher;
import school.Person.*;

//Teacher class (child class)
public class Teacher extends Person {
    private String subject;
    private int teacherID;

    public Teacher(String name, int age, String subject, int teacherID) {
        super(name, age);
        this.subject = subject;
        this.teacherID = teacherID;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getTeacherID() {
        return teacherID;
    }

    @Override
    public String toString() {
        return super.toString() + ", Subject: " + subject + ", Teacher ID: " + teacherID;
    }

    @Override
    public boolean equals(Object obj) {
        Teacher teacher = (Teacher) obj;
        return this.teacherID == teacher.teacherID;
    }
}
