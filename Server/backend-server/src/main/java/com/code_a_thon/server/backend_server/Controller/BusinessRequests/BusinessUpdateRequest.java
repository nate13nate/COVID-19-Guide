package com.code_a_thon.server.backend_server.Controller.BusinessRequests;

import com.code_a_thon.server.backend_server.Entity.BusinessProperties.Address;

public class BusinessUpdateRequest {
    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public int getMaxOccupancy() {
        return maxOccupancy;
    }

    public void setMaxOccupancy(int maxOccupancy) {
        this.maxOccupancy = maxOccupancy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String[] getHoursOfOperation() {
        return hoursOfOperation;
    }

    public void setHoursOfOperation(String[] hoursOfOperation) {
        this.hoursOfOperation = hoursOfOperation;
    }

    public String[] getCovidRules() {
        return covidRules;
    }

    public void setCovidRules(String[] covidRules) {
        this.covidRules = covidRules;
    }

    private Long businessId;

    private int maxOccupancy;

    private String name;

    public AddressInRequest getAddress() {
        return address;
    }

    public void setAddress(AddressInRequest address) {
        this.address = address;
    }

    private AddressInRequest address;

    private String atRiskPopulationBusinessHours;
    private String imageFilesList;

    private String[] hoursOfOperation;
    private String[] covidRules;
}
