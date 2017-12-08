package homework7;

import java.util.ArrayList;

public abstract class _14211278_Âú¿ÂÓî_7_CompositeStrategy extends _14211278_Âú¿ÂÓî_7_AbstractPricingStrategy{
	protected ArrayList<_14211278_Âú¿ÂÓî_7_IPricingStrategy> strategies;
	
	public void add(_14211278_Âú¿ÂÓî_7_IPricingStrategy ips) {
		strategies.add(ips);
	}
}
