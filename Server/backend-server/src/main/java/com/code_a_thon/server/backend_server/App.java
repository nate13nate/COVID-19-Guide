package com.code_a_thon.server.backend_server;

import com.code_a_thon.server.backend_server.Entity.Account;
import com.code_a_thon.server.backend_server.Entity.UserType;
import com.code_a_thon.server.backend_server.Repository.AccountRepository;
import com.code_a_thon.server.backend_server.Repository.AddressRepository;
import com.code_a_thon.server.backend_server.Repository.BusinessRepository;
import com.code_a_thon.server.backend_server.Repository.CustomerRepository;
import com.code_a_thon.server.backend_server.Util.Generators.DataGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    BusinessRepository businessRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    public AddressRepository addressRepository;

    @Autowired
    DataGenerator dataGenerator;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) {
    	Account account = new Account();
        account.setEmail("email@example.com");
        account.setHash("HASH");
        account.setType(UserType.BUSINESS);

        accountRepository.save(account);

        dataGenerator.createBusinessList(30);
        dataGenerator.createCustomerEntityList(100);
    }
}