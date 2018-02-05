package com.euromoby;

import org.junit.*;

import static org.junit.Assert.*;

public class JsonSerializerTest {
    JsonSerializer serializer = new JsonSerializer();

    @Test
    public void serializeNull() {
        assertEquals("null", serializer.serialize(null));
    }

    @Test
    public void serializeString() {
        assertEquals("\"hello\"", serializer.serialize("hello"));
    }

    public class TestClass {
        String s = "string";
    }

    @Test
    public void serializeObject() {
        TestClass tc = new TestClass();
        assertEquals("{\"s\":\"string\"}", serializer.serialize(tc));
    }

}
