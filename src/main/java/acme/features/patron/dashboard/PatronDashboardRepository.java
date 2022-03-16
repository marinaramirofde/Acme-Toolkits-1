package acme.features.patron.dashboard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface PatronDashboardRepository extends AbstractRepository{

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
