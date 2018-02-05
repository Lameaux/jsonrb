package com.euromoby.serializer;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ObjectSerializerTest {
    ObjectSerializer serializer = new ObjectSerializer();

    @Test
    public void serializeNull() {
        assertEquals("null", serializer.serialize(null));
    }
}
