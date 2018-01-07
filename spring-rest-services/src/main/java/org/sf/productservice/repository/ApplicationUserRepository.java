package org.sf.productservice.repository;

import org.sf.productservice.domain.ApplicationUser;

public interface ApplicationUserRepository {

	ApplicationUser findByUsername(String username);
	void save(ApplicationUser applicationUser);
	
}
