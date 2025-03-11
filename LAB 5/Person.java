package library.Person;

import library.Address.*;

public class Person {
	private String name;
	private String role;
	private Address address;
	
	public Person(String name, String role, Address address) {
		this.name = name;
		this.role = role;
		this.address = address;
	}
	
	public Person(Person other) {
		this.name = other.name;
		this.role = other.role;
		this.address = other.address;
	}
	
	public void showPersonDetails() {
		System.out.printf("%s.%n", this.name);
		this.address.showAddress();
	}
	
	@Override
	public boolean equals(Object obj) {}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRole() {
		return this.role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
}
	
	
