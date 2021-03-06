package com.euromoby.deserializer;

import com.euromoby.exception.JsonException;
import com.euromoby.util.Objects;

public class IntegerDeserializer implements TypeDeserializer<Integer> {

    @Override
    public Integer deserialize(String s) {
        if (Objects.NULL.equals(s)) return null;
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new JsonException("Invalid Integer value: " + s, e);
        }
    }
}
