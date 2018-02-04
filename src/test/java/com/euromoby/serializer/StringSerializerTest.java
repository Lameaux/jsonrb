package com.euromoby.serializer;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringSerializerTest {
    StringSerializer serializer = new StringSerializer();

    @Test
    public void serializeString() {
        String string = "my string";
        String expected = "\"my string\"";
        assertEquals(expected, serializer.serialize(string));
    }
}
