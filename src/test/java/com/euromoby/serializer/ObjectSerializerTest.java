package com.euromoby.serializer;

import com.euromoby.model.SimpleClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ObjectSerializerTest {
    ObjectSerializer compactSerializer = new ObjectSerializer(false, true);
    ObjectSerializer prettySerializer = new ObjectSerializer(true, false);

    @Test
    public void serializeNull() {
        assertEquals("null", compactSerializer.serialize(null));
        assertEquals("null", prettySerializer.serialize(null));
    }

    @Test
    public void serializeEmptyObject() {
        assertEquals("{}", compactSerializer.serialize(new Object()));
        assertEquals("{\r\n}", prettySerializer.serialize(new Object()));
    }

    @Test
    public void serializeSimpleClass() {
        assertEquals("{}", compactSerializer.serialize(new SimpleClass()));
        assertEquals("{\r\n\t\"message\": null\r\n}", prettySerializer.serialize(new SimpleClass()));
    }
}
