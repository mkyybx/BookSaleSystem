package homework7;

public class _14211278_������_7_NoDiscountStrategy extends _14211278_������_7_AbstractPricingStrategy {

	@Override
	public double getSubTotal(_14211278_������_7_SaleLineItem sli) {
		// TODO Auto-generated method stub
		return sli.getPrice() * sli.getCopies();
	}
	
	public _14211278_������_7_NoDiscountStrategy(String name) {
		this.name = name;
		this.id = no++;
	}

	@Override
	public String getDiscountDescription() {
		// TODO Auto-generated method stub
		return "��";
	}

	@Override
	public int getDiscountType() {
		// TODO Auto-generated method stub
		return 0;
	}
}
