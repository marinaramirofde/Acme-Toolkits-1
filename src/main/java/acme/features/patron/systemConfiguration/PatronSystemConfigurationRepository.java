package acme.features.patron.systemConfiguration;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.configurations.SystemConfiguration;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface PatronSystemConfigurationRepository extends AbstractRepository{
    @Query("select sc from SystemConfiguration sc")
    Collection<SystemConfiguration> findSystemConfiguration();

}
