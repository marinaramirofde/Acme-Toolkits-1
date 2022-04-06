package acme.features.inventor.systemConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.configurations.SystemConfiguration;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorSystemConfigurationShowService implements AbstractShowService<Inventor, SystemConfiguration>{

    @Autowired
    protected InventorSystemConfigurationRepository repository;

    @Override
    public boolean authorise(final Request<SystemConfiguration> request) {
        assert request != null;

        return true;
    }

    @Override
    public SystemConfiguration findOne(final Request<SystemConfiguration> request) {
        assert request != null;

        SystemConfiguration result;
        result= this.repository.findSystemConfiguration().stream().findFirst().get();
        return result;
    }

    @Override
    public void unbind(final Request<SystemConfiguration> request, final SystemConfiguration entity, final Model model) {
        assert request != null;
        assert entity != null;
        assert model != null;

        request.unbind(entity, model, "acceptedCurrencies", "systemCurrency", "strongSpamWords", 
            "strongSpamThreshold", "weakSpamWords", "weakSpamThreshold");
        model.setAttribute("confirmation", false);
        model.setAttribute("readonly", true);
    }

}
