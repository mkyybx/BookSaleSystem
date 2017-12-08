package homework7;

public abstract class _14211278_Âú¿ÂÓî_7_AbstractPricingStrategy implements _14211278_Âú¿ÂÓî_7_IPricingStrategy{
	protected static int no = 1;
	protected String name;
	protected int id;
	
	public int getId() {
		return id;
	}
	
	public String getDiscountName() {
		return name;
	}
	
	public String getStringDiscountType() {
		try {
			return _14211278_Âú¿ÂÓî_7_IPricingStrategy.SIMPLE_DISCOUNT_NAME.get(getDiscountType());
		} catch(Exception ex) {
			return _14211278_Âú¿ÂÓî_7_IPricingStrategy.COMPOSITE_DISCOUNT_NAME.get(getDiscountType() - _14211278_Âú¿ÂÓî_7_IPricingStrategy.SIMPLE_DISCOUNT_NAME.size());
		}
	}
	
	public String toString() {
		return id + ":" + name + " " + getDiscountDescription();
	}
}
