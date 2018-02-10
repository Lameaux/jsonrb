package com.euromoby.deserializer;

import com.euromoby.exception.JsonException;
import com.euromoby.serializer.BooleanSerializer;
import com.euromoby.serializer.IntegerSerializer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntegerDeserializerTest {

    IntegerSerializer serializer = new IntegerSerializer();
    IntegerDeserializer deserializer = new IntegerDeserializer();

    @Test
    public void deserializeString() {
        assertEquals(null, deserializer.deserialize("null"));

        for (int i = -100; i <= 100; i++) {
            String integerString = serializer.serialize(i);
            assertEquals((Integer)i, deserializer.deserialize(integerString));
        }
    }

    @Test(expected = JsonException.class)
    public void invalidInput() {
        deserializer.deserialize("foo");
    }

}
