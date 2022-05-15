package acme.features.patron.patronage;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronages.Patronage;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Patron;

@Service
public class PatronPatronageCreateService implements AbstractCreateService<Patron, Patronage>{
	
	@Autowired
	protected PatronPatronageRepository repository;

	@Override
	public boolean authorise(final Request<Patronage> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Patronage> request, final Patronage entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors,"status","code","legalStuff","budget","initial","end","link");
		
	}

	@Override
	public void unbind(final Request<Patronage> request, final Patronage entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model,"status","code","legalStuff","budget","initial","creation","end","link","published");
		
		model.setAttribute("inventorCompany", entity.getInventor().getCompany());
		model.setAttribute("inventorStatement", entity.getInventor().getStatement());
		model.setAttribute("inventorLink", entity.getInventor().getLink());
	}

	@Override
	public Patronage instantiate(final Request<Patronage> request) {
		assert request != null;
		
		Patronage result;
		Patron patron;
		
		patron = this.repository.findOnePatronById(request.getPrincipal().getActiveRoleId());
		result = new Patronage();
		result.setPatron(patron);
		
//		Inventor inventor;
//		final UserAccount userAccount = this.repository.findUserAccount();
//		inventor = userAccount.getRole(Inventor.class);
//		inventor.setUserAccount(userAccount);
//		
//		result.setInventor(inventor);
		
		Date creation;
		creation = new Date(System.currentTimeMillis()-1);
		
		result.setCreation(creation);
		return result;
	}

	@Override
	public void validate(final Request<Patronage> request, final Patronage entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		if (!errors.hasErrors("code")) {
			Patronage existing;

			existing = this.repository.findOnePatronageByCode(entity.getCode());
			errors.state(request, existing == null, "code", "patron.patronage.form.error.duplicated");
		}
		
		if (!errors.hasErrors("budget")) {
			errors.state(request, entity.getBudget().getAmount() > 0, "budget", "patron.patronage.form.error.negative-budget");
		}
		
		if (!errors.hasErrors("end")) {
            errors.state(request, entity.getEnd().after(entity.getCreation()) 
                && entity.getEnd().after(entity.getInitial()), 
                "end","patron.patronage.form.error.invalid-date-end");
		}

		if(!errors.hasErrors("initial")) {
			errors.state(request, entity.getInitial().before(entity.getCreation()),"initial", "patron.patronage.form.error.initial-date");
		}
	}

	@Override
	public void create(final Request<Patronage> request, final Patronage entity) {
		assert request != null;
		assert entity != null;
		
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setCreation(moment);

		this.repository.save(entity);
		
	}

}