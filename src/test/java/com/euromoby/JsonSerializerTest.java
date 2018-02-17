package com.euromoby;

import com.euromoby.model.TestClass;
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

    @Test
    public void serializeObject() {
        TestClass tc = new TestClass();
        assertEquals(
                "{\"string\":\"Hello\",\"boolTrue\":true,\"boolFalse\":false,\"i1\":1,\"i2\":2}",
                serializer.serialize(tc)
        );
    }

}
