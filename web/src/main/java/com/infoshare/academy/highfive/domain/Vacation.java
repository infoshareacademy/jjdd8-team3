package com.infoshare.academy.highfive.domain;

import javax.persistence.*;
import java.time.LocalDate;

@NamedQueries({
  @NamedQuery(name = "Vacation.findPendingRequests", query = "SELECT vacation " +
    "FROM Vacation vacation " +
    "INNER JOIN Employee employee ON vacation.employee = employee " +
    "WHERE vacation.vacationStatus = com.infoshare.academy.highfive.domain.VacationStatus.APPLIED"),
  }
)

@Entity
@Table (name = "vacation")
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @JoinColumn(name = "employee_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

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

    public Long getId() { return id; }

    public Employee getEmployee() { return employee; }

    public void setEmployee(Employee employee) { this.employee = employee; }

    public LocalDate getVacationFrom() { return vacationFrom; }

    public void setVacationFrom(LocalDate vacationFrom) { this.vacationFrom = vacationFrom;}

    public LocalDate getVacationTo() { return vacationTo; }

    public void setVacationTo(LocalDate vacationTo) { this.vacationTo = vacationTo; }

    public VacationType getVacationType() { return vacationType; }

    public void setVacationType(VacationType vacationType) { this.vacationType = vacationType; }

    public VacationStatus getVacationStatus() { return vacationStatus; }

    public void setVacationStatus(VacationStatus vacationStatus) { this.vacationStatus = vacationStatus; }
}
