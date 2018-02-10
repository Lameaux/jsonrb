package com.euromoby.deserializer;

import com.euromoby.exception.JsonException;
import com.euromoby.serializer.BooleanSerializer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BooleanDeserializerTest {

    BooleanSerializer serializer = new BooleanSerializer();
    BooleanDeserializer deserializer = new BooleanDeserializer();

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
        String trueString = serializer.serialize(true);
        assertEquals(true, deserializer.deserialize(trueString));

        String falseString = serializer.serialize(false);
        assertEquals(false, deserializer.deserialize(falseString));
    }

}
