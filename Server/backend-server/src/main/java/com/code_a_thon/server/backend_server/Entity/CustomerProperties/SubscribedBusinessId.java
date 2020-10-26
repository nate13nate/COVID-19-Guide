package com.code_a_thon.server.backend_server.Entity.CustomerProperties;

import javax.persistence.Entity;

@Entity
public class SubscribedBusinessId extends BusinessIdObject {
    protected SubscribedBusinessId() {
    }

    public SubscribedBusinessId(int businessId) {
        super(businessId);
    }
}
