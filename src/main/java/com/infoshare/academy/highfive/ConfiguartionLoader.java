package com.infoshare.academy.highfive;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class ConfiguartionLoader {

    private static Properties properties;

    static {
        properties = initProperties();
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
        String dateFormat = properties.getProperty("dateFormat");
        return dateFormat == null ? DateTimeFormatter.ISO_DATE : DateTimeFormatter.ofPattern(dateFormat);
    }

    public static String getSortType(){
        return properties.getProperty("sortType");
    }

}
