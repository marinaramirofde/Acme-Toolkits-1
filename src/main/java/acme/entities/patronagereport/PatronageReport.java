package acme.entities.patronagereport;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.entities.patronage.Patronage;
import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PatronageReport extends AbstractEntity{
	// Serialisation identifier -----------------------------------------------

	protected static final long		serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------
	@NotBlank
	protected String 				automaticSequenceNumber;
	
	@Past
	protected Date 				creation;
	
	@NotBlank
	@Length (min=1, max=256)
	protected String				memorandum;
	
	@URL
	protected String				link;

	@OneToOne(optional=false)
	@Valid
	@NotNull
	protected Patronage 				patronage;
}