package com.euromoby.deserializer;

import com.euromoby.exception.JsonException;
import com.euromoby.serializer.DateSerializer;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class DateDeserializerTest {

    DateSerializer serializer = new DateSerializer();
    DateDeserializer deserializer = new DateDeserializer();

    @Test
    public void deserializeDate() {
        assertEquals(null, deserializer.deserialize("null"));

        Date date = new Date();
        String s = serializer.serialize(date);
        assertEquals(date, deserializer.deserialize(s));
    }

    @Test(expected = JsonException.class)
    public void invalidInput() {
        deserializer.deserialize("foo");
    }
}
