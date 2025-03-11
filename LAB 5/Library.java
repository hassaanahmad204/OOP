package library.Library;

import library.Book.*;
import library.Person.*;

public class Library {
	private String name;
	private Book book;
	private Person incharge;
	private Person staff;

	public Library (String name, Book book, Person incharge, Person staff) {
		this.name = name;
		this.book = book;
		this.incharge = incharge;
		this.staff = staff;
	}
	
	public Library (Library other) {
		// this.name = other.name;
		// this.book = other.book;
		// this.incharge = other.incharge;
		// this.staff = other.staff;
	}
	
	public boolean equals(Object obj) {} // Equals method.

	public void showLibraryDetails() {
		System.out.printf("Library: %s%n", this.name);
		this.book.showBookDetails();
		this.incharge.showPersonDetails();
		this.staff.showPersonDetails();
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

}
