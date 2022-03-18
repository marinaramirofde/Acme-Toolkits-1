package acme.forms;

import java.io.Serializable;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatronDashboard implements Serializable {

	protected static final long	serialVersionUID	= 1L;
	
	int totalNumberOfProposedPatronagres;
	int totalNumberOfAcceptedPatronagres;
	int totalNumberOfDeniedPatronagres;

	Map<String,Double> averageBudgetOfProposedPatronagesByCurrency;
	Map<String,Double> deviationBudgetOfProposedPatronagesByCurrency;
	Map<String,Double> minimumBudgetOfProposedPatronagesByCurrency;
	Map<String,Double> maximumBudgetOfProposedPatronagesByCurrency;

	Map<String,Double> averageBudgetOfAcceptedPatronagesByCurrency;
	Map<String,Double> deviationBudgetOfAcceptedPatronagesByCurrency;
	Map<String,Double> minimumBudgetOfAcceptedPatronagesByCurrency;
	Map<String,Double> maximumBudgetOfAcceptedPatronagesByCurrency;

	Map<String,Double> averageBudgetOfDeniedPatronagesByCurrency;
	Map<String,Double> deviationBudgetOfDeniedPatronagesByCurrency;
	Map<String,Double> minimumBudgetOfDeniedPatronagesByCurrency;
	Map<String,Double> maximumBudgetOfDeniedPatronagesByCurrency;

}
