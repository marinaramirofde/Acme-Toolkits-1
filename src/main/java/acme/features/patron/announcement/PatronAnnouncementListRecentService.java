package acme.features.patron.announcement;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.announcements.Announcement;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractListService;
import acme.roles.Patron;

@Service
public class PatronAnnouncementListRecentService implements AbstractListService<Patron, Announcement> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected PatronAnnouncementRepository repository;

	// AbstractListService<Any, Announcement> interface --------------


	@Override
	public boolean authorise(final Request<Announcement> request) {
		assert request != null;

		return true;
	}

	@Override
	public Collection<Announcement> findMany(final Request<Announcement> request) {
		assert request != null;

		Collection<Announcement> result;
		Calendar calendar;
		Date deadline;

		calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		deadline = calendar.getTime();

		result = this.repository.findRecentAnnouncements(deadline);

		return result;
	}

	@Override
	public void unbind(final Request<Announcement> request, final Announcement entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "creationMoment", "title");
	}
	
}
