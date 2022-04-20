package acme.entities.currencyExchanges;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CurrencyExchange extends AbstractEntity{

	protected static final long serialVersionUID = 1L;

	@NotBlank
	@Pattern(regexp = "^[A-Z]{3}$")
	protected String base;
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	protected Date creation;

}
