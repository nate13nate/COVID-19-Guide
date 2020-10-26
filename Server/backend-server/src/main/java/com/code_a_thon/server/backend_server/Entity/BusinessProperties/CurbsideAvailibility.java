package com.code_a_thon.server.backend_server.Entity.BusinessProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CurbsideAvailibility {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private boolean curbsideAvailible;
    private String notes;

    public CurbsideAvailibility(){}

    public CurbsideAvailibility(boolean curbsideAvailible, String notes) {
        this.curbsideAvailible = curbsideAvailible;
        this.notes = notes;
    }

    public boolean isCurbsideAvailible() {
        return curbsideAvailible;
    }

    public void setCurbsideAvailible(boolean curbsideAvailible) {
        this.curbsideAvailible = curbsideAvailible;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}