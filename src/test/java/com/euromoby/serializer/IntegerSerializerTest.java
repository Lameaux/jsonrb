package com.euromoby.serializer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntegerSerializerTest {
    IntegerSerializer serializer = new IntegerSerializer();

    @Test
    public void serializeInteger() {
        assertEquals("null", serializer.serialize(null));
        for (int i = -100; i <= 100; i++) {
            assertEquals(String.valueOf(i), serializer.serialize(i));
        }
    }
}
