package com.infoshare.academy.highfive.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.infoshare.academy.highfive.domain.Holiday;
import com.infoshare.academy.highfive.domain.HolidayType;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomHolidayRequestDeserializer extends StdDeserializer<Holiday> {


    public CustomHolidayRequestDeserializer() {
        this(null);
    }

    private CustomHolidayRequestDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Holiday deserialize(JsonParser jp, DeserializationContext context)
            throws IOException {
        JsonNode node = jp.getCodec().readTree(jp);

        String name = node.get("name").asText();

        String description = node.get("description").asText();

        if (description.equals("null")) {

            description = null;
        }

        String isoDate = node.get("date").findValue("iso").asText();
        LocalDate date = LocalDate.parse(isoDate.substring(0, 10), DateTimeFormatter.ISO_DATE);

        String array = node.get("type").get(0).asText();
        HolidayType holidayType;

        switch (array) {
            case "National holiday":
                holidayType = HolidayType.NATIONAL_HOLIDAY;
                break;
            case "Observance":
                holidayType = HolidayType.OBSERVANCE;
                break;
            default:
                holidayType = HolidayType.SEASON;
                break;
        }

        Holiday holiday = new Holiday(name, description, date, holidayType);

        return holiday;
    }
}