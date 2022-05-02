package acme.features.inventor.item;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.items.Item;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor;

@Repository
public interface InventorItemRepository extends AbstractRepository {

	@Query("select i from Item i where i.id = :id")
	Item findOneById(int id);

	@Query("select i from Item i where i.inventor.id = :inventorId")
	Collection<Item> findManyItemsByInventorId(int inventorId);
	
	//QUERYS NECESARIAS PARA EL CREATE

	@Query("select i from Inventor i where i.id = :inventorId")
	Inventor findOneInventorById(int inventorId);

	@Query("select i from Item i where i.code = :code")
	Item findOneItemByCode(String code);

}
