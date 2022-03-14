package acme.features.administrator.dashboard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {
	
	@Query("select count(tc) from ToolComponent tc where tc.typeEntity ='COMPONENT'")
	Integer totalNumberOfComponents();
	
	@Query("select avg(tc.retailPrice.amount) from ToolComponent tc where tc.typeEntity = 'COMPONENT' group by tc.technology")
	Double averageRetailPriceOfComponents(); //average retail price of Components grouped by technology and currency
	
	@Query("select stddev(tc.retailPrice.amount) from ToolComponent tc where tc.typeEntity = 'COMPONENT' group by tc.technology")
	Double deviationRetailPriceOfComponents(); //deviation retail price of Components grouped by technology and currency
	
	@Query("select min(tc.retailPrice.amount) from ToolComponent tc where tc.typeEntity ='COMPONENT' group by tc.technology")
	Double minimumRetailPriceOfComponents(); //minimum retail price of Components grouped by technology and currency
	
	@Query("select max(tc.retailPrice.amount) from ToolComponent tc where tc.typeEntity = 'COMPONENT' group by tc.technology")
	Double maximumRetailPriceOfComponents(); //maximum retail price of Components grouped by technology and currency
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Query("select count(tc) from ToolComponent tc where tc.typeEntity = 'TOOL'")
	Integer totalNumberOfTools();
	
	@Query("select avg(tc.retailPrice.amount) from ToolComponent tc where tc.typeEntity = 'TOOL' group by tc.retailPrice.currency")
	Double averageRetailPriceOfTools(); //average retail price of Tools grouped by currency

	@Query("select stddev(tc.retailPrice.amount) from ToolComponent tc where tc.typeEntity = 'TOOL' group by tc.retailPrice.currency")
	Double deviationRetailPriceOfTools(); //deviation retail price of Tools grouped by currency
	
	@Query("select min(tc.retailPrice.amount) from ToolComponent tc where tc.typeEntity = 'TOOL' group by tc.retailPrice.currency")
	Double minimumRetailPriceOfTools(); //minimum retail price of Tools grouped by currency
	
	@Query("select max(tc.retailPrice.amount) from ToolComponent tc where tc.typeEntity = 'TOOL' group by tc.retailPrice.currency")
	Double maximumRetailPriceOfTools(); //maximum retail price of Tools grouped by currency
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Query("select count(p) from Patronage p where p.status = 'PROPOSED'")
	Integer totalNumberOfProposedPatronagres();
	
	@Query("select count(p) from Patronage p where p.status = 'ACCEPTED'")
	Integer totalNumberOfAcceptedPatronagres();
	
	@Query("select count(p) from Patronage p where p.status = 'DENIED'")
	Integer totalNumberOfDeniedPatronagres();
	
	//average, deviation, minimum, and maximum budget of proposed patronages/////////////////////
	
	@Query("select avg(p.budget) from Patronage p where p.status = 'PROPOSED'")
	Double averageBudgetOfProposedPatronages();
	
	@Query("select stddev(p.budget) from Patronage p where p.status = 'PROPOSED'")
	Double deviationBudgetOfProposedPatronages();
	
	@Query("select min(p.budget) from Patronage p where p.status = 'PROPOSED'")
	Double minimumBudgetOfProposedPatronages();
	
	@Query("select max(p.budget) from Patronage p where p.status = 'PROPOSED'")
	Double maximumBudgetOfProposedPatronages();
	
	//average, deviation, minimum, and maximum budget of accepted patronages////////////////////
	
	@Query("select avg(p.budget) from Patronage p WHERE p.status = 'ACCEPTED'")
	Double averageBudgetOfAcceptedPatronages();
	
	@Query("select stddev(p.budget) from Patronage p where p.status = 'ACCEPTED'")
	Double deviationBudgetOfAcceptedPatronages();
	
	@Query("select min(p.budget) from Patronage p where p.status = 'ACCEPTED'")
	Double minimumBudgetOfAcceptedPatronages();
	
	@Query("select max(p.budget) from Patronage p where p.status = 'ACCEPTED'")
	Double maximumBudgetOfAcceptedPatronages();
	
	//average, deviation, minimum, and maximum budget of denied patronages
	
	@Query("select avg(p.budget) from Patronage p where p.status = 'DENIED'")
	Double averageBudgetOfDeniedPatronages();
	
	@Query("select stddev(p.budget) from Patronage p where p.status = 'DENIED'")
	Double deviationBudgetOfDeniedPatronages();
	
	@Query("select min(p.budget) from Patronage p where p.status = 'DENIED'")
	Double minimumBudgetOfDeniedPatronages();
	
	@Query("select max(p.budget) from Patronage p where p.status = 'DENIED'")
	Double maximumBudgetOfDeniedPatronages();

}
