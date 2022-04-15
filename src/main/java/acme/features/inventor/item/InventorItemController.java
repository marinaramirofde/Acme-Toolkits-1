package acme.features.inventor.item;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.items.Item;
import acme.features.inventor.toolkit.ToolkitItemListService;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorItemController extends AbstractController<Inventor, Item> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorItemShowService			showService;
	
	@Autowired
	protected InventorItemListMineService	itemListMineService;
	
	//SERVICIO PARA ACCEDER A LA LISTA DE SUS ITEMS DESDE SU TOOLKIT
	
	@Autowired
	protected ToolkitItemListService		toolkitItemListService;
	
	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		super.addCommand("show", this.showService);
		super.addCommand("list-mine-items", "list", this.itemListMineService);
		
		//ENDPOINT PARA ACCEDER A LA LISTA DE SUS ITEMS DESDE SU TOOLKIT
		
		super.addCommand("list-toolkit-items", "list", this.toolkitItemListService);
	}

}
