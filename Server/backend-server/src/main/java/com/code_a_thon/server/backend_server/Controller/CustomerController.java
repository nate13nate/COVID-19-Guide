package com.code_a_thon.server.backend_server.Controller;

import java.util.List;
import java.util.Optional;

import com.code_a_thon.server.backend_server.Controller.CustomerRequests.CustomerCreationRequest;
import com.code_a_thon.server.backend_server.Entity.Account;
import com.code_a_thon.server.backend_server.Repository.AccountRepository;
import com.code_a_thon.server.backend_server.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.code_a_thon.server.backend_server.Entity.CustomerEntity;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private AccountRepository accountRepository;
	@Autowired
	private CustomerRepository customerRepo;

	@GetMapping("/")
    public List<CustomerEntity> getAllCustomers() {
        return (List<CustomerEntity>) customerRepo.findAll();
    }

    @GetMapping("/findById")
    public Optional<CustomerEntity> getCustomerById(@RequestParam("id") long id) {
        return customerRepo.findById(id);
    }

    @PostMapping("/")
    public void createCustomer(@RequestBody CustomerCreationRequest req) {
        Optional<Account> customerAccount = accountRepository.findById(req.getAccountId());

        if(customerAccount.isPresent()) {
            CustomerEntity customerEntity = new CustomerEntity(req);
            customerRepo.save(customerEntity);
        }
	}

    @DeleteMapping("/")
    public void deleteCustomer(@RequestParam("id") long id) {
    	customerRepo.deleteById(id);
    }

    @PutMapping("/")
    public ResponseEntity<Object> updateCustomer(@RequestParam CustomerEntity customer, @RequestParam long id) {
        Optional<CustomerEntity> customerOptional = customerRepo.findById(id);

        if(!customerOptional.isPresent())
            return ResponseEntity.notFound().build();

        customerRepo.save(customer);

        return ResponseEntity.noContent().build();
    }
}
