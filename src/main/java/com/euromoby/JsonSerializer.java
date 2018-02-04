package com.euromoby;

import com.euromoby.util.Strings;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class JsonSerializer {

    private static final String NULL_STRING = Strings.quotes("null");

    public String serialize(Object o) {
        return NULL_STRING;
    }

    public String serializeInteger(Integer i) {
        return String.valueOf(i);
    }

    public String serializeFloat(Float f) {
        return String.valueOf(f);
    }

    public String serializeDouble(Double d) {
        return String.valueOf(d);
    }

}
