package homework7;

public class _14211278_Âú¿ÂÓî_7_NoDiscountStrategy extends _14211278_Âú¿ÂÓî_7_AbstractPricingStrategy {

	@Override
	public double getSubTotal(_14211278_Âú¿ÂÓî_7_SaleLineItem sli) {
		// TODO Auto-generated method stub
		return sli.getPrice() * sli.getCopies();
	}
	
	public _14211278_Âú¿ÂÓî_7_NoDiscountStrategy(String name) {
		this.name = name;
		this.id = no++;
	}

	@Override
	public String getDiscountDescription() {
		// TODO Auto-generated method stub
		return "ÎŞ";
	}

	@Override
	public int getDiscountType() {
		// TODO Auto-generated method stub
		return 0;
	}
}
