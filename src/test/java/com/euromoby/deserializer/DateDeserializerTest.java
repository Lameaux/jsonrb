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
    public void deserializeNull() {
        assertEquals(null, deserializer.deserialize("null"));
    }

    @Test(expected = JsonException.class)
    public void invalidInput() {
        deserializer.deserialize("foo");
    }

    @Test
    public void deserializeDate() {
        Date date = new Date();
        String s = serializer.serialize(date);
        assertEquals(date, deserializer.deserialize(s));
    }
}
