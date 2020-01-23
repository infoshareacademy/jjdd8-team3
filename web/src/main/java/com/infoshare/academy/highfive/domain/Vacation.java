package com.infoshare.academy.highfive.domain;

import javax.persistence.*;
import javax.xml.namespace.QName;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NamedQueries({
  @NamedQuery(name = "Vacation.findPendingRequests", query = "SELECT vacation " +
    "FROM Vacation vacation " +
    "JOIN FETCH Employee employee ON vacation.employee = employee " +
    "WHERE vacation.vacationStatus = :status"),
  @NamedQuery(name = "Vacation.findVacationById", query = "SELECT vacation " +
    "FROM Vacation vacation " +
    "WHERE vacation.id = :vacationId")//,
//  @NamedQuery(name = "Vacation.stillPendingRequest", query = "SELECT e.firstName, e.surname FROM Employee e " +
//    "INNER JOIN Vacation v " +
//    "WHERE v.id = e.id")
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
    @ManyToOne(fetch = FetchType.EAGER)
    private Employee employee;

    @Column (name = "from_date", nullable = false)
    private LocalDate vacationFrom;

    @Column (name = "to_date", nullable = false)
    private LocalDate vacationTo;

    @Column (name = "date_of_request" , nullable = false)
    private LocalDateTime dateOfRequest;

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

    public LocalDateTime getDateOfRequest() {
        return dateOfRequest;
    }

    public void setDateOfRequest(LocalDateTime dateOfRequest) {
        this.dateOfRequest = dateOfRequest;
    }

    public VacationType getVacationType() { return vacationType; }

    public void setVacationType(VacationType vacationType) { this.vacationType = vacationType; }

    public VacationStatus getVacationStatus() { return vacationStatus; }

    public void setVacationStatus(VacationStatus vacationStatus) { this.vacationStatus = vacationStatus; }
}
