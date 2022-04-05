package acme.features.inventor.announcement;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.announcements.Announcement;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorAnnouncementController extends AbstractController<Inventor, Announcement> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorAnnouncementListRecentService	listRecentService;
	
	@Autowired
	protected InventorAnnouncementShowService showService;

	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		super.addCommand("list-recent", "list", this.listRecentService);
		super.addCommand("show", this.showService);
	}

}
