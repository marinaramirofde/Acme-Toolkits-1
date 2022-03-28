package acme.features.inventor.patronageReport;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.patronageReports.PatronageReport;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorPatronageReportRepository extends AbstractRepository{

	@Query("select p from PatronageReport p")
	Collection<PatronageReport> findAllPatronagesReport();
	
	@Query("select p from PatronageReport p where p.id = :id")
	PatronageReport findOneById(int id);
}
