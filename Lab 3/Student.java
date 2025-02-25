public class Student {
	
	private static int rollCounter = 0;
	
	private int rollNumber;
	private String name;
	private String address;
	private String phoneNumber;
	private double cgpa;
	
	public Student(String studentName, String studentAddress, String studentPhone, double studentCgpa) {   //**this** can be used instead of makin different variables
		rollNumber = rollCounter++;
		name = studentName;
		address = studentAddress;
		phoneNumber = studentPhone;
		cgpa = studentCgpa;
	}
	
	public void displayInfo() {
		System.out.println();
		System.out.println(String.format("Roll Number: %03d", rollNumber));
		System.out.println("Name: " + name);
		System.out.println("Address: " + address);
		System.out.println("Phone Number: " + phoneNumber);
		System.out.println("CGPA: " + cgpa);
		System.out.println();
	}
	
	public static void main(String args[]) {
		Student student1 = new Student("Hassaan", "156 Main Street", "555-666-777", 3.59);
		Student student2 = new Student("Saad", "189 New Street", "111-222-333", 3.23);
		Student student3 = new Student("Ali", "45 Old Street", "222-444-666", 2.78);
		Student student4 = new Student("Ahmed", "88 Gold Street", "999-888-777", 3.36);
		Student student5 = new Student("Salman", "225 Silver Street", "333-666-999", 2.12);
		
		student1.displayInfo();
		student2.displayInfo();
		student3.displayInfo();
		student4.displayInfo();
		student5.displayInfo();
	}	
}
