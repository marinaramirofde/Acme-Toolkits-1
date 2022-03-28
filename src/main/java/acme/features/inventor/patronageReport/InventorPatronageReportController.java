package acme.features.inventor.patronageReport;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.patronageReports.PatronageReport;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorPatronageReportController extends AbstractController<Inventor, PatronageReport> {
	
	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorPatronageReportListAllService listAllService;
	
	@Autowired
	protected InventorPatronageReportShowService showService;
	
	// Constructors -----------------------------------------------------------

	
	@PostConstruct
	protected void intialise() {
		super.addCommand("show", this.showService);
		super.addCommand("list-all","list", this.listAllService);
	}
}
