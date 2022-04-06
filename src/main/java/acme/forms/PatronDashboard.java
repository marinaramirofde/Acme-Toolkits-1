package acme.forms;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.util.Pair;

import acme.entities.patronages.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatronDashboard implements Serializable {

	protected static final long	serialVersionUID	= 1L;
	
	int totalNumberOfProposedPatronagres;
	int totalNumberOfAcceptedPatronagres;
	int totalNumberOfDeniedPatronagres;
	
	Map<Pair<Status, String>, Double> averageBudgeByPatronagesStatusAndCurrency;
	Map<Pair<Status, String>, Double> desviationBudgeByPatronagesStatusAndCurrency;
	Map<Pair<Status, String>, Double> maximunBudgeByPatronagesStatusAndCurrency;
	Map<Pair<Status, String>, Double> minimunBudgeByPatronagesStatusAndCurrency;
}
