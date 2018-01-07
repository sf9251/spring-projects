package org.sf.productservice.rest;

import org.sf.productservice.domain.ApplicationUser;
import org.sf.productservice.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private ApplicationUserRepository applicationUserRepository;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@RequestMapping("/sign-up")
	public void signUp(@RequestBody ApplicationUser user) {
		user.setPassword(bcryptPasswordEncoder.encode(user.getPassword()));
		applicationUserRepository.save(user);
	}
}
