package com.euromoby.deserializer;

import com.euromoby.exception.JsonException;
import com.euromoby.util.Objects;

public class BooleanDeserializer implements Deserializer<Boolean> {

    @Override
    public Boolean deserialize(String s) {
        if (Objects.NULL.equals(s)) {
            return null;
        }
        if (Objects.TRUE.equals(s)) {
            return true;
        }
        if (Objects.FALSE.equals(s)) {
            return false;
        }

        throw new JsonException("Invalid Boolean value: " + s);
    }
}
