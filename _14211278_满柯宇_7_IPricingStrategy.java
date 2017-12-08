package homework7;

import java.util.ArrayList;
import java.util.Collections;

public interface _14211278_满柯宇_7_IPricingStrategy {
	public static final int BEST_FOR_CUSTOMER = 3;
	public static final int PERCENTAGE = 1;
	public static final int FLAT_RATE = 2;
	public static final int NO_DISCOUNT = 0;
	
	static final String[] STRING_SIMPLE_DISCOUNT_NAME = {"无优惠","百分比优惠","绝对值优惠"};
	public static final ArrayList<String> SIMPLE_DISCOUNT_NAME = new ArrayList<String>();
	static final boolean temp = Collections.addAll(SIMPLE_DISCOUNT_NAME, STRING_SIMPLE_DISCOUNT_NAME);
	
	static final String[] STRING_COMPOSITE_DISCOUNT_NAME = {"顾客最优优惠"};
	public static final ArrayList<String> COMPOSITE_DISCOUNT_NAME = new ArrayList<String>();
	static final boolean temp1 = Collections.addAll(COMPOSITE_DISCOUNT_NAME, STRING_COMPOSITE_DISCOUNT_NAME);
	
	public abstract double getSubTotal(_14211278_满柯宇_7_SaleLineItem sli);
	public abstract String getDiscountDescription();
	public abstract int getDiscountType();
}
