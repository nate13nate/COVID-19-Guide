package com.code_a_thon.server.backend_server.Entity;

import com.code_a_thon.server.backend_server.Controller.AccountRequests.AccountCreationRequest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String email;
	private String hash;
	UserType type;

	// Used by AccountGenerator
	public Account() {}

	public Account(AccountCreationRequest req) {
		setEmail(req.getEmail());
		setHash(req.getPassword());
		setType(req.getUserType());
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public UserType getType() {
		return type;
	}
	public void setType(UserType type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Account belonging to: " + this.email;
	}
}
