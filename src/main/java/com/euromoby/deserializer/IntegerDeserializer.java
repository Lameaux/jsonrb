package com.euromoby.deserializer;

import com.euromoby.exception.JsonException;
import com.euromoby.util.Objects;
import com.euromoby.util.Strings;

import java.util.Calendar;
import java.util.Date;

public class IntegerDeserializer implements Deserializer<Integer> {

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
