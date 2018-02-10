package com.euromoby.serializer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DoubleSerializerTest {
    DoubleSerializer serializer = new DoubleSerializer();

    @Test
    public void serializeNull() {
        assertEquals("null", serializer.serialize(null));
    }

    @Test
    public void serializeDouble() {
        for (double d = -100.123; d <= 100.123; d++) {
            assertEquals(String.valueOf(d), serializer.serialize(d));
        }
    }
}
