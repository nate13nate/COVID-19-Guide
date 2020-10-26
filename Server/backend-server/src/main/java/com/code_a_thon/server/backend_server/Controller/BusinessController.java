package com.code_a_thon.server.backend_server.Controller;

import com.code_a_thon.server.backend_server.Controller.BusinessRequests.BusinessCreationRequest;
import com.code_a_thon.server.backend_server.Controller.BusinessRequests.BusinessUpdateRequest;
import com.code_a_thon.server.backend_server.Entity.BusinessProperties.Address;
import com.code_a_thon.server.backend_server.Repository.AccountRepository;
import com.code_a_thon.server.backend_server.Repository.AddressRepository;
import com.code_a_thon.server.backend_server.Repository.BusinessRepository;
import com.code_a_thon.server.backend_server.Entity.Business;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/business") @Validated
public class BusinessController {
    @Autowired
    BusinessRepository businessRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    AddressRepository addressRepository;

    @GetMapping("/")
    public List<Business> getAllBusinesses() {
        return (List<Business>) businessRepository.findAll();
    }

    @GetMapping("/findById")
    public Optional<Business> getBusinessById(@RequestParam("id") long id) {
        return businessRepository.findById(id);
    }

    @PostMapping("/")
    public void createBusiness(@Valid @RequestBody BusinessCreationRequest req) {
        Business business = new Business(req);

        Address address = new Address(req.getAddress());
        addressRepository.save(address);

        business.setAddress(address);
        businessRepository.save(business);
    }

    @PutMapping("/")
    public void updateBusiness(@RequestBody BusinessUpdateRequest req) {
        Optional<Business> businessOptional = businessRepository.findById(req.getBusinessId());

        if(businessOptional.isPresent()) {
            Business business = businessOptional.get();

            if(req.getMaxOccupancy() != 0)
                business.setMaxOccupancy(req.getMaxOccupancy());
            if(req.getName() != null)
                business.setName(req.getName());
            if(req.getAddress() != null) {
                Address address = new Address(req.getAddress());
                addressRepository.save(address);
                business.setAddress(address);
            }
            if(req.getAtRiskPopulationBusinessHours() != null)
                business.setAtRiskPopulationBusinessHours(req.getAtRiskPopulationBusinessHours());
            if(req.getImageFilesList() != null)
                business.setAtRiskPopulationBusinessHours(req.getAtRiskPopulationBusinessHours());
 /*           if(req.getHoursOfOperation() != null)
                business.setHoursOfOperation(req.getHoursOfOperation());*/
            if(req.getCovidRules() != null)
                business.setCovidRules(req.getCovidRules());

            businessRepository.save(business);

        }
    }

    @DeleteMapping("/")
    public void deleteBusiness(@RequestParam("id") long id) {
        businessRepository.deleteById(id);
    }
}
