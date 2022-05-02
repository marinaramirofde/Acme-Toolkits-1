package acme.features.inventor.toolkit;

import org.springframework.stereotype.Service;

import acme.entities.toolkits.Toolkit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;

@Service
public class InventorToolkitCreateService implements AbstractCreateService<Inventor, Toolkit>{

	@Override
	public boolean authorise(final Request<Toolkit> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Toolkit> request, final Toolkit entity, final Errors errors) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unbind(final Request<Toolkit> request, final Toolkit entity, final Model model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Toolkit instantiate(final Request<Toolkit> request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void validate(final Request<Toolkit> request, final Toolkit entity, final Errors errors) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(final Request<Toolkit> request, final Toolkit entity) {
		// TODO Auto-generated method stub
		
	}

}
