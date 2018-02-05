package com.euromoby.serializer;

import com.euromoby.JsonSerializer;
import org.junit.Test;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import static org.junit.Assert.*;

public class DateSerializerTest {
    DateSerializer serializer = new DateSerializer();

    Date letDate() {
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        GregorianCalendar c = new GregorianCalendar(2010, 11 - 1, 12, 13, 14, 15);
        c.setTimeZone(timeZone);
        Date d = c.getTime();
        return d;
    }

    @Test
    public void serializeDate() {
        assertEquals("null", serializer.serialize(null));
        assertEquals("\"2010-11-12T13:14:15Z\"", serializer.serialize(letDate()));
    }
}
