package com.infoshare.academy.highfive.tool;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.infoshare.academy.highfive.holiday.HolidayDate;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomHolidayDateDeserializer extends StdDeserializer<HolidayDate> {


    public CustomHolidayDateDeserializer() {
        this(null);
    }

    public CustomHolidayDateDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public HolidayDate deserialize(JsonParser jp, DeserializationContext context)
            throws IOException {
        JsonNode node = jp.getCodec().readTree(jp);
        String isoDate = node.get("iso").asText();
        LocalDate date = LocalDate.parse(isoDate.substring(0, 10), DateTimeFormatter.ISO_DATE);

        return new HolidayDate(date);
    }

}
