package org.sf.productservice.domain;

public class ApplicationUser {

	private String username;
	private String password;

	public ApplicationUser() {
		// TODO Auto-generated constructor stub
	}

	public ApplicationUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}