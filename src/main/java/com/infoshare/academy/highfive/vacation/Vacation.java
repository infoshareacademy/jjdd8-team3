
package com.infoshare.academy.highfive.vacation;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "emplyeeID",
    "datefrom",
    "dateto"
})
public class Vacation {

    public Vacation(String emplyeeID, String datefrom, String dateto) {
        this.emplyeeID = emplyeeID;
        this.datefrom = datefrom;
        this.dateto = dateto;
    }

    public Vacation() {
    }

    @JsonProperty("emplyeeID")
    private String emplyeeID;
    @JsonProperty("datefrom")
    private String datefrom;
    @JsonProperty("dateto")
    private String dateto;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("emplyeeID")

    public String getEmplyeeID() {
        return emplyeeID;
    }

    @JsonProperty("emplyeeID")
    public void setEmplyeeID(String emplyeeID) {
        this.emplyeeID = emplyeeID;
    }

    @JsonProperty("datefrom")
    public String getDatefrom() {
        return datefrom;
    }

    @JsonProperty("datefrom")
    public void setDatefrom(String datefrom) {
        this.datefrom = datefrom;
    }

    @JsonProperty("dateto")
    public String getDateto() {
        return dateto;
    }

    @JsonProperty("dateto")
    public void setDateto(String dateto) {
        this.dateto = dateto;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
