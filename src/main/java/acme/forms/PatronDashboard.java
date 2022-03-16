package acme.forms;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatronDashboard implements Serializable {

	protected static final long	serialVersionUID	= 1L;
	
	Integer totalNumberOfProposedPatronagres; // total number of proposed patronages
	Integer totalNumberOfAcceptedPatronagres; // total number of accepted patronages
	Integer totalNumberOfDeniedPatronagres; // total number of denied patronages
	
	//average, deviation, minimum, and maximum budget of proposed patronages.
	
	Double averageBudgetOfProposedPatronages;
	Double deviationBudgetOfProposedPatronages;
	Double minimumBudgetOfProposedPatronages;
	Double maximumBudgetOfProposedPatronages;
	
	//average, deviation, minimum, and maximum budget of accepted patronages
	
	Double averageBudgetOfAcceptedPatronages;
	Double deviationBudgetOfAcceptedPatronages;
	Double minimumBudgetOfAcceptedPatronages;
	Double maximumBudgetOfAcceptedPatronages;
	
	//average, deviation, minimum, and maximum budget of denied patronages
	
	Double averageBudgetOfDeniedPatronages;
	Double deviationBudgetOfDeniedPatronages;
	Double minimumBudgetOfDeniedPatronages;
	Double maximumBudgetOfDeniedPatronages;

}
