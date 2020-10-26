package com.code_a_thon.server.backend_server.Controller.BusinessRequests;

import com.code_a_thon.server.backend_server.Entity.BusinessProperties.HoursOfOperation;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;

@Service
public class BusinessCreationRequest {
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
        return Arrays.asList(hoursOfOperation);
    }

    public void setHoursOfOperation(HoursOfOperation[] hoursOfOperation) {
        this.hoursOfOperation = hoursOfOperation;
    }

    @NotNull
    HoursOfOperation[] hoursOfOperation;

    public Long getAccountOwnerid() {
        return accountOwnerid;
    }

    @NotNull
    Long accountOwnerid;

    @NotNull
    String name;

    @Min(1)
    int maxOccupancy;
    @NotNull
    String[] covidRules;
    @NotNull
    String atRiskPopulationBusinessHours;
    @NotNull
    String imageFilesList;

    public void setAccountOwnerid(Long accountOwnerid) {
        this.accountOwnerid = accountOwnerid;
    }

    public AddressInRequest getAddress() {
        return address;
    }

    public void setAddress(AddressInRequest address) {
        this.address = address;
    }

    @NotNull
    AddressInRequest address;
}
