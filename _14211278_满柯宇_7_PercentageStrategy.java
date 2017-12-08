package homework7;

public class _14211278_Âú¿ÂÓî_7_PercentageStrategy extends _14211278_Âú¿ÂÓî_7_AbstractPricingStrategy {
	private int discoundPercentage;
	@Override
	public double getSubTotal(_14211278_Âú¿ÂÓî_7_SaleLineItem sli) {
		// TODO Auto-generated method stub
		return sli.getPrice() * (100 - discoundPercentage) / 100.0 * sli.getCopies();
	}
	
	public _14211278_Âú¿ÂÓî_7_PercentageStrategy(int discoundPercentage, String name) {
		this.discoundPercentage = discoundPercentage;
		this.name = name;
		this.id = no++;
	}

	@Override
	public String getDiscountDescription() {
		// TODO Auto-generated method stub
		return "´ò" + (100 - discoundPercentage) / 10.0 + "ÕÛ";
	}

	@Override
	public int getDiscountType() {
		// TODO Auto-generated method stub
		return 1;
	}
}
