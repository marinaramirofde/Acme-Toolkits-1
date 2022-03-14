package acme.entities.components;

import javax.persistence.Entity;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Data extends AbstractEntity{

	protected static final long    serialVersionUID    = 1L;
	
	public String currency;
	public String strongSpamTerms;
	public Double strongSpamThreshold;
	public String weakSpamTerm;
	public Double weakSpamThreshold;
}
