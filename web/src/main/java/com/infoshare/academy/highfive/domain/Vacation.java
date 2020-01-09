package com.infoshare.academy.highfive.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "vacation")
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @JoinColumn(name = "employee_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employeeId;

    @Column (name = "from_date", nullable = false)
    private Date vacationFrom;

    @Column (name = "to_date", nullable = false)
    private Date vacationTo;

    @Column (name = "vacation_type")
    private VacationType vacationType;

    @Column (name = "vacation_status")
    private VacationStatus vacationStatus;

    public int getId() { return id; }

    public Employee getEmployeeId() { return employeeId; }

    public void setEmployeeId(Employee employeeId) { this.employeeId = employeeId; }

    public Date getVacationFrom() { return vacationFrom; }

    public void setVacationFrom(Date vacationFrom) { this.vacationFrom = vacationFrom;}

    public Date getVacationTo() { return vacationTo; }

    public void setVacationTo(Date vacationTo) { this.vacationTo = vacationTo; }

    public VacationType getVacationType() { return vacationType; }

    public void setVacationType(VacationType vacationType) { this.vacationType = vacationType; }

    public VacationStatus getVacationStatus() { return vacationStatus; }

    public void setVacationStatus(VacationStatus vacationStatus) { this.vacationStatus = vacationStatus; }
}
