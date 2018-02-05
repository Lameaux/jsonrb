package com.euromoby.serializer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FloatSerializerTest {
    FloatSerializer serializer = new FloatSerializer();

    @Test
    public void serializeFloat() {
        assertEquals("null", serializer.serialize(null));
        for (float f = -100.123f; f <= 100.123f; f++) {
            assertEquals(String.valueOf(f), serializer.serialize(f));
        }
    }
}
