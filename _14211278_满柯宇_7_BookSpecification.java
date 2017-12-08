package homework7;

import javafx.beans.property.*;

public class _14211278_Âú¿ÂÓî_7_BookSpecification {
	private SimpleStringProperty isbn;
	private SimpleDoubleProperty price;
	private SimpleStringProperty title;
	private SimpleIntegerProperty type;
	
	public double getPrice() {
		return price.get();
	}
	
	public int getType() {
		return type.get();
	}
	
	public String getStringType() {
		return _14211278_Âú¿ÂÓî_7_BookType.NAME.get(type.get());
	}
	
	public String getTitle() {
		return title.get();
	}
	
	public String getISBN() {
		return isbn.get();
	}
	
	public _14211278_Âú¿ÂÓî_7_BookSpecification(String isbn, double price, String title, int type) {
		this.isbn = new SimpleStringProperty(isbn);
		this.price = new SimpleDoubleProperty(price);
		this.title = new SimpleStringProperty(title);
		this.type = new SimpleIntegerProperty(type);
	}
}
