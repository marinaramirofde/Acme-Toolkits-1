package acme.features.inventor.systemConfiguration;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.configurations.SystemConfiguration;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorSystemConfigurationRepository extends AbstractRepository{
	
    @Query("select sc from SystemConfiguration sc")
    SystemConfiguration findSystemConfiguration();

}
