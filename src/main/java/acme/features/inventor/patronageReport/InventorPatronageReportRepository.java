package acme.features.inventor.patronageReport;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.patronageReports.PatronageReport;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorPatronageReportRepository extends AbstractRepository{

	@Override
	@Query("select p from PatronageReport p")
	Collection<PatronageReport> findAll();
	
	@Query("select p from PatronageReport p where p.patronage = acme.entities.patronageReports.PatronageReport")
	Collection<PatronageReport> findByPatronage();
}
