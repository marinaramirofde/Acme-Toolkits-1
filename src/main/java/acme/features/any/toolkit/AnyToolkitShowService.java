package acme.features.any.toolkit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.toolkits.Toolkit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Any;
import acme.framework.services.AbstractShowService;

@Service
public class AnyToolkitShowService implements AbstractShowService<Any, Toolkit> {

	@Autowired
	protected AnyToolkitRepository repository;

	// AbstractShowService<Any, Item> interface --------------


	@Override
	public boolean authorise(final Request<Toolkit> request) {
		assert request != null;
		
		boolean result;
		int toolkitId;
		Toolkit toolkit;
		
		toolkitId = request.getModel().getInteger("id");
		toolkit = this.repository.findOneById(toolkitId);
		result = toolkit.isPublished();

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

		request.unbind(entity, model, "code", "title", "description", "assemblyNotes", "link");
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
