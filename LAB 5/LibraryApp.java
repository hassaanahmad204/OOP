package library.LibraryApp;

import library.Library.*;
import library.Book.*;
import com.library.Date.*;
import com.library.Address.*;
import com.library.Person.*;

public class LibraryApp {
	
	public static void main(String[] args) {
		Date date = new Date(8, 3, 2025);
		Address address = new Address("Allama Iqbal Road", "Lahore");
		Person person = new Person("Hassaan", address);
		Book book = new Book("Harry Potter", "1234556755", date, person);
		Library cui = new Library("COMSATS Lahore", book, incharge, stafF);
		cui.showLibraryDetails();
	}

}
