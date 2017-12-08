package homework7;

public class _14211278_Âú¿ÂÓî_7_SaleLineItem {
	private int copies;
	private _14211278_Âú¿ÂÓî_7_BookSpecification prodSpec;
	private _14211278_Âú¿ÂÓî_7_IPricingStrategy strategy;
	
	public double getPrice() {
		return prodSpec.getPrice() ;
	}
	
	public String getTitile() {
		return prodSpec.getTitle();
	}
	
	public int getCopies() {
		return copies;
	}
	
	public double getSubTotal() {
		return strategy.getSubTotal(this);
	}
	
	public _14211278_Âú¿ÂÓî_7_SaleLineItem(int copies, _14211278_Âú¿ÂÓî_7_BookSpecification prodSpec) {
		this.copies = copies;
		this.prodSpec = prodSpec;
		this.strategy = _14211278_Âú¿ÂÓî_7_PricingStrategyFactory.getInstance().getPricingStrategy(prodSpec.getType());
	}
}
