package homework7;

import java.util.ArrayList;

import javafx.collections.ObservableList;

public class _14211278_Âú¿ÂÓî_7_Controller {
	private _14211278_Âú¿ÂÓî_7_StrategyCatalog catalog;
	private static _14211278_Âú¿ÂÓî_7_Controller instance = new _14211278_Âú¿ÂÓî_7_Controller();
	private _14211278_Âú¿ÂÓî_7_Sale sale;
	
	public static _14211278_Âú¿ÂÓî_7_Controller getInstance() {
		return instance;
	}
	
	private _14211278_Âú¿ÂÓî_7_Controller() {
		catalog = new _14211278_Âú¿ÂÓî_7_StrategyCatalog();
		_14211278_Âú¿ÂÓî_7_PricingStrategyFactory.getInstance().setCatalog(catalog);
		sale = new _14211278_Âú¿ÂÓî_7_Sale();
	}
	
	public _14211278_Âú¿ÂÓî_7_BookSpecification getBookSpecification(String isbn) {
		return _14211278_Âú¿ÂÓî_7_BookCatalog.getInstance().getBookSpecification(isbn);
	}
	
	public _14211278_Âú¿ÂÓî_7_BookSpecification addBook(_14211278_Âú¿ÂÓî_7_BookSpecification book) {
		return _14211278_Âú¿ÂÓî_7_BookCatalog.getInstance().addBook(book);
	}
	
	public _14211278_Âú¿ÂÓî_7_AbstractPricingStrategy addCompositeStrategy(int strategyType, int bookType, String name, ArrayList<_14211278_Âú¿ÂÓî_7_IPricingStrategy>strategies) {
		_14211278_Âú¿ÂÓî_7_CompositeStrategy cs = null;
		switch (strategyType) {
		case _14211278_Âú¿ÂÓî_7_IPricingStrategy.BEST_FOR_CUSTOMER:
			cs =  new _14211278_Âú¿ÂÓî_7_CompositeBestForCustomer(name, strategies);
			break;
		default:
			break;
		}
		if (cs != null)
			return catalog.addStrategy(bookType, cs);
		else return null;
	}
	
	public _14211278_Âú¿ÂÓî_7_AbstractPricingStrategy addSimpleStrategy(int strategyType, int bookType, String name, String...args) {
		_14211278_Âú¿ÂÓî_7_AbstractPricingStrategy aps = null;
		switch (strategyType) {
		case _14211278_Âú¿ÂÓî_7_IPricingStrategy.FLAT_RATE:
			double discount = Double.parseDouble(args[0]);
			aps = new _14211278_Âú¿ÂÓî_7_FlatRateStrategy(discount, name);
			break;
		case _14211278_Âú¿ÂÓî_7_IPricingStrategy.NO_DISCOUNT:
			aps = new _14211278_Âú¿ÂÓî_7_NoDiscountStrategy(name);
			break;
		case _14211278_Âú¿ÂÓî_7_IPricingStrategy.PERCENTAGE:
			int percentage = Integer.parseInt(args[0]);
			aps = new _14211278_Âú¿ÂÓî_7_PercentageStrategy(percentage, name);
			break;
		default:
			break;
		}
		if (aps != null)
			return catalog.addStrategy(bookType, aps);
		else return null;
	}
	
	public void addStrategy(int bookType, _14211278_Âú¿ÂÓî_7_AbstractPricingStrategy strategy) {
		catalog.addStrategy(bookType, strategy);
	}
	
	public void deleteStrategy(int bookType) {
		catalog.deleteStrategy(bookType);
	}
	
	public void deleteStrategy(_14211278_Âú¿ÂÓî_7_AbstractPricingStrategy ips) {
		ArrayList<Integer> temp = (ArrayList<Integer>) catalog.getReversePricingStrategy(ips).clone();
		for(int i : temp) {
			deleteStrategy(i);
		}
	}
	
	public void updateStrategy(int bookType, _14211278_Âú¿ÂÓî_7_AbstractPricingStrategy strategy) {
		addStrategy(bookType, strategy);
	}
	
	public boolean buyBook() {
		if (sale.isEmpty())
			return false;
		else {
			System.out.println("Customer bought books, and we should do something here!");
			sale = new _14211278_Âú¿ÂÓî_7_Sale();
			return true;
		}
	}
	
	public _14211278_Âú¿ÂÓî_7_Sale getSale() {
		return sale;
	}
	
	public ObservableList<_14211278_Âú¿ÂÓî_7_AbstractPricingStrategy> getStrategyObserver() {
		return catalog.getObserver();
	}
	
	public ObservableList<_14211278_Âú¿ÂÓî_7_BookSpecification> getBookObserver() {
		return _14211278_Âú¿ÂÓî_7_BookCatalog.getInstance().getObserver();
	}
	
}