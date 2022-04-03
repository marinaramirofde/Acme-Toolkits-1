package acme.features.inventor.announcement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.announcements.Announcement;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorAnnouncementShowService implements AbstractShowService<Inventor, Announcement> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorAnnouncementRepository repository;

	// AbstractShowService<Administrator, Announcement> interface --------------


	@Override
	public boolean authorise(final Request<Announcement> request) {
		assert request != null;

		return true;
	}

	@Override
	public Announcement findOne(final Request<Announcement> request) {
		assert request != null;

		Announcement result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

	@Override
	public void unbind(final Request<Announcement> request, final Announcement entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		model.setAttribute("criticalFrag", entity.getCriticalFlag());

		request.unbind(entity, model, "creationMoment", "title", "body", "criticalFlag","link");
		model.setAttribute("confirmation", false);
		model.setAttribute("readonly", true);
	}

}
