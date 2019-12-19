package com.infoshare.academy.highfive.tool;

import com.infoshare.academy.highfive.employeemanager.EmployeeManagementSingleton;
import com.infoshare.academy.highfive.holiday.HolidayType;
import com.infoshare.academy.highfive.holiday.HolidaysSingleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.Array;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CalendarDisplay {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final String FILE_NAME = "Holidays.json";
    public static final String FILE_NAME_FOR_EMPLOYEE = "employee_fdb.json";

    private static void printMothsCalendar(Integer employeeId){

        String[] datesArray = { "2019-11-04","2019-11-05", "2019-11-06", "2019-11-03", "2019-11-04", "2019-11-05", "2019-12-23", "2019-12-24"};
        List<List<String>> partitions = Arrays.stream(datesArray)
               .collect(Collectors.groupingBy(e -> LocalDate.parse(e.substring(0,7)+"-01", DateTimeFormatter.ofPattern("yyyy-MM-dd")), TreeMap::new, Collectors.toList())).values().stream().collect(Collectors.toList());


        List<String> xxx = Arrays.asList(datesArray);
      //  Map<String,String> bbb = xxx.stream().collect(Collectors.groupingBy(e->LocalDate.parse(e.substring(0,7)+"-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"))))

        
    }

    private static void printMonth(LocalDate date, int[] employeeVacationDaysInMonth) {
        LocalDate finalDate = date;
        date = date.minusDays(date.getDayOfMonth() - 1);
        Month month = date.getMonth();
        int days = month.length(date.isLeapYear());
        int firstWeekDay = date.getDayOfWeek().getValue() - 1;

        int[] holidaysForCalendar = HolidaysSingleton.getInstance().getAllHolidays().stream().filter(h-> Array.get(h.getTypes(),0).equals(HolidayType.NATIONAL_HOLIDAY))
                .map(hn->hn.getDate().getDate()).filter(d->d.getMonth().equals(finalDate.getMonth())).mapToInt(dInt->dInt.getDayOfMonth()).toArray();


        stdout.info(month.toString() + " " + date.getYear() + "\n");
        for (var weekday : DayOfWeek.values()) {
            stdout.info(weekday.name().substring(0, 2) + "\t");
        }
        stdout.info("\n");
        for (int i = 0; i < firstWeekDay; ++i) {
            stdout.info("  \t");
        }
        for (int day = 1; day <= days; ++day) {

            if ((day + firstWeekDay) % 7 == 6){
                stdout.info(ColorsSet.ANSI_YELLOW + day + "\t" + ColorsSet.ANSI_RESET);
            } else {
                int finalDay = day;
                if (IntStream.of(holidaysForCalendar).anyMatch(x -> x == finalDay)) {
                    stdout.info(ColorsSet.ANSI_RED + day + "\t" + ColorsSet.ANSI_RESET);
                } else if ((day + firstWeekDay) % 7 == 0) {
                    stdout.info(ColorsSet.ANSI_RED + day + "\t" + ColorsSet.ANSI_RESET);
                } else {
                    stdout.info(day + "\t");
                }
            }
            if ((day + firstWeekDay) % 7 == 0) {
                stdout.info(ColorsSet.ANSI_RESET + "\n");
            }
        }
        stdout.info("\n");
    }


    public static void main(String[] args) throws IOException {

        HolidaysSingleton.getInstance().initFromFile(FILE_NAME);
        EmployeeManagementSingleton.getInstance().initEmployeesDb(FILE_NAME_FOR_EMPLOYEE);

        printMonth(LocalDate.parse("2019-11-01"),null);

        List<LocalDate> holidaysForCalendar = HolidaysSingleton.getInstance().getAllHolidays().stream().filter(h-> Array.get(h.getTypes(),0).equals(HolidayType.NATIONAL_HOLIDAY))
                .map(hn->hn.getDate().getDate()).filter(d->d.getMonth().equals(LocalDate.parse("2019-12-01").getMonth()))
                .collect(Collectors.toList());


        printMothsCalendar(1);
       //List<LocalDate>  aaa = holidaysForCalendar.stream().filter(d->d.getMonth().equals(LocalDate.parse("2019-12-01").getMonth())).collect(Collectors.toList());//.forEach(d->System.out.println(d.getDayOfMonth()));

        //holidaysForCalendar.stream().forEach(d->System.out.println(d.getDayOfMonth()));


/*        int year=2016;
        int month=10;
        calendar.set(year, 10- 1, 1);
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        ArrayList<Date> sundays = new ArrayList<Date>();>

        for (int d = 1;  d <= daysInMonth;  d++) {
            calendar.set(Calendar.DAY_OF_MONTH, d);
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek==Calendar.SUNDAY) {
                calendar.add(Calendar.DATE, d);
                sundays.add(calendar.getTime());
            }
        }*/
    }
}

