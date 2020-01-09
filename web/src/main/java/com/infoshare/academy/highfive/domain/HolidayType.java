package com.infoshare.academy.highfive.domain;

import javax.persistence.*;

@Entity
@Table(name = "holiday_type")
public class HolidayType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="holiday_type", nullable = false)
    private String holidayType;
}
