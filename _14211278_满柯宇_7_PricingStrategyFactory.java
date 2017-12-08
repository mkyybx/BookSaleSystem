package homework7;

import java.util.ArrayList;

public class _14211278_Âú¿ÂÓî_7_PricingStrategyFactory {
	private static _14211278_Âú¿ÂÓî_7_PricingStrategyFactory instance = new _14211278_Âú¿ÂÓî_7_PricingStrategyFactory();
	private _14211278_Âú¿ÂÓî_7_StrategyCatalog catalog;
	
	private _14211278_Âú¿ÂÓî_7_PricingStrategyFactory() {
		
	}
	
	public static _14211278_Âú¿ÂÓî_7_PricingStrategyFactory getInstance() {
		return instance;
	}
	
	public _14211278_Âú¿ÂÓî_7_AbstractPricingStrategy getPricingStrategy(int bookType) {
		if (catalog == null)
			return null;
		else return catalog.getStrategy(bookType);
	}
	
	public ArrayList<Integer> getReversePricingStrategy(_14211278_Âú¿ÂÓî_7_AbstractPricingStrategy strategy) {
		if (catalog == null)
			return null;
		else return catalog.getReversePricingStrategy(strategy);
	}
	
	public void setCatalog(_14211278_Âú¿ÂÓî_7_StrategyCatalog catalog) {
		this.catalog = catalog;
	}
}
