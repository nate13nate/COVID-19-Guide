package com.code_a_thon.server.backend_server.Entity;

import com.code_a_thon.server.backend_server.Controller.CustomerRequests.CustomerCreationRequest;
import com.code_a_thon.server.backend_server.Entity.CustomerProperties.BusinessIdObject;
import com.code_a_thon.server.backend_server.Entity.CustomerProperties.FavoriteBussinessId;
import com.code_a_thon.server.backend_server.Entity.CustomerProperties.SubscribedBusinessId;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
public class CustomerEntity {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Long accountId;

	@OneToMany
	private List<FavoriteBussinessId> favoriteBussinessIds;
	@OneToMany
	private List<SubscribedBusinessId> subscribedList;

	// Used in CustomerGenerator
	public CustomerEntity() {}

	public CustomerEntity(CustomerCreationRequest req) {
		this.accountId = req.getAccountId();
		this.favoriteBussinessIds = req.getFavoritesList();
		this.subscribedList = req.getSubscribedList();
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public List<FavoriteBussinessId> getFavoriteBussinessIds() {
		return favoriteBussinessIds;
	}

	public void setFavoriteBussinessIds(List<FavoriteBussinessId> favoriteBussinessIds) {
		this.favoriteBussinessIds = favoriteBussinessIds;
	}

	public List<SubscribedBusinessId> getSubscribedList() {
		return subscribedList;
	}

	public void setSubscribedList(List<SubscribedBusinessId> subscribedList) {
		this.subscribedList = subscribedList;
	}
}
