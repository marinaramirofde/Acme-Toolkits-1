package acme.features.patron.systemConfiguration;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.configurations.SystemConfiguration;
import acme.framework.controllers.AbstractController;
import acme.roles.Patron;

@Controller
public class PatronSystemConfigurationController extends AbstractController<Patron, SystemConfiguration>{

    // Internal state ---------------------------------------------------------
        @Autowired
        protected PatronSystemConfigurationShowService showService;

        // Constructors -----------------------------------------------------------


        @PostConstruct
        protected void initialise() {
            super.addCommand("show", this.showService);
        }
}