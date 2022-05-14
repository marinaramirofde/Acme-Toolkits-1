package acme.features.inventor.quantity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.items.Item;
import acme.entities.toolkits.Quantity;
import acme.entities.toolkits.Toolkit;
import acme.features.inventor.toolkit.InventorToolkitRepository;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;

@Service
public class InventorQuantityCreateService implements AbstractCreateService<Inventor, Quantity>{
	
	@Autowired
	protected InventorToolkitRepository repository;

	@Override
	public boolean authorise(final Request<Quantity> request) {
		assert request != null;

		boolean result;
		int masterId;
		Toolkit toolkit;

		masterId = request.getModel().getInteger("masterId");
		toolkit = this.repository.findOneById(masterId);
		result = (toolkit != null && !toolkit.isPublished() && request.isPrincipal(toolkit.getInventor()));
		
		return result;
	}

	@Override
	public void bind(final Request<Quantity> request, final Quantity entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		request.bind(entity, errors, "number", "item.typeEntity", "item.name", "item.code", "item.technology", 
			"item.description", "item.retailPrice", "item.link");
				
	}

	@Override
	public void unbind(final Request<Quantity> request, final Quantity entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		model.setAttribute("masterId", request.getModel().getAttribute("masterId"));
		request.unbind(entity, model, "number", "item.typeEntity", "item.name", "item.code", "item.technology", 
			"item.description", "item.retailPrice", "item.link", "item.published");
		
		System.out.println(entity.getNumber());
		System.out.println(entity.getItem().getTypeEntity());
		System.out.println(entity.getItem().getCode());
		System.out.println(entity.getItem().getDescription());
	}

	@Override
	public Quantity instantiate(final Request<Quantity> request) {
		assert request != null;
		
		Quantity quantity;
		int toolkitId;
		Toolkit toolkit;
		Item item;
		
		quantity = new Quantity();
		item = new Item();
		
		toolkitId = request.getModel().getInteger("masterId");
		toolkit = this.repository.findOneById(toolkitId);
		
		quantity.setToolkit(toolkit);
		quantity.setItem(item);
				
		return quantity;
	}

	@Override
	public void validate(final Request<Quantity> request, final Quantity entity, final Errors errors) {
		assert request != null;
		assert errors != null;
		
		if (!errors.hasErrors("number")) {
			errors.state(request, entity.getNumber() > 0, "number", "inventor.item.form.error.negative-number");
		}
		
	}

	@Override
	public void create(final Request<Quantity> request, final Quantity entity) {
		assert request != null;
		assert entity != null;
		
		Item item;
		item = new Item();
		
		Inventor inventor;
		inventor = this.repository.findOneInventorById(request.getPrincipal().getActiveRoleId());
		
		item.setPublished(false);
		item.setInventor(inventor);
		entity.setItem(item);
		
		this.repository.save(item);
		
		this.repository.save(entity);
		
	}

}