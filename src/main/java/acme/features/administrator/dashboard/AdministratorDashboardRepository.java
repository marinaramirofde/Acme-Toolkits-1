package acme.features.administrator.dashboard;

import java.util.Collection;

import javax.persistence.Tuple;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.patronages.Status;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	@Query("select count(p) from Patronage p where p.status = :status")
	Integer numberOfPatronagesByStatus(Status status);
  
    @Query("select avg(p.budget.amount) from Patronage p where p.status = :status")
	Collection<String> averageNumberOfBudgetsByStatus(Status status);
	
	@Query("select stddev(p.budget.amount) from Patronage p where p.status = :status")
	Collection<String> deviationOfBudgetsByStatus(Status status);
	
	@Query("select min(p.budget.amount) from Patronage p where p.status = :status")
	Collection<String> minBudgetByStatus(Status status);
	
	@Query("select max(p.budget.amount) from Patronage p where p.status = :status")
	Collection<String> maxBudgetByStatus(Status status);
	
	@Query("select count(i) from Item i where i.typeEntity = acme.entities.items.Type.TOOL")
	Integer totalNumberOfTools();
	
	@Query("select avg(i.retailPrice.amount) from Item i where i.typeEntity = acme.entities.items.Type.TOOL group by i.retailPrice.currency")
	Collection<String> averageRetailPriceOfToolsByCurrency();
	
	@Query("select stddev(i.retailPrice.amount) from Item i where i.typeEntity = acme.entities.items.Type.TOOL group by i.retailPrice.currency")
	Collection<String> deviationRetailPriceOfToolsByCurrency();
	
	@Query("select min(i.retailPrice.amount) from Item i where i.typeEntity = acme.entities.items.Type.TOOL group by i.retailPrice.currency")
	Collection<String> minimumRetailPriceOfToolsByCurrency();
	
	@Query("select max(i.retailPrice.amount) from Item i where i.typeEntity = acme.entities.items.Type.TOOL group by i.retailPrice.currency")
	Collection<String> maximumRetailPriceOfToolsByCurrency();
	
	@Query("select count(i) from Item i where i.typeEntity = acme.entities.items.Type.COMPONENT")
	Integer totalNumberOfComponents();
	
	@Query("select i.retailPrice.currency, avg(i.retailPrice.amount) from Item i where i.typeEntity = acme.entities.items.Type.COMPONENT group by i.retailPrice.currency")
	Collection<Tuple> averageRetailPriceOfComponentsByTechnologyAndCurrency();
	
	@Query("select i.retailPrice.currency, stddev(i.retailPrice.amount) from Item i where i.typeEntity = acme.entities.items.Type.COMPONENT group by i.retailPrice.currency")
	Collection<Tuple> deviationRetailPriceOfComponentsByTechnologyAndCurrency();
	
	@Query("select i.retailPrice.currency, min(i.retailPrice.amount) from Item i where i.typeEntity = acme.entities.items.Type.COMPONENT group by i.retailPrice.currency")
	Collection<Tuple> minimumRetailPriceOfComponentsByTechnologyAndCurrency();
	
	@Query("select i.retailPrice.currency, max(i.retailPrice.amount) from Item i where i.typeEntity = acme.entities.items.Type.COMPONENT group by i.retailPrice.currency")
	Collection<Tuple>  maximumRetailPriceOfComponentsByTechnologyAndCurrency();
}
