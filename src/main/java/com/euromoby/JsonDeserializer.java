package com.euromoby;

import com.euromoby.deserializer.ObjectDeserializer;
import com.euromoby.exception.JsonException;

public class JsonDeserializer {

    ObjectDeserializer objectDeserializer = new ObjectDeserializer();

    public Object deserialize(String string, Class clazz) {
        if (string == null) {
            throw new JsonException("Input is null");
        }
        return objectDeserializer.deserialize(string, clazz);
    }

}
