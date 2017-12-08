package homework7;

import java.util.ArrayList;

public class _14211278_������_7_CompositeBestForCustomer extends _14211278_������_7_CompositeStrategy {

	@Override
	public double getSubTotal(_14211278_������_7_SaleLineItem sli) {
		// TODO Auto-generated method stub
		double min = Double.MAX_VALUE;
		for (_14211278_������_7_IPricingStrategy ips : strategies) {
			double temp = ips.getSubTotal(sli);
			min = (temp < min ? temp : min);
		}
		return min;
	}
	
	public _14211278_������_7_CompositeBestForCustomer(String name, ArrayList<_14211278_������_7_IPricingStrategy> strategies) {
		this.strategies = strategies;
		this.name = name;
		this.id = no++;
	}

	@Override
	public String getDiscountDescription() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		for (_14211278_������_7_IPricingStrategy ips : strategies)
			sb.append(ips.getDiscountDescription() + "�У�");
		return "��" + sb.toString() + "ȡ��С";
	}

	@Override
	public int getDiscountType() {
		// TODO Auto-generated method stub
		return 3;
	}
}
