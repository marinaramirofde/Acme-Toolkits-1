package acme.features.any.item;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.items.Item;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Any;

@Controller
public class AnyItemController extends AbstractController<Any, Item> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnyComponentListAllService		componentListAllService;
	
	@Autowired
	protected AnyToolListAllService		toolListAllService;

	@Autowired
	protected AnyItemShowService			showService;

	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		super.addCommand("show", this.showService);
		super.addCommand("list-all-components", "list", this.componentListAllService);
		super.addCommand("list-all-tools", "list", this.toolListAllService);
	}

}
