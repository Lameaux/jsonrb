package com.euromoby.deserializer;

import com.euromoby.serializer.StringSerializer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringDeserializerTest {

    StringSerializer serializer = new StringSerializer();
    StringDeserializer deserializer = new StringDeserializer();

    @Test
    public void deserializeNull() {
        assertEquals(null, deserializer.deserialize("null"));
    }

    @Test
    public void deserializeString() {
        String s = "m\"y\\s\bt\fccc\rr\nin\tg";
        String serialized = serializer.serialize(s);
        assertEquals(s, deserializer.deserialize(serialized));
    }

}
