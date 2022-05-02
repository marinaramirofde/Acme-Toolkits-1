package acme.features.inventor.toolkit;

import org.springframework.stereotype.Service;

import acme.entities.toolkits.Toolkit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractUpdateService;
import acme.roles.Inventor;

@Service
public class InventorToolkitUpdateService implements AbstractUpdateService<Inventor, Toolkit>{

	@Override
	public boolean authorise(final Request<Toolkit> request) {
		// TODO Auto-generated method stub
		return false;
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
	public Toolkit findOne(final Request<Toolkit> request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void validate(final Request<Toolkit> request, final Toolkit entity, final Errors errors) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(final Request<Toolkit> request, final Toolkit entity) {
		// TODO Auto-generated method stub
		
	}

}
