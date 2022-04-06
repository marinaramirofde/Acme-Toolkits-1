package acme.forms;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.util.Pair;

import acme.entities.patronages.Status;
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
	
	Map<Status,Double> averageBudgetByPatronagesStatus;
	Map<Status,Double> deviationBudgetByPatronagesStatus;
	Map<Status,Double> minimumBudgetByPatronagesStatus;
	Map<Status,Double> maximumBudgetByPatronagesStatus;
}
