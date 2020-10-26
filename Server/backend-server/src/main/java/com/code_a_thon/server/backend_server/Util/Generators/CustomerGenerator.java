package com.code_a_thon.server.backend_server.Util.Generators;

import com.code_a_thon.server.backend_server.Entity.Business;
import com.code_a_thon.server.backend_server.Entity.CustomerEntity;
import com.code_a_thon.server.backend_server.Entity.CustomerProperties.FavoriteBussinessId;
import com.code_a_thon.server.backend_server.Entity.CustomerProperties.SubscribedBusinessId;
import com.code_a_thon.server.backend_server.Entity.UserType;
import com.code_a_thon.server.backend_server.Repository.*;
import com.code_a_thon.server.backend_server.Util.Generators.AccountGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CustomerGenerator {
    @Autowired
    private AccountGenerator accountGenerator;

    @Autowired
    private BusinessRepository businessRepository;

    @Autowired
    private FavoritesRepository favoritesRepository;
    @Autowired
    private SubscribedRepository subscribedRepository;

    private static Random random = new Random();

    public CustomerGenerator() { }

    public CustomerEntity createCustomer() {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setAccountId(accountGenerator.createAccount(UserType.USER).getId());

        customerEntity.setFavoriteBussinessIds(getFavoritesIds());
        customerEntity.setSubscribedList(getSubscribedIds());

        return customerEntity;
    }

    private List<SubscribedBusinessId> getSubscribedIds() {
        List<SubscribedBusinessId> subscribedBusinessIds = new ArrayList<>();
        int numSubscribed = random.nextInt(10);
        List<Long> businessIds = businessRepository.getAllIds();

        for (int i = 0; i < numSubscribed; i++) {
            Long businessId = businessIds.get(random.nextInt(businessIds.size()));
            businessIds.remove(businessId);
            subscribedBusinessIds.add(new SubscribedBusinessId(Math.toIntExact(businessId)));
        }

        subscribedRepository.saveAll(subscribedBusinessIds);
        return subscribedBusinessIds;
    }

    private List<FavoriteBussinessId> getFavoritesIds() {
        List<FavoriteBussinessId> favoriteBussinessIds = new ArrayList<>();
        int numFavorites = random.nextInt(10);
        List<Long> businessIds = businessRepository.getAllIds();

        for (int i = 0; i < numFavorites; i++) {
            Long businessId = businessIds.get(random.nextInt(businessIds.size()));
            businessIds.remove(businessId);
            favoriteBussinessIds.add(new FavoriteBussinessId(Math.toIntExact(businessId)));
        }

        favoritesRepository.saveAll(favoriteBussinessIds);
        return favoriteBussinessIds;
    }
}
