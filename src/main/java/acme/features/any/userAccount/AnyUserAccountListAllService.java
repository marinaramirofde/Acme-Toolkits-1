package acme.features.any.userAccount;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.entities.UserAccount;
import acme.framework.roles.Administrator;
import acme.framework.roles.Any;
import acme.framework.roles.Authenticated;
import acme.framework.roles.UserRole;
import acme.framework.services.AbstractListService;

@Service
public class AnyUserAccountListAllService implements AbstractListService<Any, UserAccount> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnyUserAccountRepository repository;

	// AbstractListService<Any, UserAccount> interface --------------


	@Override
	public boolean authorise(final Request<UserAccount> request) {
		assert request != null;

		return true;
	}

	@Override
	public Collection<UserAccount> findMany(final Request<UserAccount> request) {
		assert request != null;

		Collection<UserAccount> result;

		result = this.repository.findAllUserAccounts();
		for (final UserAccount userAccount : result) {
			userAccount.getRoles().forEach(r -> {
			});
		}

		return result;
	}

	@Override
	public void unbind(final Request<UserAccount> request, final UserAccount entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		StringBuilder buffer;
		Collection<UserRole> roles;

		request.unbind(entity, model);

		roles = entity.getRoles();
		buffer = new StringBuilder();
		for (final UserRole role : roles) {
			final boolean predicado = !role.getUserAccount().isAnonymous() && !role.getUserAccount().hasRole(Administrator.class)
				&&!role.getUserAccount().hasRole(Authenticated.class);
			if(predicado) {
				buffer.append(role.getAuthorityName());
				buffer.append(" ");
			}
		}

		model.setAttribute("roleList", buffer.toString());

	}

}
