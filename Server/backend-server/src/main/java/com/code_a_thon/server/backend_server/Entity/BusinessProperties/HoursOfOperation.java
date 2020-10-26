package com.code_a_thon.server.backend_server.Entity.BusinessProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HoursOfOperation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String dayOfWeek;
    private String hours;

    protected HoursOfOperation() {}

    public HoursOfOperation(String dayOfWeek, String hours) {
        this.dayOfWeek = dayOfWeek;
        this.hours = hours;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }
}
