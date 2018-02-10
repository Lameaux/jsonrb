package com.euromoby.deserializer;

import com.euromoby.exception.JsonException;
import com.euromoby.util.Objects;
import com.euromoby.util.Strings;

import java.util.Calendar;
import java.util.Date;

public class DateDeserializer implements TypeDeserializer<Date> {

    @Override
    public Date deserialize(String s) {
        if (Objects.NULL.equals(s)) return null;
        String dateString = Strings.dequote(s);
        try {
            Calendar c = javax.xml.bind.DatatypeConverter.parseDateTime(dateString);
            return c.getTime();
        } catch (IllegalArgumentException e) {
            throw new JsonException("Invalid Date value: " + s, e);
        }
    }
}
