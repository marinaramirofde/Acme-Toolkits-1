package acme.forms;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.util.Pair;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatronDashboard implements Serializable {

	protected static final long	serialVersionUID	= 1L;
	
	int totalNumberOfProposedPatronagres;
	int totalNumberOfAcceptedPatronagres;
	int totalNumberOfDeniedPatronagres;
	
	Map<Pair<String, String>, Double> averageBudgeByPatronagesStatusAndCurrency;
	Map<Pair<String, String>, Double> desviationBudgeByPatronagesStatusAndCurrency;
	Map<Pair<String, String>, Double> maximunBudgeByPatronagesStatusAndCurrency;
	Map<Pair<String, String>, Double> minimunBudgeByPatronagesStatusAndCurrency;
}
