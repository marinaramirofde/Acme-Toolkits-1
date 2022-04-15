package acme.features.inventor.toolkit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.toolkits.Toolkit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorToolkitShowService implements AbstractShowService<Inventor, Toolkit> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorToolkitRepository repository;

	// AbstractShowService<Administrator, Toolkit> interface --------------


	@Override
	public boolean authorise(final Request<Toolkit> request) {
		assert request != null;
		
		boolean result;
		int toolkitId;
		Toolkit toolkit;
		
		toolkitId = request.getModel().getInteger("id");
		toolkit = this.repository.findOneById(toolkitId);
		result = toolkit.getInventor().getId() == request.getPrincipal().getActiveRoleId();

		return result;
	}

	@Override
	public Toolkit findOne(final Request<Toolkit> request) {
		assert request != null;

		Toolkit result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

	@Override
	public void unbind(final Request<Toolkit> request, final Toolkit entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "code", "title", "description", "assembleNotes", "link");
		model.setAttribute("confirmation", false);
		model.setAttribute("readonly", true);
		
		int toolkitId;
        double toolkitPrice;

        toolkitId =  request.getModel().getInteger("id");
        toolkitPrice = this.repository.getToolkitPriceById(toolkitId);
		model.setAttribute("toolkitPrice", toolkitPrice);
		
		String result = "";

		result = entity.isPublished() ? "The toolkit is published": "The toolkit is not published";
        model.setAttribute("published", result);
	}
	
}
