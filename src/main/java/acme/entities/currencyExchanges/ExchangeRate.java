package acme.entities.currencyExchanges;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ExchangeRate extends AbstractEntity{

	protected static final long serialVersionUID = 1L;

	// Attributes -------------------------------------------------------------

	@NotBlank
	@Pattern(regexp = "^[A-Z]{3}$")
	protected String currency;
	
	protected double rate;
	
	// Relationship -------------------------------------------------------------
	
	@ManyToOne(optional = false)
	@NotNull
	@Valid
	protected CurrencyExchange currencyExchange;

}
