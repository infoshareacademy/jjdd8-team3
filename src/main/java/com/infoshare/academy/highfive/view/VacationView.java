package com.infoshare.academy.highfive.view;

import java.text.SimpleDateFormat;
import java.util.Date;

public class VacationView {

    private String employeeID;
    private Date from;
    private Date to;

    public VacationView(String employeeID, Date from, Date to) {
        this.employeeID = employeeID;
        this.from = from;
        this.to = to;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return from + " | "
                + employeeID
                + new SimpleDateFormat("EEEE").format(from)
                + new SimpleDateFormat("EEEE").format(to);
    }

}
