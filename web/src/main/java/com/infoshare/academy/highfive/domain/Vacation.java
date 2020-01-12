package com.infoshare.academy.highfive.domain;

import javax.persistence.*;
import java.time.LocalDate;
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
    private LocalDate vacationFrom;

    @Column (name = "to_date", nullable = false)
    private LocalDate vacationTo;

    @Enumerated(EnumType.STRING)
    @Column (name = "vacation_type")
    private VacationType vacationType;

    @Enumerated(EnumType.STRING)
    @Column (name = "vacation_status")
    private VacationStatus vacationStatus;

    public int getId() { return id; }

    public Employee getEmployeeId() { return employeeId; }

    public void setEmployeeId(Employee employeeId) { this.employeeId = employeeId; }

    public LocalDate getVacationFrom() { return vacationFrom; }

    public void setVacationFrom(LocalDate vacationFrom) { this.vacationFrom = vacationFrom;}

    public LocalDate getVacationTo() { return vacationTo; }

    public void setVacationTo(LocalDate vacationTo) { this.vacationTo = vacationTo; }

    public VacationType getVacationType() { return vacationType; }

    public void setVacationType(VacationType vacationType) { this.vacationType = vacationType; }

    public VacationStatus getVacationStatus() { return vacationStatus; }

    public void setVacationStatus(VacationStatus vacationStatus) { this.vacationStatus = vacationStatus; }
}
