package acme.entities.toolkits;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.AbstractEntity;
import acme.roles.Inventor;
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
	protected String title;
	
	@NotBlank
	@Length(min=1, max= 255)
	protected String description;
	
	@NotBlank
	@Length(min=1, max= 255)
	protected String assembleNotes;
	
	@URL
	protected String link;
	
	protected boolean finished;
	
	@ManyToOne(optional = false)
	@Valid
	@NotNull
	protected Inventor inventor;

}
