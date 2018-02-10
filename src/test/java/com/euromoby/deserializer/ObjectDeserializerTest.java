package com.euromoby.deserializer;

import com.euromoby.exception.JsonException;
import com.euromoby.serializer.DateSerializer;
import com.euromoby.serializer.ObjectSerializer;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ObjectDeserializerTest {

    ObjectSerializer serializer = new ObjectSerializer();
    ObjectDeserializer deserializer = new ObjectDeserializer();

    @Test
    public void deserializeNull() {
        assertEquals(null, deserializer.deserialize("null", Object.class));
    }

    @Test(expected = JsonException.class)
    public void invalidInput() {
        deserializer.deserialize("foo", Object.class);
    }

    @Test
    public void deserializeObject() {
        assertEquals(null, deserializer.deserialize("null", Object.class));
    }

    @Test
    public void deserializeArray() {
        assertEquals(null, deserializer.deserialize("null", Object[].class));
    }

}
