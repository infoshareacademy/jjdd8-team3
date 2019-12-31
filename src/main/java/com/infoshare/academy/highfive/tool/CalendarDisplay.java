package com.infoshare.academy.highfive.tool;

import com.infoshare.academy.highfive.holiday.HolidayType;
import com.infoshare.academy.highfive.holiday.HolidaysSingleton;
import com.infoshare.academy.highfive.vacation.Vacation;
import com.infoshare.academy.highfive.vacation.VacationSingleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;

public class CalendarDisplay {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
/*    private static final String FILE_NAME = "Holidays.json";
    public static final String FILE_NAME_FOR_EMPLOYEE = "employee_fdb.json";
    private static final String VACATION_FILENAME = "Vacation.json";*/


    public static void printMothsCalendar(Integer employeeId) {
        List<Vacation> vacationList = VacationSingleton.getInstance().getVacationList();

        List<LocalDate> vacationDays = new ArrayList<>();

        for (Vacation vacation : vacationList) {
            vacationDays.addAll(LocalDate.parse(vacation.getDateFrom()).datesUntil(LocalDate.parse(vacation.getDateTo())).collect(Collectors.toList()));
        }

        Map<LocalDate, List<LocalDate>> byMonth = vacationDays.stream()
                .collect(groupingBy(d -> d.withDayOfMonth(1)));

        for (LocalDate localDate : byMonth.keySet()) {
            printMonth(localDate, byMonth.get(localDate).stream().mapToInt(LocalDate::getDayOfMonth).toArray());
        }
    }

    private static void printMonth(LocalDate date, int[] employeeVacationDaysInMonth) {
        LocalDate finalDate = date;
        date = date.minusDays(date.getDayOfMonth() - 1);
        Month month = date.getMonth();
        int days = month.length(date.isLeapYear());
        int firstWeekDay = date.getDayOfWeek().getValue() - 1;

        int[] holidaysForCalendar = HolidaysSingleton.getInstance().getAllHolidays().stream().filter(h -> Array.get(h.getTypes(), 0).equals(HolidayType.NATIONAL_HOLIDAY))
                .map(hn -> hn.getDate().getDate()).filter(d -> d.getMonth().equals(finalDate.getMonth())).mapToInt(LocalDate::getDayOfMonth).toArray();

        stdout.info("\n-----------------\n");
        stdout.info(month.toString() + " " + date.getYear() + "\n");
        for (var weekday : DayOfWeek.values()) {
            stdout.info(weekday.name().substring(0, 2) + "\t");
        }
        stdout.info("\n");
        for (int i = 0; i < firstWeekDay; ++i) {
            stdout.info("  \t");
        }
        for (int day = 1; day <= days; ++day) {
            int finalDay = day;
            if (IntStream.of(employeeVacationDaysInMonth).anyMatch(x -> x == finalDay)) {
                stdout.info(ColorsSet.ANSI_BLUE);
            }
            if ((day + firstWeekDay) % 7 == 6) {
                stdout.info(ColorsSet.ANSI_YELLOW);
            }

            if (IntStream.of(holidaysForCalendar).anyMatch(x -> x == finalDay)) {
                stdout.info(ColorsSet.ANSI_RED);
            }
            if ((day + firstWeekDay) % 7 == 0) {
                stdout.info(ColorsSet.ANSI_RED);
            }
            stdout.info(day + "\t");
            stdout.info(ColorsSet.ANSI_RESET);

            if ((day + firstWeekDay) % 7 == 0) {
                stdout.info(ColorsSet.ANSI_RESET + "\n");
            }
        }
        stdout.info("\n");
    }


/*    public static void main(String[] args) throws IOException {
        HolidaysSingleton.getInstance().initFromFile(FILE_NAME);
        EmployeeManagementSingleton.getInstance().initEmployeesDb(FILE_NAME_FOR_EMPLOYEE);
        VacationSingleton.getInstance().initFromFile(VACATION_FILENAME);
        VacationSingleton.getInstance().getVacationList();
        printMothsCalendar(1);
    }*/
}
