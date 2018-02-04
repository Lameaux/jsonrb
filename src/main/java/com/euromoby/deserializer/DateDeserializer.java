package com.euromoby.deserializer;

import java.util.Calendar;
import java.util.Date;

public class DateDeserializer {
    public Date parse(String s) {
        Calendar c = javax.xml.bind.DatatypeConverter.parseDateTime(s);
        return c.getTime();
    }
}
