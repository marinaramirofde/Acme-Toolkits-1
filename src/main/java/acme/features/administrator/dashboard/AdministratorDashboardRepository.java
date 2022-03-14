package acme.features.administrator.dashboard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {
	
	@Query("select count(tc) from ToolComponent tc where tc.typeEntity = acme.entities.tool_component.Type.COMPONENT")
	Integer totalNumberOfComponents();
	
	@Query("select avg(select count(tc.retailPrice) from ToolComponent tc where tc.typeEntity = acme.entities.tool_component.Type.COMPONENT"
		+ "group by (tc.technology and tc.retailPrice.currency))")
	Double averageRetailPriceOfComponents(); //average retail price of Components grouped by technology and currency
	
	@Query("select stddev(select count(tc.retailPrice)) from ToolComponent tc where tc.typeEntity = acme.entities.tool_component.Type.COMPONENT"
		+ "group by (tc.technology and tc.retailPrice.currency)")
	Double deviationRetailPriceOfComponents(); //deviation retail price of Components grouped by technology and currency
	
	@Query("select min(tc.retailPrice) from ToolComponent tc where tc.typeEntity = acme.entities.tool_component.Type.COMPONENT"
		+ "group by (tc.technology and tc.retailPrice.currency)")
	Double minimumRetailPriceOfComponents(); //minimum retail price of Components grouped by technology and currency
	
	@Query("select max(tc.retailPrice) from ToolComponent tc where tc.typeEntity = acme.entities.tool_component.Type.COMPONENT"
		+ "group by (tc.technology and tc.retailPrice.currency)")
	Double maximumRetailPriceOfComponents(); //maximum retail price of Components grouped by technology and currency
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Query("select count(tc) from ToolComponent tc where tc.typeEntity = acme.entities.tool_component.Type.TOOL")
	Integer totalNumberOfTools();
	
	@Query("select avg(select count(tc.retailPrice) from ToolComponent tc where tc.typeEntity = acme.entities.tool_component.Type.TOOL"
		+ "group by (tc.retailPrice.currency))")
	Double averageRetailPriceOfTools(); //average retail price of Tools grouped by currency

	@Query("select stddev(select count(tc.retailPrice)) from ToolComponent tc where tc.typeEntity = acme.entities.tool_component.Type.TOOL"
		+ "group by (tc.retailPrice.currency)")
	Double deviationRetailPriceOfTools(); //deviation retail price of Tools grouped by currency
	
	@Query("select min(tc.retailPrice) from ToolComponent tc where tc.typeEntity = acme.entities.tool_component.Type.TOOL"
		+ "group by (tc.retailPrice.currency)")
	Double minimumRetailPriceOfTools(); //minimum retail price of Tools grouped by currency
	
	@Query("select max(tc.retailPrice) from ToolComponent tc where tc.typeEntity = acme.entities.tool_component.Type.TOOL"
		+ "group by (tc.retailPrice.currency)")
	Double maximumRetailPriceOfTools(); //maximum retail price of Tools grouped by currency
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Query("select count(p) from Patronage p where p.status = acme.entities.patronage.Status.PROPOSED")
	Integer totalNumberOfProposedPatronagres();
	
	@Query("select count(p) from Patronage p where p.status = acme.entities.patronage.Status.ACCEPTED")
	Integer totalNumberOfAcceptedPatronagres(); // total number of accepted patronages
	
	@Query("select count(p) from Patronage p where p.status = acme.entities.patronage.Status.DENIED")
	Integer totalNumberOfDeniedPatronagres(); // total number of denied patronages
	
	//average, deviation, minimum, and maximum budget of proposed patronages/////////////////////
	
	@Query("select avg(select count(p.budget) from Patronage p where p.status = acme.entities.patronage.Status.PROPOSED)")
	Double averageBudgetOfProposedPatronages();
	
	@Query("select stddev(select count(p.budget) from Patronage p where p.status = acme.entities.patronage.Status.PROPOSED)")
	Double deviationBudgetOfProposedPatronages();
	
	@Query("select min(p.budget) from Patronage p where p.status = acme.entities.patronage.Status.PROPOSED")
	Double minimumBudgetOfProposedPatronages();
	
	@Query("select max(p.budget) from Patronage p where p.status = acme.entities.patronage.Status.PROPOSED)")
	Double maximumBudgetOfProposedPatronages();
	
	//average, deviation, minimum, and maximum budget of accepted patronages////////////////////
	
	@Query()
	Double averageBudgetOfAcceptedPatronages();
	
	@Query()
	Double deviationBudgetOfAcceptedPatronages();
	
	@Query()
	Double minimumBudgetOfAcceptedPatronages();
	
	@Query()
	Double maximumBudgetOfAcceptedPatronages();
	
	//average, deviation, minimum, and maximum budget of denied patronages
	
	@Query()
	Double averageBudgetOfDeniedPatronages();
	
	@Query()
	Double deviationBudgetOfDeniedPatronages();
	
	@Query()
	Double minimumBudgetOfDeniedPatronages();
	
	@Query()
	Double maximumBudgetOfDeniedPatronages();

}
