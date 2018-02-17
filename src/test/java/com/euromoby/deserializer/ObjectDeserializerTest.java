package com.euromoby.deserializer;

import com.euromoby.exception.JsonException;
import com.euromoby.model.SimpleClass;
import com.euromoby.serializer.ObjectSerializer;
import org.junit.Test;

import static org.junit.Assert.*;

public class ObjectDeserializerTest {

    ObjectSerializer serializer = new ObjectSerializer();
    ObjectDeserializer deserializer = new ObjectDeserializer();

    @Test
    public void deserializeNull() {
        assertEquals(null, deserializer.deserialize("null", SimpleClass.class));
    }

    @Test(expected = JsonException.class)
    public void invalidInput() {
        deserializer.deserialize("foo", SimpleClass.class);
    }

    @Test
    public void deserializeEmptyObject() {
        assertEquals(new SimpleClass(), deserializer.deserialize("{}", SimpleClass.class));
    }

    @Test
    public void deserializeEmptyArray() {
        assertArrayEquals(new SimpleClass[] {}, deserializer.deserialize("[]", SimpleClass[].class));
    }

    @Test
    public void deserializeEmptyMessage() {
        assertEquals(new SimpleClass(), deserializer.deserialize("{}", SimpleClass.class));
    }

    @Test
    public void deserializeMessage() {
        assertEquals(new SimpleClass("message"), deserializer.deserialize("{\"message\":\"message\"}", SimpleClass.class));
    }

}
