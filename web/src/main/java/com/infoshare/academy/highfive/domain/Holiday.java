package com.infoshare.academy.highfive.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "holiday")
public class Holiday {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @JoinColumn(name = "holiday_type_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private HolidayType holidayType;
}
