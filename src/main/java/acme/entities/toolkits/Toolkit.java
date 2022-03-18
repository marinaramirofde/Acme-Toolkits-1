package acme.entities.toolkits;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Toolkit extends AbstractEntity{

	protected static final long serialVersionUID = 1L;
	
	@Pattern(regexp = "^[A-Z]{3}-[0-9]{3}(-[A-Z])?$")
	@Column(unique = true)
	protected String code;
	
	@NotBlank
	@Length(min=1, max= 100)
	protected String tittle;
	
	@NotBlank
	@Length(min=1, max= 255)
	protected String description;
	
	@NotBlank
	@Length(min=1, max= 255)
	protected String assembleNotes;
	
	@URL
	protected String link;

}
