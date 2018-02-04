package com.euromoby.serializer;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import static com.euromoby.util.Strings.quotes;

public class DateSerializer {

    private static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone("UTC");

    public String serialize(Date d) {
        return serialize(d, TIMEZONE_UTC);
    }

    public String serialize(Date d, TimeZone t) {
        Calendar c = GregorianCalendar.getInstance();
        c.setTime(d);
        c.setTimeZone(t);
        return quotes(javax.xml.bind.DatatypeConverter.printDateTime(c));
    }
}
