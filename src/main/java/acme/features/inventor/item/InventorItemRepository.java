package acme.features.inventor.item;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.items.Item;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorItemRepository extends AbstractRepository {

	@Query("select i from Item i where i.id = :id")
	Item findOneById(int id);

	@Query("select i from Item i where i.typeEntity =  acme.entities.items.Type.COMPONENT")
	Collection<Item> findAllComponents();
	
	@Query("select i from Item i where i.typeEntity =  acme.entities.items.Type.TOOL")
	Collection<Item> findAllTools();

	@Query("select i from Item i where i.typeEntity =  acme.entities.items.Type.COMPONENT and i.inventor.id = :inventorId")
	Collection<Item> findManyComponentsByInventorId(int inventorId);
	
//	@Query("select i from Item i where i.typeEntity =  acme.entities.items.Type.TOOL and i.inventor.id = :inventorId")
//	Collection<Item> findManyToolsByInventorId(int inventorId);

}