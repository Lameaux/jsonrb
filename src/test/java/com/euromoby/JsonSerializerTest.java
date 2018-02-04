package com.euromoby;

import org.junit.*;

import static org.junit.Assert.*;

public class JsonSerializerTest {
    JsonSerializer serializer = new JsonSerializer();

    @Test
    public void nullString() {
        assertEquals("\"null\"", serializer.serialize(null));
    }
}
