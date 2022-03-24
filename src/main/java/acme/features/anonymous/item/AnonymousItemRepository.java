package acme.features.anonymous.item;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.items.Item;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousItemRepository extends AbstractRepository {

	@Query("select i from Item i where i.id = :id")
	Item findOneComponentById(int id); //SHOW BY ID (COMPONENT)

	@Query("select i from Item i")
	Collection<Item> findAllComponents();

}
