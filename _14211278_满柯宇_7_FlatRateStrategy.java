package homework7;

public class _14211278_������_7_FlatRateStrategy extends _14211278_������_7_AbstractPricingStrategy {
	private double discountPerBook;
	@Override
	public double getSubTotal(_14211278_������_7_SaleLineItem sli) {
		// TODO Auto-generated method stub
		return ((sli.getPrice() - discountPerBook >= 0) ? sli.getPrice() - discountPerBook : 0) * sli.getCopies();
	}
	
	public _14211278_������_7_FlatRateStrategy(double discountPerBook, String name) {
		this.discountPerBook = discountPerBook;
		this.name = name;
		this.id = no++;
	}

	@Override
	public String getDiscountDescription() {
		// TODO Auto-generated method stub
		return "ÿ���Ż�" + discountPerBook + "Ԫ";
	}

	@Override
	public int getDiscountType() {
		// TODO Auto-generated method stub
		return 2;
	}
}
