package com.code_a_thon.server.backend_server.Controller.CustomerRequests;

import com.code_a_thon.server.backend_server.Entity.CustomerProperties.FavoriteBussinessId;
import com.code_a_thon.server.backend_server.Entity.CustomerProperties.SubscribedBusinessId;
import com.code_a_thon.server.backend_server.Repository.FavoritesRepository;
import com.code_a_thon.server.backend_server.Repository.SubscribedRepository;
import com.zaxxer.hikari.util.FastList;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class CustomerCreationRequest {
    @Autowired
    FavoritesRepository favoritesRepository;
    @Autowired
    SubscribedRepository subscribedRepository;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @NotNull
    Long accountId;

    public List<FavoriteBussinessId> getFavoritesList() {
        return favoritesList;
    }

    public void setFavoritesList(String[] favoritesList) {
        this.favoritesList = new ArrayList<>();
        for(String s :  favoritesList) {
            FavoriteBussinessId favoriteBussinessId = new FavoriteBussinessId(Integer.parseInt(s));
//            favoritesRepository.save(favoriteBussinessId);
//            this.favoritesList.add(favoriteBussinessId);
        }
    }

    public List<SubscribedBusinessId> getSubscribedList() {
        return subscribedList;
    }

    public void setSubscribedList(String[] subscribedList) {
        this.subscribedList = new ArrayList<>();
        for(String s : subscribedList) {
            SubscribedBusinessId subscribedBusinessId = new SubscribedBusinessId(Integer.parseInt(s));
//            subscribedRepository.save(subscribedBusinessId);
//            this.subscribedList.add(subscribedBusinessId);
        }
    }

    @NotNull
    private List<FavoriteBussinessId> favoritesList;
    @NotNull
    private List<SubscribedBusinessId> subscribedList;
}
