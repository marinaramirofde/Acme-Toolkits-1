package acme.features.inventor.quantity;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.items.Item;
import acme.entities.toolkits.Quantity;
import acme.entities.toolkits.Toolkit;
import acme.features.inventor.toolkit.InventorToolkitRepository;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.helpers.CollectionHelper;
import acme.framework.services.AbstractListService;
import acme.roles.Inventor;

@Service 
public class InventorToolkitItemListService implements AbstractListService<Inventor, Quantity>{

	@Autowired
	protected InventorToolkitRepository repository;

	@Override
	public boolean authorise(final Request<Quantity> request) {
		assert request != null;

		return true;
	}

	@Override
	public Collection<Quantity> findMany(final Request<Quantity> request) {
		final Collection<Item> result = new HashSet<>();
		
		int toolkitId;
		
		toolkitId = request.getModel().getInteger("masterId");
		final Collection<Quantity> quantities = this.repository.findManyQuantitiesByToolkitId(toolkitId);

		for(final Quantity quantity: quantities) {
			final int id=quantity.getId();
			final Collection<Item> items=this.repository.findManyItemsByQuantityId(id);
			result.addAll(items);
		}

		return quantities;
	}
	
	@Override
	public void unbind(final Request<Quantity> request, final Collection<Quantity> entities, final Model model) {
		assert request != null;
		assert !CollectionHelper.someNull(entities);
		assert model != null;

		int masterId;
		Toolkit toolkit;
		final boolean showCreate;

		masterId = request.getModel().getInteger("masterId");
		toolkit = this.repository.findOneById(masterId);
		showCreate = (!toolkit.isPublished() && request.isPrincipal(toolkit.getInventor()));

		model.setAttribute("masterId", masterId);
		model.setAttribute("showCreate", showCreate);
	}

	@Override
	public void unbind(final Request<Quantity> request, final Quantity entity, final Model model) {
		assert request != null; 
		assert entity != null; 
		assert model != null; 

		request.unbind(entity, model, "number", "item.typeEntity", "item.name","item.code", "item.technology", "item.retailPrice"); 

	}

}