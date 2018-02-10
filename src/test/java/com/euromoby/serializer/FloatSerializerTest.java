package com.euromoby.serializer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FloatSerializerTest {
    FloatSerializer serializer = new FloatSerializer();

    @Test
    public void serializeNull() {
        assertEquals("null", serializer.serialize(null));
    }

    @Test
    public void serializeFloat() {
        for (float f = -100.123f; f <= 100.123f; f++) {
            assertEquals(String.valueOf(f), serializer.serialize(f));
        }
    }
}
