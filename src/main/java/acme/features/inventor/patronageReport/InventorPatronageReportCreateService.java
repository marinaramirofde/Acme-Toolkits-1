package acme.features.inventor.patronageReport;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronageReports.PatronageReport;
import acme.entities.patronages.Patronage;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;

@Service
public class InventorPatronageReportCreateService implements AbstractCreateService<Inventor, PatronageReport>{
	@Autowired
	protected InventorPatronageReportRepository repository;

	@Override
	public boolean authorise(final Request<PatronageReport> request) {
		assert request != null;

		return true;
	}
	
	@Override
	public void bind(final Request<PatronageReport> request, final PatronageReport entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "automaticSequenceNumber", "creation", "memorandum", "link");

	}

	@Override
	public void unbind(final Request<PatronageReport> request, final PatronageReport entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "automaticSequenceNumber", "creation", "memorandum", "link");
		
		model.setAttribute("confirmation", true);
		model.setAttribute("patronageId", entity.getPatronage().getCode());

	}
	
	@Override
	public PatronageReport instantiate(final Request<PatronageReport> request) {
		assert request != null;

		PatronageReport result;
		
		result = new PatronageReport();
		
		Patronage patronage;
		
		patronage = new Patronage();

		patronage = this.repository.findOnePatronageById(request.getModel().getInteger("patronageId"));
		
		result.setPatronage(patronage);

		final int count = this.repository.countPatronageReportWithPatronageId(patronage.getId());
		final String formated = String.format("%04d", count);
		final String automaticSequenceNumber = patronage.getCode()+":"+formated;
		result.setAutomaticSequenceNumber(automaticSequenceNumber);
		
		Date creationMoment;
		creationMoment = new Date(System.currentTimeMillis()-1);
		result.setCreation(creationMoment);
		
		return result;
	}

	@Override
	public void validate(final Request<PatronageReport> request, final PatronageReport entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		if (!errors.hasErrors("automaticSequenceNumber")) {
			PatronageReport existing;

			existing = this.repository.findOnePatronageReportBySequenceNumber(entity.getAutomaticSequenceNumber());
			errors.state(request, existing == null, "automaticSequenceNumber", "inventor.patronageReport.form.error.duplicated");
		}
		if(!errors.hasErrors("memorandum")) {
			errors.state(request, entity.getMemorandum().length() < 256, "memorandum", "inventor.patronageReport.form.error.incorrect-memorandum");
		}
		
		boolean confirmation;
		confirmation = request.getModel().getBoolean("confirmation");
		errors.state(request, confirmation, "confirmation", "javax.validation.constraints.AssertTrue.message");

	}

	@Override
	public void create(final Request<PatronageReport> request, final PatronageReport entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}


}
