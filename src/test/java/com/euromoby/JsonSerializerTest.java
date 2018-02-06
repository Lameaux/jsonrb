package com.euromoby;

import org.junit.*;

import java.util.Date;

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
        String string = "Hello";
        Boolean boolTrue = true;
        boolean boolFalse = false;
        Integer i1 = 1;
        int i2 = 2;
    }

    @Test
    public void serializeObject() {
        TestClass tc = new TestClass();
        assertEquals(
                "{\"string\":\"Hello\",\"boolTrue\":true,\"boolFalse\":false,\"i1\":1,\"i2\":2}",
                serializer.serialize(tc)
        );
    }

}
