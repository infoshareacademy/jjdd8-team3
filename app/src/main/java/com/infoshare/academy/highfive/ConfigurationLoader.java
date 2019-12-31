package com.infoshare.academy.highfive;


import com.infoshare.academy.highfive.employeemanager.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Properties;

public class ConfigurationLoader {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    private static final Comparator<Employee> COMPARATOR_ASC = Comparator.comparing(Employee::getSurname).thenComparing(Employee::getFirstName);

    private static final Comparator<Employee> COMPARATOR_DESC = (left, right) -> {
        int compareResult = left.getSurname().compareTo(right.getSurname());
        return (-1)*(compareResult != 0 ? compareResult : left.getFirstName().compareTo(right.getFirstName()));
    };

    private static Properties properties = null;

    private static Properties getProperties(){
        if (properties == null){
            properties = initProperties();
        }
        return properties;
    }

    private static Properties initProperties() {
        Properties prop = new Properties();
        try (InputStream input = new FileInputStream("config.properties")) {
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }

    public static DateTimeFormatter getDateFormatter(){
        String dateFormat = getProperties().getProperty("dateFormat");
        return dateFormat == null ? DateTimeFormatter.ISO_DATE : DateTimeFormatter.ofPattern(dateFormat);
    }

    public static Comparator<Employee> getComparator(){
        String sortType = getProperties().getProperty("sortType");
        stdout.debug("sortType={}", sortType);
        return "ASC".equals(sortType) ? COMPARATOR_ASC : COMPARATOR_DESC;
    }

}
