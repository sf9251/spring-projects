package org.sf.productservice.repository;

import java.util.HashMap;
import java.util.Map;

import org.sf.productservice.domain.ApplicationUser;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryApplicationUserRepository implements ApplicationUserRepository {

	private Map<String, ApplicationUser> applicationUser = new HashMap<String, ApplicationUser>();

	@Override
	public ApplicationUser findByUsername(String username) {
		return this.applicationUser.get(username);
	}

	@Override
	public void save(ApplicationUser applicationUser) {
		if (!this.applicationUser.containsKey(applicationUser))
			this.applicationUser.put(applicationUser.getUsername(), applicationUser);
	}
}
