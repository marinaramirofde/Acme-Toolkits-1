package acme.features.inventor.systemConfiguration;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.configurations.SystemConfiguration;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorSystemConfigurationController extends AbstractController<Inventor, SystemConfiguration>{

    // Internal state ---------------------------------------------------------
        @Autowired
        protected InventorSystemConfigurationShowService showService;

        // Constructors -----------------------------------------------------------


        @PostConstruct
        protected void initialise() {
            super.addCommand("show", this.showService);
        }
}