package com.code_a_thon.server.backend_server.Entity.CustomerProperties;

import javax.persistence.Entity;

@Entity
public class FavoriteBussinessId extends BusinessIdObject {

    protected FavoriteBussinessId() {
    }

    public FavoriteBussinessId(int businessId) {
        super(businessId);
    }
}
