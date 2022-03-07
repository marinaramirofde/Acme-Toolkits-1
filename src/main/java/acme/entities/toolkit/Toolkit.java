package acme.entities.toolkit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.entities.tool.Tool;
import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Toolkit extends AbstractEntity{

	//Serialisasion identifier
	protected static final long serialVersionUID = 1L;
	
	//Atributes
	@Pattern(regexp = "^[A-Z]{3}-[0-9]{3}(-[A-Z])?$")
	@Column(unique = true)
	protected String pattern;
	
	@NotBlank
	@Length(min=1, max= 101)
	protected String tittle;
	
	@NotBlank
	@Length(min=1, max= 256)
	protected String description;
	
	@NotBlank
	@Length(min=1, max= 256)
	protected String assembleNotes;
	
	@URL
	protected String link;
	
	@OneToOne
	protected Tool tool;
}
