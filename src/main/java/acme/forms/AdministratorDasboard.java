package acme.forms;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdministratorDasboard implements Serializable {

	protected static final long	serialVersionUID= 1L;

	// Attributes -------------------------------------------------------------

	Integer totalNumberOfComponents; //total number of components
	
	Double averageRetailPriceOfComponents; //average retail price of components grouped by technology and currency
	Double deviationRetailPriceOfComponents; //deviation retail price of components grouped by technology and currency
	Double minimumRetailPriceOfComponents; //minimum retail price of components grouped by technology and currency
	Double maximumRetailPriceOfComponents; //maximum retail price of components grouped by technology and currency
	
	Integer totalNumberOfTools; //total number of tools
	
	Double averageRetailPriceOfTools; //average retail price of Tools grouped by currency
	Double deviationRetailPriceOfTools; //deviation retail price of Tools grouped by currency
	Double minimumRetailPriceOfTools; //minimum retail price of Tools grouped by currency
	Double maximumRetailPriceOfTools; //maximum retail price of Tools grouped by currency
	
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

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
