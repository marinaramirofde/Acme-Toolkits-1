package acme.features.any.toolkit;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.toolkits.Toolkit;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnyToolkitRepository extends AbstractRepository{

	@Query("select i from Toolkit i where i.id = :id")
	Toolkit findOneById(int id);
		
	@Query("select i from Toolkit i where i.published = 1")
	Collection<Toolkit> findPublished();
	
	@Query("select sum(q.number*q.item.retailPrice.amount) from Quantity q where q.toolkit.id = ?1")
    double getToolkitPriceById(int toolkitId);
}
