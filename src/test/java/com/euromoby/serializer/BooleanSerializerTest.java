package com.euromoby.serializer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BooleanSerializerTest {
    BooleanSerializer serializer = new BooleanSerializer();

    @Test
    public void serializeNull() {
        assertEquals("null", serializer.serialize(null));
    }

    @Test
    public void serializeBoolean() {
        assertEquals("true", serializer.serialize(Boolean.TRUE));
        assertEquals("false", serializer.serialize(Boolean.FALSE));
    }
}
