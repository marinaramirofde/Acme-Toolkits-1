package acme.features.patron.patronage;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.patronages.Patronage;
import acme.framework.entities.UserAccount;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Patron;

@Repository
public interface PatronPatronageRepository extends AbstractRepository {

	@Query("select p from Patronage p where p.id = :id")
	Patronage findOneById(int id);

	@Query("select p from Patronage p where p.patron.id = :patronId")
	Collection<Patronage> findManyPatronagesByPatronId(int patronId);

	@Query("select p from Patron p where p.id = :patronId")
	Patron findOnePatronById(int patronId);

	@Query("select p from Patronage p where p.code = :code")
	Patronage findOnePatronageByCode(String code);

	@Query("select ua from UserAccount ua join ua.roles where ua.username = 'inventor1'")
	UserAccount findUserAccount();
	

}
