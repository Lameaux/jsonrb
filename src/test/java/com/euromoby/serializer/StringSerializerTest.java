package com.euromoby.serializer;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringSerializerTest {
    StringSerializer serializer = new StringSerializer();

    @Test
    public void serializeString() {
        assertEquals("null", serializer.serialize(null));
        assertEquals("\"my string\"", serializer.serialize("my string"));
    }
}
