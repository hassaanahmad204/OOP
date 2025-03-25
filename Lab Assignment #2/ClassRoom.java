package school.ClassRoom;
import school.Person.*;
import school.Teacher.*;
import school.Student.*;

public class ClassRoom {
    private String className;
    private String classCode;
    private Teacher teacher;
    private Student[] students;
    private static final int MAX_STUDENTS = 5;
    private int studentCount;

    public ClassRoom(String className, String classCode, Teacher teacher) {
        this.className = className;
        this.classCode = classCode;
        this.teacher = teacher;
        this.students = new Student[MAX_STUDENTS];
        this.studentCount = 0;
    }

    public String getClassName() {
        return className;
    }

    public String getClassCode() {
        return classCode;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public boolean enrollStudent(Student student) {
        if (studentCount >= MAX_STUDENTS) {
            System.out.println("Class is full! Cannot enroll more students.");
            return false;
        }
        students[studentCount++] = student;
        return true;
    }

    public Student[] getStudents() {
        return students;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Class: ").append(className).append(" (").append(classCode).append(")\n");
        sb.append("Teacher: ").append(teacher.toString()).append("\n");
        sb.append("Students: ");
        for (int i = 0; i < studentCount; i++) {
            sb.append(students[i].toString()).append(" ");
        }
        return sb.toString();
    }
}