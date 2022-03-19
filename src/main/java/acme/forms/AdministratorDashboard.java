package acme.forms;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.util.Pair;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdministratorDashboard implements Serializable {

	protected static final long	serialVersionUID= 1L;

	// Attributes -------------------------------------------------------------

	int totalNumberOfComponents;
	Map<Pair<String,String>,Double> averageRetailPriceOfComponentsByTechnologyAndCurrency;
	Map<Pair<String,String>,Double> deviationRetailPriceOfComponentsByTechnologyAndCurrency;
	Map<Pair<String,String>,Double> minimumRetailPriceOfComponentsByTechnologyAndCurrency;
	Map<Pair<String,String>,Double>  maximumRetailPriceOfComponentsByTechnologyAndCurrency;
	
	int totalNumberOfTools;
	Map<String,Double> averageRetailPriceOfToolsByCurrency;
	Map<String,Double> deviationRetailPriceOfToolsByCurrency;
	Map<String,Double> minimumRetailPriceOfToolsByCurrency;
	Map<String,Double> maximumRetailPriceOfToolsByCurrency;

	int totalNumberOfProposedPatronagres;
	int totalNumberOfAcceptedPatronagres;
	int totalNumberOfDeniedPatronagres;

	double averageBudgetOfProposedPatronages;
	double deviationBudgetOfProposedPatronages;
	double minimumBudgetOfProposedPatronages;
	double maximumBudgetOfProposedPatronages;

	double averageBudgetOfAcceptedPatronages;
	double deviationBudgetOfAcceptedPatronages;
	double minimumBudgetOfAcceptedPatronages;
	double maximumBudgetOfAcceptedPatronages;

	double averageBudgetOfDeniedPatronages;
	double deviationBudgetOfDeniedPatronages;
	double minimumBudgetOfDeniedPatronages;
	double maximumBudgetOfDeniedPatronages;

}
