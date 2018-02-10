package com.euromoby.serializer;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringSerializerTest {
    StringSerializer serializer = new StringSerializer();

    @Test
    public void serializeNull() {
        assertEquals("null", serializer.serialize(null));
    }

    @Test
    public void serializeString() {
        assertEquals("\"my string\"", serializer.serialize("my string"));
    }
}
