package com.euromoby.serializer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DoubleSerializerTest {
    DoubleSerializer serializer = new DoubleSerializer();

    @Test
    public void serializeDouble() {
        assertEquals("null", serializer.serialize(null));
        for (double d = -100.123; d <= 100.123; d++) {
            assertEquals(String.valueOf(d), serializer.serialize(d));
        }
    }
}
