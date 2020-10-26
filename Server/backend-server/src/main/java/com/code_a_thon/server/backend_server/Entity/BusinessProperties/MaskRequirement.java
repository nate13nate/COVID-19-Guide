package com.code_a_thon.server.backend_server.Entity.BusinessProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MaskRequirement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private boolean masksRequired;
    private String information;

    public MaskRequirement(){}

    public MaskRequirement(boolean masksRequired, String information) {
        this.masksRequired = masksRequired;
        this.information = information;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public boolean isMasksRequired() {
        return masksRequired;
    }

    public void setMasksRequired(boolean masksRequired) {
        this.masksRequired = masksRequired;
    }
}
