package homework7;

import java.util.HashMap;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class _14211278_Âú¿ÂÓî_7_BookCatalog {
	private HashMap<String,_14211278_Âú¿ÂÓî_7_BookSpecification> books;
	private ObservableList<_14211278_Âú¿ÂÓî_7_BookSpecification> bookList;
	private static _14211278_Âú¿ÂÓî_7_BookCatalog instance = new _14211278_Âú¿ÂÓî_7_BookCatalog();
	
	public _14211278_Âú¿ÂÓî_7_BookSpecification getBookSpecification(String isbn) {
		return books.get(isbn);
	}
	
	public _14211278_Âú¿ÂÓî_7_BookSpecification addBook(_14211278_Âú¿ÂÓî_7_BookSpecification book) {
		_14211278_Âú¿ÂÓî_7_BookSpecification old = books.get(book.getISBN());
		if (old != null)
			bookList.remove(old);
		bookList.add(book);
		return books.put(book.getISBN(), book);
	}
	
	private _14211278_Âú¿ÂÓî_7_BookCatalog() {
		books = new HashMap<String,_14211278_Âú¿ÂÓî_7_BookSpecification>();
		bookList = FXCollections.observableArrayList();
	}
	
	public static _14211278_Âú¿ÂÓî_7_BookCatalog getInstance() {
		return instance;
	}
	
	public ObservableList<_14211278_Âú¿ÂÓî_7_BookSpecification> getObserver() {
		return bookList;
	}
}

