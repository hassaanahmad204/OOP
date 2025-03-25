package school.School;
import school.Principal.*;
import school.ClassRoom.*;
import school.Person.*;

// School class
public class School {
    private String name;
    private String address;
    private Principal principal;
    private ClassRoom[] classrooms;
    private int classCount;
    private static final int MAX_CLASSES = 10;

    public School(String name, String address, Principal principal) {
        this.name = name;
        this.address = address;
        this.principal = principal;
        this.classrooms = new ClassRoom[MAX_CLASSES];
        this.classCount = 0;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Principal getPrincipal() {
        return principal;
    }

    public void addClassRoom(ClassRoom classRoom) {
        if (classCount < MAX_CLASSES) {
            classrooms[classCount++] = classRoom;
        } else {
            System.out.println("Cannot add more classes!");
        }
    }

    public ClassRoom[] getClassrooms() {
        return classrooms;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("School: ").append(name).append("\nAddress: ").append(address).append("\nPrincipal: ").append(principal.toString()).append("\nClasses: ");
        for (int i = 0; i < classCount; i++) {
            sb.append(classrooms[i].toString()).append("\n");
        }
        return sb.toString();
    }
}
