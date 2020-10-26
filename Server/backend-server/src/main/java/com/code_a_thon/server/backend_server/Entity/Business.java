package com.code_a_thon.server.backend_server.Entity;

import com.code_a_thon.server.backend_server.Controller.BusinessRequests.BusinessCreationRequest;
import com.code_a_thon.server.backend_server.Entity.BusinessProperties.Address;
import com.code_a_thon.server.backend_server.Entity.BusinessProperties.HoursOfOperation;

import javax.persistence.*;
import java.util.List;

@Entity
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    private List<HoursOfOperation> hoursOfOperation;
    @OneToOne
    private Address address;
    private Long accountOwnerId;

    private String name;

    private int maxOccupancy;
    private String[] covidRules;
    private String atRiskPopulationBusinessHours;
    private String imageFilesList;

    public Business(){}

    public Business(BusinessCreationRequest req) {
        setName(req.getName());
        setMaxOccupancy(req.getMaxOccupancy());
        setCovidRules(req.getCovidRules());
        setAtRiskPopulationBusinessHours(req.getAtRiskPopulationBusinessHours());
        setImageFilesList(req.getImageFilesList());
        setAccountOwnerId(req.getAccountOwnerid());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxOccupancy() {
        return maxOccupancy;
    }

    public void setMaxOccupancy(int maxOccupancy) {
        this.maxOccupancy = maxOccupancy;
    }

    public String[] getCovidRules() {
        return covidRules;
    }

    public void setCovidRules(String[] covidRules) {
        this.covidRules = covidRules;
    }

    public String getAtRiskPopulationBusinessHours() {
        return atRiskPopulationBusinessHours;
    }

    public void setAtRiskPopulationBusinessHours(String atRiskPopulationBusinessHours) {
        this.atRiskPopulationBusinessHours = atRiskPopulationBusinessHours;
    }

    public String getImageFilesList() {
        return imageFilesList;
    }

    public void setImageFilesList(String imageFilesList) {
        this.imageFilesList = imageFilesList;
    }

    public List<HoursOfOperation> getHoursOfOperation() {
        return hoursOfOperation;
    }

    public void setHoursOfOperation(List<HoursOfOperation> hoursOfOperation) {
        this.hoursOfOperation = hoursOfOperation;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountOwnerId() {
        return accountOwnerId;
    }

    public void setAccountOwnerId(Long accountOwnerId) {
        this.accountOwnerId = accountOwnerId;
    }
}
