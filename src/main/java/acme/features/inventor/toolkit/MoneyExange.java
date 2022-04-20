package acme.features.inventor.toolkit;

import acme.entities.currencyExchanges.ExchangeRate;
import acme.framework.datatypes.Money;

public class MoneyExange {
	
	public Money changeCurrency(final Money source, final String targetCurrency, final InventorToolkitRepository inventorToolkitRepository) {
		
		Money result = new Money();
		
		if(source.getCurrency().equals(targetCurrency)) {
			result = source;
		} else {
			final ExchangeRate exchangeRate = inventorToolkitRepository.findExchangeRateBySourceCurrency(source.getCurrency(), targetCurrency);
			
			result.setAmount(source.getAmount()*exchangeRate.getRate());
			result.setCurrency(targetCurrency);
		}
		
		return result;
	}

}
