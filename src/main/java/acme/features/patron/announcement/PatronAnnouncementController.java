package acme.features.patron.announcement;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.announcements.Announcement;
import acme.framework.controllers.AbstractController;
import acme.roles.Patron;

@Controller
public class PatronAnnouncementController extends AbstractController<Patron, Announcement> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected PatronAnnouncementListRecentService	listRecentService;
	
	@Autowired
	protected PatronAnnouncementShowService showService;

	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		super.addCommand("list-recent", "list", this.listRecentService);
		super.addCommand("show", this.showService);
	}

}
