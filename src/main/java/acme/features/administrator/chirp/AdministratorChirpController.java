package acme.features.administrator.chirp;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.chirps.Chirp;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Administrator;

@Controller
public class AdministratorChirpController extends AbstractController<Administrator, Chirp> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AdministratorChirpListRecentService	listRecentService;

	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		super.addCommand("list-recent", "list", this.listRecentService);
	}

}
