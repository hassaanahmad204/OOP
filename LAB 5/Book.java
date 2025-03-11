package library.Book;

import library.Person.*;
import library.Date.*;

public class Book{
	private String title;
	private String issn;
	private Date publicationDate;
	private Person author;

	public Book (String title, String issn, Date publicationDate, Person author) {
		this.title = title;
		this.issn = issn;
		this.publicationDate = publicationDate;
		this.author = author;
	}
	
	public void showBookDetails() {
		System.out.printf("Book: %s%nISSN:%s%n", this.title, this.issn);
		this.author.showPersonDetails();
		this.publicationDate.showDate();
	}
	
	// public boolean equals(Object obj) {}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setIssn(String issn) {
		this.issn = issn;
	}

	public String getTitle() {
		return this.title;
	}

	public String getIssn() {
		return this.issn;
	}
}
