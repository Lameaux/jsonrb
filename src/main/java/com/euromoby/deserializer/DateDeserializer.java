package com.euromoby.deserializer;

import com.euromoby.util.Objects;
import com.euromoby.util.Strings;

import java.util.Calendar;
import java.util.Date;

public class DateDeserializer implements Deserializer<Date> {

    @Override
    public Date deserialize(String s) {
        if (Objects.NULL.equals(s)) return null;
        String dateString = Strings.dequote(s);
        Calendar c = javax.xml.bind.DatatypeConverter.parseDateTime(dateString);
        return c.getTime();
    }
}
