package acme.components;

import java.util.Date;

import acme.framework.datatypes.Money;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MoneyExchange {

	// Query attributes -------------------------------------------------------

	public Money	source;

	public String	targetCurrency;

	// Response attributes ----------------------------------------------------

	public Money	target;

	public Date		date;

}
