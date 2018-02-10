package com.euromoby.deserializer;

import com.euromoby.exception.JsonException;
import com.euromoby.util.Objects;

public class DoubleDeserializer implements TypeDeserializer<Double> {

    @Override
    public Double deserialize(String s) {
        if (Objects.NULL.equals(s)) return null;
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            throw new JsonException("Invalid Double value: " + s, e);
        }
    }
}
