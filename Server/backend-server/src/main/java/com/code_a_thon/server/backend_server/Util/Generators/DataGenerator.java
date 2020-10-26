package com.code_a_thon.server.backend_server.Util.Generators;

import com.code_a_thon.server.backend_server.Entity.Business;
import com.code_a_thon.server.backend_server.Entity.CustomerEntity;
import com.code_a_thon.server.backend_server.Repository.BusinessRepository;
import com.code_a_thon.server.backend_server.Repository.CustomerRepository;
import com.code_a_thon.server.backend_server.Util.Generators.BusinessGenerator;
import com.code_a_thon.server.backend_server.Util.Generators.CustomerGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataGenerator {
    @Autowired
    private BusinessRepository businessRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BusinessGenerator businessGenerator;
    @Autowired
    private CustomerGenerator customerGenerator;

    public DataGenerator() { }

    public void createCustomerEntityList (int count) {
        List<CustomerEntity> customerEntityList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            customerEntityList.add(customerGenerator.createCustomer());
        }

        customerRepository.saveAll(customerEntityList);
    }

    public void createBusinessList(int count) {
        List<Business> businessList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            businessList.add(businessGenerator.createBusiness());
        }

        businessRepository.saveAll(businessList);
    }
}
