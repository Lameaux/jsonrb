package com.euromoby.deserializer;

import com.euromoby.exception.JsonException;
import com.euromoby.util.Objects;

public class FloatDeserializer implements TypeDeserializer<Float> {

    @Override
    public Float deserialize(String s) {
        if (Objects.NULL.equals(s)) return null;
        try {
            return Float.parseFloat(s);
        } catch (NumberFormatException e) {
            throw new JsonException("Invalid Float value: " + s, e);
        }
    }
}
