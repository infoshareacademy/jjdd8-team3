package com.infoshare.academy.highfive.request;

import com.infoshare.academy.highfive.domain.Role;
import com.infoshare.academy.highfive.domain.VacationType;

import java.util.Date;

public class VacationRequest {

  private Long id;

  private Role role;

  private Date dateFrom;

  private Date dateTo;

  private VacationType vacationType;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public Date getDateFrom(Date dateFrom) {
    return this.dateFrom;
  }

  public void setDateFrom(Date dateFrom) {
    this.dateFrom = dateFrom;
  }

  public Date getDateTo() {
    return dateTo;
  }

  public void setDateTo(Date dateTo) {
    this.dateTo = dateTo;
  }

  public VacationType getVacationType() {
    return vacationType;
  }

  public void setVacationType(VacationType vacationType) {
    this.vacationType = vacationType;
  }
}
