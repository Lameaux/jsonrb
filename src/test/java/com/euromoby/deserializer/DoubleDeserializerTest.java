package com.euromoby.deserializer;

import com.euromoby.exception.JsonException;
import com.euromoby.serializer.DoubleSerializer;
import com.euromoby.serializer.FloatSerializer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DoubleDeserializerTest {

    DoubleSerializer serializer = new DoubleSerializer();
    DoubleDeserializer deserializer = new DoubleDeserializer();

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
        for (double d = -100.123; d <= 100.123; d++) {
            String doubleString = serializer.serialize(d);
            assertEquals((Double)d, deserializer.deserialize(doubleString));
        }
    }

}
