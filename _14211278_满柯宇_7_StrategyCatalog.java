package homework7;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class _14211278_Âú¿ÂÓî_7_StrategyCatalog {
	private HashMap<Integer,_14211278_Âú¿ÂÓî_7_AbstractPricingStrategy> strategies;
	private HashMap<_14211278_Âú¿ÂÓî_7_AbstractPricingStrategy,ArrayList<Integer>> reverseStrategies;
	private ObservableList<_14211278_Âú¿ÂÓî_7_AbstractPricingStrategy> strategyList;
	
	public _14211278_Âú¿ÂÓî_7_StrategyCatalog() {
		strategies = new HashMap<Integer,_14211278_Âú¿ÂÓî_7_AbstractPricingStrategy>();
		reverseStrategies = new HashMap<_14211278_Âú¿ÂÓî_7_AbstractPricingStrategy,ArrayList<Integer>>();
		strategyList = FXCollections.observableArrayList();
	}
	
	public _14211278_Âú¿ÂÓî_7_AbstractPricingStrategy getStrategy(int bookType) {
		if (strategies.get(bookType) == null)
			addStrategy(bookType,new _14211278_Âú¿ÂÓî_7_NoDiscountStrategy("Ä¬ÈÏÓÅ»İ"));
		return strategies.get(bookType);
	}
	
	public ArrayList<Integer> getReversePricingStrategy(_14211278_Âú¿ÂÓî_7_AbstractPricingStrategy strategy) {
		return reverseStrategies.get(strategy);
	}
	
	public _14211278_Âú¿ÂÓî_7_AbstractPricingStrategy addStrategy(int bookType, _14211278_Âú¿ÂÓî_7_AbstractPricingStrategy strategy) {
		_14211278_Âú¿ÂÓî_7_AbstractPricingStrategy old = strategies.get(bookType);
		if (old != null)
			strategyList.remove(old);
		strategyList.add(strategy);
		if (reverseStrategies.get(strategy) == null)
			reverseStrategies.put(strategy, new ArrayList<Integer>());
		reverseStrategies.get(strategy).add(bookType);
		return strategies.put(bookType, strategy);
	}
	
	public void deleteStrategy(int bookType) {
		_14211278_Âú¿ÂÓî_7_AbstractPricingStrategy old = strategies.remove(bookType);
		strategyList.remove(old);
		if (old != null) {
			reverseStrategies.get(old).remove((Integer)bookType);
			if (reverseStrategies.get(old).isEmpty()) {
				reverseStrategies.put(old, null);
				reverseStrategies.remove(old);
			}
		}
	}
	
	public ObservableList<_14211278_Âú¿ÂÓî_7_AbstractPricingStrategy> getObserver() {
		return strategyList;
	}
}