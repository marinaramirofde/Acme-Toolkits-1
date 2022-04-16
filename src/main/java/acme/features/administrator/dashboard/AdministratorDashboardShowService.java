//package acme.features.administrator.dashboard;
//
//import java.util.EnumMap;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.util.Pair;
//import org.springframework.stereotype.Service;
//
//import acme.entities.patronages.Status;
//import acme.forms.AdministratorDashboard;
//import acme.framework.components.models.Model;
//import acme.framework.controllers.Request;
//import acme.framework.roles.Administrator;
//import acme.framework.services.AbstractShowService;
//
//@Service
//public class AdministratorDashboardShowService implements AbstractShowService<Administrator, AdministratorDashboard> {
//
//	@Autowired
//	protected AdministratorDashboardRepository repository;
//
//
//	@Override
//	public boolean authorise(final Request<AdministratorDashboard> request) {
//		assert request != null;
//		boolean result;
//
//		result = request.getPrincipal().hasRole(Administrator.class);
//
//		return result;
//	}
//
//	@Override
//	public AdministratorDashboard findOne(final Request<AdministratorDashboard> request) {
//		assert request != null;
//
//		final AdministratorDashboard result;
//		EnumMap<Status, Integer> numberOfPatronagesByStatus;
//		numberOfPatronagesByStatus = new EnumMap<>(Status.class);
//		Map<Pair<Status, String>, Double> averageNumberOfBudgetsByCurrencyAndStatus;
//		Map<Pair<Status, String>, Double> deviationOfBudgetsByCurrencyAndStatus;
//		Map<Pair<Status, String>, Double> minBudgetByCurrencyAndStatus;
//		Map<Pair<Status, String>, Double> maxBudgetByCurrencyAndStatus;
//
//		final Integer numberOfProposedPatronages = this.repository.numberOfPatronagesByStatus(Status.PROPOSED);
//		final Integer numberOfAcceptedPatronages = this.repository.numberOfPatronagesByStatus(Status.ACCEPTED);
//		final Integer numberOfDeniedPatronages = this.repository.numberOfPatronagesByStatus(Status.DENIED);
//		numberOfPatronagesByStatus.put(Status.PROPOSED, numberOfProposedPatronages);
//		numberOfPatronagesByStatus.put(Status.ACCEPTED, numberOfAcceptedPatronages);
//		numberOfPatronagesByStatus.put(Status.DENIED, numberOfDeniedPatronages);
//		
//		averageNumberOfBudgetsByCurrencyAndStatus = new HashMap<>();	
//		this.repository.averageNumberOfBudgetsByCurrencyAndStatus(Status.PROPOSED).stream()
//		.forEach(x->
//			averageNumberOfBudgetsByCurrencyAndStatus.put(
//				Pair.of(Status.PROPOSED, x.get(0).toString()),
//				Double.parseDouble(x.get(1).toString()))
//			);
//		this.repository.averageNumberOfBudgetsByCurrencyAndStatus(Status.ACCEPTED).stream()
//		.forEach(x->
//			averageNumberOfBudgetsByCurrencyAndStatus.put(
//				Pair.of(Status.ACCEPTED, x.get(0).toString()),
//				Double.parseDouble(x.get(1).toString()))
//			);
//		this.repository.averageNumberOfBudgetsByCurrencyAndStatus(Status.DENIED).stream()
//		.forEach(x->
//			averageNumberOfBudgetsByCurrencyAndStatus.put(
//				Pair.of(Status.DENIED, x.get(0).toString()),
//				Double.parseDouble(x.get(1).toString()))
//			);
//		
//		deviationOfBudgetsByCurrencyAndStatus = new HashMap<Pair<Status, String>, Double>();	
//		this.repository.deviationOfBudgetsByCurrencyAndStatus(Status.PROPOSED).stream()
//		.forEach(x->
//		deviationOfBudgetsByCurrencyAndStatus.put(
//				Pair.of(Status.PROPOSED, x.get(0).toString()),
//				Double.parseDouble(x.get(1).toString()))
//			);
//		this.repository.deviationOfBudgetsByCurrencyAndStatus(Status.ACCEPTED).stream()
//		.forEach(x->
//		deviationOfBudgetsByCurrencyAndStatus.put(
//				Pair.of(Status.ACCEPTED, x.get(0).toString()),
//				Double.parseDouble(x.get(1).toString()))
//			);
//		this.repository.deviationOfBudgetsByCurrencyAndStatus(Status.DENIED).stream()
//		.forEach(x->
//		deviationOfBudgetsByCurrencyAndStatus.put(
//				Pair.of(Status.DENIED, x.get(0).toString()),
//				Double.parseDouble(x.get(1).toString()))
//			);
//		
//		minBudgetByCurrencyAndStatus = new HashMap<Pair<Status, String>, Double>();	
//		this.repository.minBudgetByCurrencyAndStatus(Status.PROPOSED).stream()
//		.forEach(x->
//		minBudgetByCurrencyAndStatus.put(
//				Pair.of(Status.PROPOSED, x.get(0).toString()),
//				Double.parseDouble(x.get(1).toString()))
//			);
//		this.repository.minBudgetByCurrencyAndStatus(Status.ACCEPTED).stream()
//		.forEach(x->
//		minBudgetByCurrencyAndStatus.put(
//				Pair.of(Status.ACCEPTED, x.get(0).toString()),
//				Double.parseDouble(x.get(1).toString()))
//			);
//		this.repository.minBudgetByCurrencyAndStatus(Status.DENIED).stream()
//		.forEach(x->
//		minBudgetByCurrencyAndStatus.put(
//				Pair.of(Status.DENIED, x.get(0).toString()),
//				Double.parseDouble(x.get(1).toString()))
//			);
//		
//		maxBudgetByCurrencyAndStatus = new HashMap<Pair<Status, String>, Double>();	
//		this.repository.maxBudgetByCurrencyAndStatus(Status.PROPOSED).stream()
//		.forEach(x->
//		maxBudgetByCurrencyAndStatus.put(
//				Pair.of(Status.PROPOSED, x.get(0).toString()),
//				Double.parseDouble(x.get(1).toString()))
//			);
//		this.repository.maxBudgetByCurrencyAndStatus(Status.ACCEPTED).stream()
//		.forEach(x->
//		maxBudgetByCurrencyAndStatus.put(
//				Pair.of(Status.ACCEPTED, x.get(0).toString()),
//				Double.parseDouble(x.get(1).toString()))
//			);
//		this.repository.maxBudgetByCurrencyAndStatus(Status.DENIED).stream()
//		.forEach(x->
//		maxBudgetByCurrencyAndStatus.put(
//				Pair.of(Status.DENIED, x.get(0).toString()),
//				Double.parseDouble(x.get(1).toString()))
//			);
//
//		result = new AdministratorDashboard();
//		result.setNumberOfPatronagesByStatus(numberOfPatronagesByStatus);
//		result.setAverageNumberOfBudgetsByCurrencyAndStatus(averageNumberOfBudgetsByCurrencyAndStatus);
//		result.setDeviationOfBudgetsByCurrencyAndStatus(deviationOfBudgetsByCurrencyAndStatus);
//		result.setMinBudgetByCurrencyAndStatus(minBudgetByCurrencyAndStatus);
//		result.setMaximumRetailPriceOfComponentsByTechnologyAndCurrency(maxBudgetByCurrencyAndStatus);
//		
//		System.out.println("P1" + numberOfPatronagesByStatus);
//		System.out.println("P2" + averageNumberOfBudgetsByCurrencyAndStatus);
//		System.out.println("P3" + deviationOfBudgetsByCurrencyAndStatus);
//		System.out.println("P4" + minBudgetByCurrencyAndStatus);
//		System.out.println("P5" + maxBudgetByCurrencyAndStatus);
//		
//		return result;
//		
//	}
//
//	@Override
//	public void unbind(final Request<AdministratorDashboard> request, final AdministratorDashboard entity, final Model model) {
//		assert request != null;
//		assert entity != null;
//		assert model != null;
//
//		request.unbind(entity, model, //
//			"numberOfPatronagesByStatus", "averageNumberOfBudgetsByCurrencyAndStatus", // 
//			"deviationOfBudgetsByCurrencyAndStatus", "minBudgetByCurrencyAndStatus", //
//			"maxBudgetByCurrencyAndStatus");
//	
//	}
//
//}
