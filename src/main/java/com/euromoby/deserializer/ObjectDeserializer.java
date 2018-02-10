package com.euromoby.deserializer;

import com.euromoby.exception.JsonException;
import com.euromoby.util.Objects;
import com.euromoby.util.Strings;

import java.lang.reflect.Array;

public class ObjectDeserializer {

    public Object deserialize(String s, Class clazz) {
        if (Objects.NULL.equals(s)) return null;

        try {
            if (s.charAt(0) == Strings.OBJECT_START) {
                return deserializeObject(s, clazz);
            }
            if (s.charAt(0) == Strings.ARRAY_START) {
                return deserializeObject(s, clazz);
            }
        } catch (Exception e) {
            throw new JsonException("Invalid Object value: " + s, e);
        }

        throw new JsonException("Invalid Object value: " + s);
    }

    public Object deserializeObject(String s, Class clazz) throws Exception {
        Object instance = clazz.newInstance();
        return instance;
    }

    public Object deserializeArray(String s, Class clazz) {

            Object array = Array.newInstance(clazz, 0);
            return array;

    }

}
