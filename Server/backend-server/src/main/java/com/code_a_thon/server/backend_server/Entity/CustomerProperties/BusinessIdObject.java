package com.code_a_thon.server.backend_server.Entity.CustomerProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class BusinessIdObject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int businessId;

    public BusinessIdObject() {

    }

    public int getBusinessId() {
        return businessId;
    }

    public void setBusinessId(int businessId) {
        this.businessId = businessId;
    }

    public BusinessIdObject(int businessId) {
        this.businessId = businessId;
    }
}
