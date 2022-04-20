package acme.features.inventor.toolkit;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.currencyExchanges.ExchangeRate;
import acme.entities.items.Item;
import acme.entities.toolkits.Quantity;
import acme.entities.toolkits.Toolkit;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorToolkitRepository extends AbstractRepository {

	@Query("select t from Toolkit t where t.id = :id")
	Toolkit findOneById(int id);

	@Query("select t from Toolkit t where t.inventor.id = :inventorId")
	Collection<Toolkit> findManyToolkitsByInventorId(int inventorId);
	
	//PRECIO DE LAS TOOLKITS
	
	@Query("select r from ExchangeRate r where r.currencyExchange.base = :currency and r.currency = :targetCurrency")
	ExchangeRate findExchangeRateBySourceCurrency(String currency, String targetCurrency);
	
	//QUERYS NECESARIAS PARA MOSTRAR LOS ITEMS DE SUS TOOLKITS
	
	@Query("select q from Quantity q where q.toolkit.id = :id")
	Collection<Quantity> findManyQuantitiesByToolkitId(int id);
	
	@Query("select q.item from Quantity q where q.id = :id")
	Collection<Item> findManyItemsByQuantityId(int id);
}
