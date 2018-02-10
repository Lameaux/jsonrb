package com.euromoby.deserializer;

import com.euromoby.exception.JsonException;
import com.euromoby.serializer.FloatSerializer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FloatDeserializerTest {

    FloatSerializer serializer = new FloatSerializer();
    FloatDeserializer deserializer = new FloatDeserializer();

    @Test
    public void deserializeNull() {
        assertEquals(null, deserializer.deserialize("null"));
    }

    @Test(expected = JsonException.class)
    public void invalidInput() {
        deserializer.deserialize("foo");
    }

    @Test
    public void deserializeString() {
        for (float f = -100.123f; f <= 100.123f; f++) {
            String floatString = serializer.serialize(f);
            assertEquals((Float)f, deserializer.deserialize(floatString));
        }
    }

}
