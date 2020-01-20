package com.infoshare.academy.highfive.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.infoshare.academy.highfive.parser.CustomHolidayDeserializer;
import org.jboss.logging.Param;
import com.infoshare.academy.highfive.util.CustomHolidayRequestDeserializer;

import javax.persistence.*;
import java.time.LocalDate;

@NamedQueries({
        @NamedQuery(name = "Holiday.findAll", query = "SELECT holiday FROM Holiday holiday"),
//        @NamedQuery(
//                name = "Holiday.findHolidaysInRange",
//                query = "SELECT holiday FROM Holiday holiday WHERE holiday.date BETWEEN :dateFrom AND :dateTo"
//        ),
        @NamedQuery(name = "Holiday.findAllDates", query = "SELECT holiday.date FROM Holiday holiday WHERE holiday.holidayType = com.infoshare.academy.highfive.domain.HolidayType.NATIONAL_HOLIDAY")
        })
@JsonDeserialize(using = CustomHolidayRequestDeserializer.class)
@NamedQueries({
        @NamedQuery(name = "Holiday.findAll", query = "SELECT holiday FROM Holiday holiday"),
        @NamedQuery(name = "Holiday.findAllDates", query = "SELECT holiday.date FROM Holiday holiday WHERE holiday.holidayType = com.infoshare.academy.highfive.domain.HolidayType.NATIONAL_HOLIDAY"),
        @NamedQuery(name = "Holiday.searchByName", query = "SELECT holiday.name FROM Holiday holiday WHERE holiday.name LIKE %:searchName%"),
//        @NamedQuery(name = "Holiday.searchByDate", query = "SELECT holiday.date FROM Holiday holiday WHERE holiday.date = ")
//        List<holiday> searchHolidayByNameLike(@Param("searchName") String searchName);
}
)

@Entity
@Table(name = "holiday")
public class Holiday {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "month", nullable = false)
    private int month;

    @Column(name = "day", nullable = false)
    private int day;

    @Enumerated(EnumType.STRING)
    @Column(name = "holiday_type")
    private HolidayType holidayType;

    public Holiday() {
    }

    public Holiday(String name, String description, LocalDate date, HolidayType holidayType) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.holidayType = holidayType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public HolidayType getHolidayType() {
        return holidayType;
    }

    public void setHolidayType(HolidayType holidayType) {
        this.holidayType = holidayType;
    }
}
