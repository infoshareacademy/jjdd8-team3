
package com.infoshare.academy.highfive.vacation;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class Vacation {



    private String employeeId;

    private String dateFrom;

    private String dateTo;

    private String type;

    private Map<String, Object> additionalProperties = new HashMap<>();



    public Vacation(){}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Vacation(String employeeId, String dateFrom, String dateTo, String type) {
        this.employeeId = employeeId;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.type = type;
    }

    public String getEmployeeId() {
        return employeeId;
    }


    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }


    public String getDateFrom() {
        return dateFrom;
    }


    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }


    public String getDateTo() {
        return dateTo;
    }


    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}