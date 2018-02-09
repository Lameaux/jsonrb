package com.euromoby.deserializer;

import com.euromoby.serializer.DateSerializer;
import com.euromoby.serializer.StringSerializer;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class StringDeserializerTest {

    StringSerializer serializer = new StringSerializer();
    StringDeserializer deserializer = new StringDeserializer();

    @Test
    public void deserializeString() {
        assertEquals(null, deserializer.deserialize("null"));

        String s = "m\"y\\s\bt\fccc\rr\nin\tg";
        String serialized = serializer.serialize(s);
        assertEquals(s, deserializer.deserialize(serialized));
    }

}
