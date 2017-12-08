package homework7;

import java.util.ArrayList;
import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class _14211278_Âú¿ÂÓî_7_Sale implements _14211278_Âú¿ÂÓî_7_Subject{
	private ArrayList<_14211278_Âú¿ÂÓî_7_SaleLineItem> items;
	private static ArrayList<_14211278_Âú¿ÂÓî_7_Observer> observerList = new ArrayList<_14211278_Âú¿ÂÓî_7_Observer>();
	
	public ObservableList<_14211278_Âú¿ÂÓî_7_SaleLineItem> getObserver() {
		return FXCollections.observableArrayList(items);
	}
	
	public boolean isEmpty() {
		return items.isEmpty();
	}
	
	public double getTotal() {
		double temp = 0;
		for (_14211278_Âú¿ÂÓî_7_SaleLineItem sli:items)
			temp += sli.getSubTotal();
		return temp;
	}
	
	public _14211278_Âú¿ÂÓî_7_Sale(_14211278_Âú¿ÂÓî_7_SaleLineItem...items) {
		this.items = new ArrayList<_14211278_Âú¿ÂÓî_7_SaleLineItem>();
		Collections.addAll(this.items, items);
		notifyObserver();
	}
	
	public void addSaleLineItem(_14211278_Âú¿ÂÓî_7_SaleLineItem sli) {
		items.add(sli);
		notifyObserver();
	}

	@Override
	public void removeObserver(_14211278_Âú¿ÂÓî_7_Observer o) {
		// TODO Auto-generated method stub
		observerList.remove(o);
	}

	@Override
	public void registerObserver(_14211278_Âú¿ÂÓî_7_Observer o) {
		// TODO Auto-generated method stub
		observerList.add(o);
	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		for (_14211278_Âú¿ÂÓî_7_Observer o : observerList)
			o.update(this);
	}
}
